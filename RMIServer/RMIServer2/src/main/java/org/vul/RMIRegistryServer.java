package org.vul;

import org.vul.impl.Hello;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIRegistryServer {
    public static void main(String[] args) throws Exception {
        Hello hello = new Hello();
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("Hello", hello);
    }
}
