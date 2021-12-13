### RMI Server Attack Client 方法二之 Reference

#### 原理 

`javax.naming.Reference` 类可以记录一个远程对象的位置，Server 可以将实例化的 `Reference` 对象通过 `bind` 注册到 RMIRegistry 上。 Client 从 RMIRegistry 获取  RegistryImpl_Stub 中的 `Reference` 对象，`Reference` 对象通过 `URLClassLoader` 将记录的类从远程地址上加载到本地实例化，从而触发恶意类中的静态代码快，导致 RCE。

#### 条件

