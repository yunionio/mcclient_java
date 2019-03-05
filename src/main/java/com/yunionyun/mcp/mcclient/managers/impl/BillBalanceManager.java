package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.managers.MeterManager;

public class BillBalanceManager extends MeterManager
{
    public BillBalanceManager()
    {
        super("bill_balance", "bill_balances", 
                new String[] {"ID", "account", "account_name", "balance", "provider", "status"},
                new String[] {});
    }
}
