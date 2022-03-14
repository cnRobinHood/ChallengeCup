package com.example.challengecup;

public class Functions {
    private String funcName;
    private int funcIconSource;

    public Functions(String funcName, int funcIconSource) {
        this.funcName = funcName;
        this.funcIconSource = funcIconSource;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public int getFuncIconSource() {
        return funcIconSource;
    }

    public void setFuncIconSource(int funcIconSource) {
        this.funcIconSource = funcIconSource;
    }
}
