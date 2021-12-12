package org.vul.dependencies;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/*
    类似 cc 依赖库
 */
public class GadgetDependency implements Serializable {
    private String param;

    public void setParam(String param) {
        this.param = param;
    }

    public String getParam() {
        return param;
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        Runtime.getRuntime().exec(param);
    }
}
