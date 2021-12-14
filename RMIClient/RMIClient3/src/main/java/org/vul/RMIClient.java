package org.vul;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class RMIClient {
    public static void main(String[] args) {
        // 这里就不应该称之为 RMIClient 了, 这是 JNDIClient
        // JNDIClient 使用 RMI 协议
        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase","true");

        try {
            Context ctx = new InitialContext();
            ctx.lookup("rmi://127.0.0.1:1099/refObj");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
