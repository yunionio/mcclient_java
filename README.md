mcclient java
=========================================

mcclient Java implementation

主要的类
======================================

* Client: 客户端实例
* Session: 一个请求实例，通过 client.newSession 获得
* AuthAgent: 一个验证token的服务Agent实例



仅作为客户端使用
========================================

这时候只需要初始化Client

    client = new Client(...) // 具体参数参见代码
    s = client.newSession(...)
    ServerManager mgr = new ServerManager()
    ListResult result = mgr.List(s, null)

    .... // use other manager



作为服务的验证token的一个服务
=========================================

这时候需要初始化Agent。注意Agent会启动一个定时任务，定时更新adminToken。验证用户token需要使用adminToken。


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
