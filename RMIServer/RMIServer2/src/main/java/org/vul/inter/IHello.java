package org.vul.inter;

import org.vul.pojo.Person;

import java.rmi.Remote;
import java.rmi.RemoteException;

/*
    interface 接口
 */
public interface IHello extends Remote {
    public Person sayHello() throws RemoteException;
}
