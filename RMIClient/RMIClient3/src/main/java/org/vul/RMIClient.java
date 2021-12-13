package org.vul;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class RMIClient {
    public static void main(String[] args) {
        try {
            Context ctx = new InitialContext();
            ctx.lookup("rmi://127.0.0.1:1099/refObj");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
