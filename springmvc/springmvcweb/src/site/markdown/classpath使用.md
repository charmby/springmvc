#  web.xml 配置中classpath: 与classpath*:的区别

首先 `classpath`是指 `WEB-INF`文件夹下的`classes`目录

解释classes含义：
1.存放各种资源配置文件 eg.init.properties log4j.properties struts.xml
2.存放模板文件 eg.actionerror.ftl
3.存放class文件 对应的是项目开发时的src目录编译文件
总结：这是一个定位资源的入口

如果你知道开发过程中有这么一句话：惯例大于配置 那么也许你会改变你的想法

对于第二个问题
这个涉及的是lib和classes下文件访问优先级的问题: lib>classes
对于性能的影响应该不在这个范畴

`classpath` 和 `classpath*` 区别：
`classpath`：只会到你的class路径中查找找文件;
`classpath*`：不仅包含class路径，还包括jar文件中(class路径)进行查找.

Java代码 

```

<param-value>classpath:applicationContext-*.xml</param-value> 

``` 

或者引用其子目录下的文件,如
Java代码  收藏代码
<param-value>classpath:context/conf/controller.xml</param-value>  


`classpath*`的使用：当项目中有多个classpath路径，并同时加载多个classpath路径下（此种情况多数不会遇到）的文件，`*`就发挥了作用，如果不加`*`，则表示仅仅加载第一个classpath路径，代码片段：
Java代码  收藏代码

```

<param-value>classpath*:context/conf/controller*.xml</param-value>

```  


另外： 
`**/` 表示的是任意目录； 
`**/applicationContext-*.xml`  表示任意目录下的以`applicationContext-`开头的XML文件。  
程序部署到tomcat后，src目录下的配置文件会和class文件一样，自动copy到应用的 `WEB-INF/classes`目录下 
classpath:与`classpath*`:的区别在于，

前者只会从第一个classpath中加载，而
后者会从所有的classpath中加载  

如果要加载的资源，
不在当前ClassLoader的路径里，那么用classpath:前缀是找不到的，
这种情况下就需要使用`classpath*`:前缀

在多个classpath中存在同名资源，都需要加载，
那么用classpath:只会加载第一个，这种情况下也需要用`classpath*`:前缀

注意：
用`classpath*`:需要遍历所有的classpath，所以加载速度是很慢的，因此，在规划的时候，应该尽可能规划好资源文件所在的路径，尽量避免使用classpath*。
