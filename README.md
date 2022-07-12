# Cloudpods Java SDK

Cloudpods Java SDK为访问多云平台API的Java SDK。实现了账号认证，获取认证token，并携带token，构造HTTP REST API访问各类资源接口的功能。SDK下载地址为：

```
https://github.com/yunionio/mcclient_java
```

## 1. 主要的类

主要的类如下：

* Client：API客户端
* TokenCredential: 认证获得的token
* Session：一个session
* AuthAgent：一个长期运行的客户端Agent
* 资源类，如ServerManager


### 1.1 Client: 客户端实例

Client类的主要方法如下：

#### 1) Client构造函数

```java
public Client(String authUrl, int timeout, boolean debug, boolean insecure)
```

参数说明如下：

* authUrl(String): keystone服务的认证URL，通常为 https://<master_ip>:30500/v3，其中master_ip为Cloudpods部署实例的服务IP
* timeout(int):  访问APIde的超时时间，一般设置为60（单位秒）
* debug(boolean): 是否开启debug模式，开启后，会输出debug日志。初期方便排查问题，一般设置为true
* insecure(boolean): 是否接受自签名的https证书，一般设置为true

返回值：Client实例

#### 2) Client.Authenticate

认证接口，初始化Client之后，调用该接口认证，认证成功获得token（TokenCredential）。

```java
public TokenCredential Authenticate(String user, String passwd, String domain, String project, String projectDomain)
```

参数说明如下：

* user(String): 用户名，该参数必填
* passwd(String): 用户密码，该参数必填
* domain(String): 用户归属域，该参数可选，不指定，则为默认域（Default域）
* project(String): 用户归属项目，该参数必填。用户加入项目需要指定角色。用户认证后，将具备该用户在该项目的角色具有的权限。
* projectDomain(String): 该参数可选，如果不指定，则为默认域（Default域）


#### 3) Client.newSession

初始化Client并认证成功后，通过 client.newSession 获得访问API的session实例，用于后续访问服务接口的凭证。

```java
public Session newSession(
			String region,
			String zone,
			EndpointType endpointType,
			TokenCredential token)
```

参数说明如下：

* region(String): 访问的Cloudpods实例的region，一般为"region0"
* zone(String): 访问的可用区，该参数可选。一般为null
* endpointType(String): 访问服务端点的类型，可选值为：internal和public。一般要选择public。只有客户端在部署Cloudpods的Kubernetes集群里运行时，才可以使用internal。
* token(TokenCredential): 调用client.Authenticate认证获得的token，该值必填

返回值：返回一个session，该session包含了token以及环境变量，用于访问各类资源的接口。

### 1.2 AuthAgent: 一个验证token的服务Agent实例

AuthAgent提供了一个长期运行的具有管理员权限的Agent实例，用于验证token，并且也能提供具有admin权限的session，访问资源的API。AuthAgent的主要方法有：

#### 1) AuthAgent构造函数

```java
public AuthAgent(
			String authUrl,
			String domain,
			String user,
			String passwd,
			String project,
			String projectDomain,
			int cacheSize,
			int timeout,
			boolean debug,
			boolean insecure)
```

输入参数：

* authUrl(String): keystone服务的认证URL，通常为 https://<master_ip>:30500/v3，其中master_ip为Cloudpods部署实例的服务IP
* user(String): 用户名，该参数必填
* passwd(String): 用户密码，该参数必填
* domain(String): 用户归属域，该参数可选，不指定，则为默认域（Default域）
* project(String): 用户归属项目，该参数必填。用户加入项目需要指定角色。用户认证后，将具备该用户在该项目的角色具有的权限。
* projectDomain(String): 该参数可选，如果不指定，则为默认域（Default域）
* cacheSize(int): 认证token的缓存大小（token的个数），一般1024。AuthAgent将用于验证用户的token，认证后将被缓存。
* timeout(int):  访问APIde的超时时间，一般设置为60（单位秒）
* debug(boolean): 是否开启debug模式，开启后，会输出debug日志。初期方便排查问题，一般设置为true
* insecure(boolean): 是否接受自签名的https证书，一般设置为true

#### 2) AuthAgent.start

```java
public void start()
public void start_sync_ready()
```

初始化AuthAgent之后，启动AuthAgent。启动后，调用start()方法，AuthAgent将会自动向keystone认证，获得一个adminToken，之后周期性地向keystone认证，刷新adminToken。 start()方法是异步启动认证流程，而start_sync_read()方法是同步启动认证流程。

#### 3) AuthAgent.getAdminSession

该方法返回AuthAgent保存的adminToken生成的session，用于访问API。

```java
public Session getAdminSession(String region, String zone, EndpointType endpointType)
```

参数说明如下：

* region(String): 访问的Cloudpods实例的region，一般为"region0"
* zone(String): 访问的可用区，该参数可选。一般为null
* endpointType(EndpointType): 访问服务端点的类型，可选值为：EndpointType.InternalURL和EndpointType.PublicURL。一般需要选择public。只有客户端在部署Cloudpods的Kubernetes集群里运行时，才可以使用internal。

#### 4) AuthAgent.verify

该方法校验token字符串，并返回一个TokenCredential对象

```java
public TokenCredential verify(String token)
```

### 1.3 资源类

每种云资源都有对应的类，通过这些类的方法实现对该资源的API的访问，这些类基本都实现了如下的方法：

#### 1) List

列出资源，对应`GET /<resources>`的REST API。

```java
public ListResult List(Session s, JSONObject query, ManagerContext[] ctx)
public ListResult List(Session s, JSONObject query, ManagerContext ctx)
public ListResult List(Session s, JSONObject query)
```

