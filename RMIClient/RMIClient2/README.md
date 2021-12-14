### RMI Server Attack Client 方法一之恶意的返回值

#### 原理 

利用 Client 会反序列化 Server 方法的返回值。在 Client 端获取到 Server 对应的 Stub 后，会在本地调用这个Stub 获取 Server 的值并反序列化。

#### 条件

远程方法会有返回值类型，且返回值类型不能是 `String` 等类型，形如：

```java
public interface IHello extends Remote {
    public Person sayHello() throws RemoteException;
}
```

注意点：客户端同样会对远程方法hash进行校验，但是这个校验值是服务端提供的，可以绕过：

1. 通过网络代理，在流量层修改数据
2. 自定义 `java.rmi` 包的代码，自行实现
3. 字节码修改
4. 使用 debugger
5. 将恶意类继承原始类
