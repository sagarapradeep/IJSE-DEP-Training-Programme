package com.microsoft.dbms;

public class SQLServer {
    public StringBuilder interpret(byte[] command) {
        return new StringBuilder().append("MySql Server").append(new String(command));
    }


}