输入参数说明如下：
* s(Session): Session实例
* query(JSONObject): 请求URL的query String对应的key: value
* ctx: 请求上下文，每一个ctx对应URL路径的一个`/<resources>/<res_id>`

输出参数为：ListResult，用于存储列表结果

#### 2) Get

获取单个资源的详情，对应`GET /<resources>/<res_id>`的REST API。

```java
public JSONObject Get(Session s, String id, JSONObject query, ManagerContext[] ctx)
public JSONObject Get(Session s, String id, JSONObject query, ManagerContext ctx)
public JSONObject Get(Session s, String id, JSONObject query)
public JSONObject GetById(Session s, String id, JSONObject query, ManagerContext[] ctx)
public JSONObject GetById(Session s, String id, JSONObject query, ManagerContext ctx)
public JSONObject GetById(Session s, String id, JSONObject query)
public JSONObject GetByName(Session s, String name, JSONObject query, ManagerContext[] ctx)
public JSONObject GetByName(Session s, String name, JSONObject query, ManagerContext ctx)
public JSONObject GetByName(Session s, String name, JSONObject query)
```

输入参数说明如下：
* s(Session): Session实例
* id(String): 资源的ID
* query(JSONObject)：请求的REST API URL的query string
* ctx: 请求上下文，每一个ctx对应URL路径的一个`/<resources>/<res_id>`

输出参数为：JSONObject，存储了一个资源的信息

#### 3) Get Specific Attribute

获取某个资源的特性属性的值，对应`GET /<resources>/<res_id>/<attribute>`的REST API。

```java
public JSONObject GetSpecific(Session s, String id, String spec, JSONObject query, ManagerContext[] ctx)
public JSONObject GetSpecific(Session s, String id, String spec, JSONObject query, ManagerContext ctx)
public JSONObject GetSpecific(Session s, String id, String spec, JSONObject query)
```
输入参数说明如下：
* s(Session): Session实例
* id(String): 资源的ID
* spec(String): 属性的名称
* query(JSONObject)：请求的REST API URL的query string
* ctx: 请求上下文，每一个ctx对应URL路径的一个`/<resources>/<res_id>`

输出参数为：JSONObject，存储了一个该资源对应属性的信息

#### 4) Create

新建一个资源，对应`POST /<resources>`的REST API。

```java
public JSONObject Create(Session s, JSONObject params, ManagerContext[] ctx)
public JSONObject Create(Session s, JSONObject params, ManagerContext ctx)
public JSONObject Create(Session s, JSONObject params)
```

输入参数说明如下：
* s(Session): Session实例
* params(JSONObject)：请求的REST API URL的body存储的JSONObject
* ctx: 请求上下文，每一个ctx对应URL路径的一个`/<resources>/<res_id>`

输出参数为：JSONObject，存储了一个新建资源的信息

#### 5) PerformAction

对某个资源执行特定的操作，对应`POST /<resources>/<res_id>/<action>`的REST API。

```java
public JSONObject PerformAction(Session s, String id, String action, JSONObject params, ManagerContext[] ctx)
public JSONObject PerformAction(Session s, String id, String action, JSONObject params, ManagerContext ctx)
public JSONObject PerformAction(Session s, String id, String action, JSONObject params)
```

输入参数说明如下：
* s(Session): Session实例
* id(String): 资源的ID
* action(String): 属性的名称
* params(JSONObject)：请求的REST API的body存储的JSONObject
* ctx: 请求上下文，每一个ctx对应URL路径的一个`/<resources>/<res_id>`

输出参数为：JSONObject，存储了执行操作结果的信息


#### 6) Update

更新指定资源的信息，对应`PUT /<resources>/<res_id>`的REST API。

```java
public JSONObject Update(Session s, String id, JSONObject params, ManagerContext[] ctx)
public JSONObject Update(Session s, String id, JSONObject params, ManagerContext ctx)
public JSONObject Update(Session s, String id, JSONObject params)
```

输入参数说明如下：
* s(Session): Session实例
* id(String): 资源的ID
* params(JSONObject)：请求的REST API的body存储的JSONObject
* ctx: 请求上下文，每一个ctx对应URL路径的一个`/<resources>/<res_id>`

输出参数为：JSONObject，存储了更新操作结果的信息

#### 7) Delete

删除指定资源，对应`DELETE /<resources>/<res_id>`的REST API。

```java
public JSONObject Delete(Session s, String id, ManagerContext[] ctx)
public JSONObject Delete(Session s, String id, ManagerContext[] ctx, JSONObject query)
public JSONObject Delete(Session s, String id, ManagerContext ctx)
public JSONObject Delete(Session s, String id)
```

输入参数说明如下：
* s(Session): Session实例
* id(String): 资源的ID
* ctx: 请求上下文，每一个ctx对应URL路径的一个`/<resources>/<res_id>`
* query(JSONObject)：请求的REST API URL的query string

输出参数为：JSONObject，存储了删除操作结果的信息

## 2. SDK使用流程

### 2.1 仅作为客户端使用

这时候只需要初始化Client

```java
    client = new Client(...) // 具体参数参见代码
    s = client.newSession(...)
    ServerManager mgr = new ServerManager()
    ListResult result = mgr.List(s, null)

    .... // use other manager
```


### 2.2 作为服务的验证token的一个服务

这时候需要初始化Agent。注意Agent会启动一个定时任务，定时更新adminToken。验证用户token需要使用adminToken。

```java
    agent = new AuthAgent(...) // 具体参数参见代码
    agent.start()
    ...
    // token is hidden in http "X-Auth-Token" header
    user_cred = agent.verify(token)
    if (user_cred != null) {
        // pass verification, user user_cred to obtain user's information
    } else {
        // verify failed
    }
```
