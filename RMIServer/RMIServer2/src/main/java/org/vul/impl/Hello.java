package org.vul.impl;

import org.vul.dependencies.GadgetDependency;
import org.vul.inter.IHello;
import org.vul.pojo.Person;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Hello extends UnicastRemoteObject implements IHello {

    public Hello() throws RemoteException {
        super();
    }

    @Override
    public Person sayHello() throws RemoteException {
        GadgetDependency obj = new GadgetDependency();
        obj.setParam("calc.exe");
        return obj;
    }
//    @Override
//    public Person sayHello() throws RemoteException {
//        return null;
//    }
}
