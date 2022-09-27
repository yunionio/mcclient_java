package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

public class ModelArtsPoolSku {

    public class ModelArtsPoolSkuManager extends ComputeManager {
        public ModelArtsPoolSkuManager() {
            this(EndpointType.InternalURL);
        }

        public ModelArtsPoolSkuManager(EndpointType endpointType) {
            super(
                    "modelarts_pool_sku",
                    "modelarts_pool_skus",
                    endpointType,
                    new String[]{
                    },
                    new String[]{});
        }
    }

}
