package org.vul;

import org.vul.inter.IHello;
import org.vul.pojo.Person;

import java.rmi.registry.LocateRegistry;

public class RMIClient {

    public static void main(String[] args) throws Exception {
        IHello iHello = (IHello) LocateRegistry.getRegistry("127.0.0.1", 1099).lookup("Hello");
        Person person = iHello.sayHello();
    }
}
