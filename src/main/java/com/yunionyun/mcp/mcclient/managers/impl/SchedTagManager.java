package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.managers.ComputeManager;

public class SchedTagManager extends ComputeManager {
	public SchedTagManager() {
		super("schedtag", "schedtags",
               new String[] {"ID", "Name", "Default_strategy"},
             new String[] {});
	}
	/*Schedtags = NewComputeManager("schedtag", "schedtags",
            []string{"ID", "Name", "Default_strategy"},
         []string{})*/
 }
