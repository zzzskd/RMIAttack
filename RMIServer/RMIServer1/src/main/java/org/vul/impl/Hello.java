package org.vul.impl;

import org.vul.inter.IHello;
import org.vul.pojo.Person;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Hello extends UnicastRemoteObject implements IHello {

    public Hello() throws RemoteException {
        super();
    }

    @Override
    public String sayHello(Person person) throws RemoteException {
        return null;
    }
}
