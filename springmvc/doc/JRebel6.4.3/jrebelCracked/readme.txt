1:这两个jar包是jrebel插件的破解补丁,不是离线安装包,所以需要自己先安装好jrebel插件

2:把jrebel.lic放到 ~/.jrebel 目录下 (或者启动IDE后手动选择lic文件目录)

3:替换jar包
    找到jrebel的插件目录,分别替换jrebel和jrebel6文件夹下的对应jrebel.jar

    例如：
    1) Eclipse插件目录 -> /eclipse/plugins/org.zeroturnaround.eclipse.embedder_6.4.2.SR1
    .
    ├── jr6
    │   └── jrebel
    │       ├── jrebel.jar (这个用【jrebel6.4.x-cracked/jrebel6/jrebel.jar】替换)
    │       ├── jrebel.plugininfo
    │       └── lib
    ├── jrebel
    │   ├── jrebel.jar     (这个用【jrebel6.4.x-cracked/jrebel/jrebel.jar】替换)
    │   └── jrebel.plugininfo
    ├── META-INF
    │   ├── JREBEL.RSA
    │   ├── JREBEL.SF
    │   └── MANIFEST.MF
    ├── org
    │   └── zeroturnaround
    │       └── eclipse
    └── plugin.xml

    2) IDEA插件目录 -> ~/.IntelliJIdea2016.1/config/plugins/jr-ide-idea/lib
    .
    ├── jrebel
    │   ├── jrebel.jar     (这个用【jrebel6.4.x-cracked/jrebel/jrebel.jar】替换)
    │   └── jrebel.plugininfo
    ├── jrebel6
    │   ├── jrebel.jar     (这个用【jrebel6.4.x-cracked/jrebel6/jrebel.jar】替换)
    │   └── lib
    │       ├── jrebel32.dll
    │       ├── jrebel64.dll
    │       ├── libjrebel32.dylib
    │       ├── libjrebel32.so
    │       ├── libjrebel64.dylib
    │       └── libjrebel64.so
    ├── jrebel-config-client.jar
    ├── ......（省略N个jar包）
    └── zt-zip.jar

    *** MAC插件目录 -> ~/Library/Application Support/IntelliJIdea15/
