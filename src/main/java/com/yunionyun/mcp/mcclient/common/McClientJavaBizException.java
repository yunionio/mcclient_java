package com.yunionyun.mcp.mcclient.common;

public class McClientJavaBizException extends Exception
{
    private static final long serialVersionUID = 5244319479451688880L;
    
    private String message;
    
    public McClientJavaBizException(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}
