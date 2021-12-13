### RMI Client Attack Server 方法一之恶意的接口参数

#### 原理 

利用 Server 会反序列化 Client 传入的参数。在 Client 端获取到 Server 端创建的 Stub 后，会在本地调用这个Stub 并传递参数， Stub 会序列化这个参数，
并传递给 Server 端， Server 端会反序列化 Client 端传入的参数之后进行调用。

#### 条件

远程方法会接受参数，任意类型参数都可，形如：

```java
public interface IHello extends Remote {
    public String sayHello(Person person) throws RemoteException;
}
```

注意点：服务端会对远程方法hash进行校验，但是这个校验值是客户端提供的，可以绕过：

1. 通过网络代理，在流量层修改数据
2. 自定义 `java.rmi` 包的代码，自行实现
3. 字节码修改
4. 使用 debugger
5. 将恶意类继承原始类（String 等被 `final` 修饰的类不能被继承）

Ref:

- [BSides Exploiting RMI Services.pdf](https://github.com/mogwailabs/rmi-deserialization/blob/master/BSides%20Exploiting%20RMI%20Services.pdf)
- [Bypass JEP290攻击rmi](https://www.anquanke.com/post/id/200860)