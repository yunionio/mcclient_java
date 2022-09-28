package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

public class ModelArtsPool {

    public class ModelArtsPoolManager extends ComputeManager {
        public ModelArtsPoolManager() {
            this(EndpointType.InternalURL);
        }

        public ModelArtsPoolManager(EndpointType endpointType) {
            super(
                    "modelarts_pool",
                    "modelarts_pools",
                    endpointType,
                    new String[]{
                    },
                    new String[]{});
        }
    }

}
