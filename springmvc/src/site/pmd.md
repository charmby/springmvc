# 静态分析工具PMD使用说明 (文章来源: Java Eye)






质量是衡量一个软件是否成功的关键要素。而对于商业软件系统，尤其是企业应用软件系统来说，除了软件运行质量、文档质量以外，代码的质量也是非常重要的。软件开发进行到编码阶段的时候，最大的风险就在于如何保证代码的易读性和一致性，从而使得软件的维护的代价不会很高。

在软件开发的过程中，以下几种情形随处可见：

 - 软件维护时间长，而且维护人员的积极性不高：

 做过软件维护的开发人员，尤其是在接手不是自己开发产品的源码的时候，即使有良好的文档说明，仍然会对代码中冗长、没有注释的段落“叹为观止”。理解尚且如此困难，何况要修改或者增加新的功能。因此，很多开发人员不愿意进行软件维护的工作。

 - 新的开发人员融入团队的时间比较长：

　除了没有良好的培训、文档等有效的机制以外，每个人一套的编码风格，也容易造成新成员对于已有代码的理解不够，甚至出现偏差。

 

提高 代码 的质量，除了要提高逻辑上的 控制 以及业务流程的理解外，代码本身也存在提高的 空间 ，例如一些潜在的问题可以很早的就避免。类似于编码规范上的内容，如果全靠编码人员 进行 自行检查，那么无疑 需要 很大的工作量，如果可以使用代码的静态检查 工具 进行检查的话，那么将大大的提高编码的效率。
<br>
 

> 项目组目前代码检查的工作基本上都是通过人工的方式，实行起来比较困难，检查的效果也不是很明显。PMD正是这样一种工具，可以直接使用它自带的规 则（当然也可以使用自己的规则）对Java源程序进行分析找出程序存在的问题，可以很大程度上的减轻代码检查工作的繁琐，为项目组今后的维护和开发工作起 到指导的作用。

本文主要介绍了如何使用pmd工具进行代码的自动化检查，以规避一些潜在的问题并找出代码的逻辑错误。

2. PMD 简介

`PMD是一种开源分析Java代码错误的工具`。与其他分析工具不同的是，PMD通过静态分析获知代码错误。也就是说，在不运行Java程序的情况下报告错误。PMD附带了许多可以直接使用的规则，利用这些规则可以找出Java源程序的许多问题，例如：

  - 潜在的bug：空的try/catch/finally/switch语句
  - 未使用的代码：未使用的局部变量、参数、私有方法等

  - 可选的代码：String/StringBuffer的滥用

  - 复杂的表达式：不必须的if语句、可以使用while循环完成的for循环

  - 重复的代码：拷贝/粘贴代码意味着拷贝/粘贴bugs

  - 循环体创建新对象：尽量不要再for或while循环体内实例化一个新对象

  - 资源关闭：Connect，Result，Statement等使用之后确保关闭掉

此外，用户还可以自己定义规则，检查Java代码是否符合某些特定的编码规范。例如，你可以编写一个规则，要求PMD找出所有创建Thread和Socket对象的操作。

 

3. 工作原理

PMD的核心是JavaCC解析器生成器。PMD结合运用JavaCC和EBNF（扩展巴科斯-诺尔范式，Extended Backus-Naur Formal）语法，再加上JJTree，把Java源代码解析成抽象语法树（AST，Abstract Syntax Tree）。显然，这句话不那么好懂，且看下文具体说明。 

　　从根本上看，Java源代码只是一些普通的文本。不过，为了让解析器承认 这些普通的文本是合法的Java代码，它们必须符合某种特定的结构要求。这种结构可以用一种称为EBNF的句法元语言表示，通常称为“语法” （Grammar）。JavaCC根据语法要求生成解析器，这个解析器就可以用于解析用Java编程语言编写的程序。 

　　不过实际运行 中的PMD还要经过JJTree的一次转换。JJTree是一个JavaCC的插件，通过AST扩充JavaCC生成的解析器。AST是一个Java符号 流之上的语义层。有了JJTree，语法分析的结果不再是“System, ., out, ., . println”之类的符号序列，而是一个由对象构成的树型层次结构。例如，下面是一段简单的Java代码以及与之对应的AST。 

Java源代码：
```
public class Foo {
    public void bar() {
        System.out.println("hello world");
    }
}
```
对应的抽象语法树
```
CompilationUnit
TypeDeclaration
ClassDeclaration
UnmodifiedClassDeclaration
ClassBody
ClassBodyDeclaration
MethodDeclaration
ResultType
MethodDeclarator
FormalParameters
Block
BlockStatement
Statement
StatementEXPression
PrimaryExpression
PrimaryPrefix
Name
PrimarySuffix
Arguments
ArgumentList
Expression
PrimaryExpression
PrimaryPrefix
Literal
```

4. PMD 的安装和运行

### 4.1  安装并从命令行运行PMD
你可以从PMD的网站下载PMD的二进制版本，或下载带源代码的版本，下载得到的都是ZIP文件。假设你下载了二进制版本，先把它解压缩到任意一个 目录。接下来怎么做，就要看你准备怎么用它——最简单的，如果要在一个Java源代码目录中运行PMD，只需直接在命令行上运行下面的命令：  

E:/SoftWare/pmd-bin-4.2.1/pmd-4.2.1/bin>java -jar ../lib/pmd-4.2.1.jar D:/ebsser

vice/ebsservice/src text rulesets/unusedcode.xml 

输出结果类如：

D:/ebsservice/ebsservice/src/com/sinosoft/service/policy/ebs/SMPolicyInput.java:

51      Avoid unused private fields such as 'logger'.

D:/ebsservice/ebsservice/src/com/sinosoft/service/policy/ebs/SMPolicyShow.java:2

5       Avoid unused private fields such as 'logger'.

D:/ebsservice/ebsservice/src/com/sinosoft/service/policy/ebs/SMQueryPolicyByPoli

cyNo.java:32    Avoid unused local variables such as 'visaStatus'.

D:/ebsservice/ebsservice/src/com/sinosoft/service/policy/ebs/SMQueryPolicyByPoli

cyNo.java:44    Avoid unused local variables such as 'temp'.

D:/ebsservice/ebsservice/src/com/sinosoft/service/policy/ebs/erisk/ESMPolicyInpu

t.java:28       Avoid unused private fields such as 'logger'.

D:/ebsservice/ebsservice/src/com/sinosoft/service/policy/ebs/jrisk/JSMPolicyInpu

t.java:22       Avoid unused private fields such as 'logger'.

 

一些可以加载必须参数前面或者后面的可选参数如下：

-debug: 打印debug日志信息

-targetjdk: 指定目标源代码的版本- 1.3, 1.4, 1.5, 1.6 or 1.7;

默认是1.5

-cpus: 指定创建的线程数

-encoding: 指定PMD检查的代码的编码方式

-excludemarker: 指定PMD需要忽略的行的标记，默认为NOPMD

-shortnames: 在报告中显示缩短的文件名

-linkprefix: HTML源文件的路径，只是为了HTML显示

-lineprefix: 自定义的锚，用于影响源文件中的行，只是用于HTML显示

-minimumpriority: 规则的优先级限制，低于优先级的规则将不被使用

-nojava: 不检查java文件，默认是检查java文件

-jsp: 检查JSP/JSF文件，默认不检查

-reportfile: 将报告输出到文件，默认是打印在控制台

-benchmark: 输出一个基准清单，默认输出到控制台

-xslt: 覆盖默认的xslt

-auxclasspath: 指定源代码文件使用的类路径

 

例如在windows系统中，例子如下：

c:/> java -jar pmd-4.2.1.jar c:/my/source/code text unusedcode,imports -targetjd

k 1.5 -debug

c:/> java -jar pmd-4.2.1.jar c:/my/source/code xml basic,design -encoding UTF-8

c:/> java -jar pmd-4.2.1.jar c:/my/source/code html typeresolution -auxclasspath

 commons-collections.jar;derby.jar

 

### 4.2 在Eclipse中 安装 PMD插件运行方式

PMD可以作为插件集成到很多 流行 的 IDE中，很多的插件中都包含了PMD的jar文件，这个jar文件中包含了规则集。所以虽然一些插件中使用 rulesets/unusedcode.xml来作为参数引用规则集，但是实际上是使用getResourceAsStream()方法来从PMD的 jar文件中加载。

由于Eclipse是比较流行的开源Java/J2EE开发IDE，所以本文主要介绍如何在Eclipse中使用PMD工具进行代码的检查。

 

#### 4.2.1 安装基于Eclipse IDE的插件
安装Eclipse的PMD插件的过程如下：

® 启动Eclipse

® 选择Help-->Software Updates-->Find and Install

® 选择Next,选择New remote site

® 在Name框中输入PMD，URL框中输入http://pmd.sf.net/eclipse

® 在之后的对话框中一直点击下一步或者接受协议，完成Eclipse的PMD插件的安装

也可以通过下载 最新 的zip文件按，然后执行上述过程，只是使用New locale site来代替New remote site，并使用下载的zip文件。

可以通过Windows-->Preferences来配置PMD。

通过右键一个 项目 ， 然后选择PMD-->Check node with PMD，即可使用PMD工具检查代码。如果要进行重复代码检测，那么右键一个项目后，选择PMD-->Find suspect cut and paste。检查结果会放在reports目录下，文件名为cpd-report.txt。

可以通过使用Eclipse的帮助系统来查看PMD插件的文档。

在安装完更新后，如果发生了一个异常，例如”java.lang.RuntimeException: Could not find that class xxxx”，这时试着删除workspace中的.metadata/plugins/net.sourceforge.pmd.eclipse目录下的 ruleset.xml文件。

 

#### 4.2.2 使用PMD

1、启动Eclipse IDE，打开工程，选择 "Windows"->"Preferences"下的PMD项，其中Rules Configuration 项目可以配置PMD的检查规则，自定义检查规则也可以在此通过Import的方式导入到PMD中

2、配置好后，鼠标右键点击工程中需要检查的JavaSource，选择"PMD"->"Check Code With PMD" ,之后PMD就会通过规则检查你的JavaSource了并且将信息显示在PMD自己的视图上

3、示例

```
import java.util.*;

public class Test {

        public static void main(String[] args) {

             try{ 

                if(true) {}

                System.out.println("Hello World!");

            } catch(Exception e) {

            } 

       }

}
```

以上代码PMD会检查出：catch块中没有内容、if判断块中没有内容、代码中出现System.out.println等警告描述

#### 4.3 使用Ant进行调用
下面是主要的Ant配置信息
```
<path id="pmd.path">    

    <fileset dir="${lib.dir}/pmd-3.8">

        <include name="**/*.jar" />

    </fileset>

</path>

<taskdef name="pmd" classname="net.sourceforge.pmd.ant.PMDTask" classpathref="pmd.path"/>

<taskdef name="cpd" classname="net.sourceforge.pmd.cpd.CPDTask" classpathref="pmd.path"/>

    <target name="pmd">

        <pmd shortFilenames="true">

            <ruleset>rulesets/favorites.xml</ruleset>            

            <formatter type="html" toFile="d:/foo.html" toConsole="false"/>

            <fileset dir="${src.dir}">

                <include name="**/*.java"/>

            </fileset>

        </pmd>

    </target>

<target name="cpd">        

        <cpd minimumTokenCount="100" outputFile="d:/cpd.txt">

            <fileset dir="${src.dir}">

                <include name="**/*.java"/>

            </fileset>

        </cpd>

    </target>
```
用Ant命令运行build.xml，PMD就会按照你设定好的规则自动执行代码检查了。

5. 关于PMD规则

选择合适的规则

运行所有的规则集中的规则会产生非常多的冲突，这些冲突中的很多是不重要的。在这么多的冲突中寻找你关心的部分结果就没有什么效率可言了。

所以需要从明显的规则集，也就是说必须要改的 地方 开始是比较好的一个选择，例如只是运行unusedcode检查，然后修改没有使用的局部变量和成员变量。然后运行基本的检查，修改所有的空语句，例如if语句等。最后可以执行与设计 相关 的或者存在一定争议的规则集，或者自定义的规则集。

自带规则的介绍： （PMD插件分析代码规则（中文）.xls）
```

PMD 自带了很多规则集合，并且分类写入不同的 ruleset 文件，如

Basic 包含每人都必须遵守的代码最佳实践，如EmptyCatchBlock

Braces 关于条件分支的规则，如IfStmtsMustUseBraces

Code Size 关于代码大小的规则，如方法的长度，参数的长度，属性的个数等

Clone 克隆实现的规则，如是否有super.clone()

Controversial 一些有争议的规则，如UnnecessaryConstructor不必要的构造器

Coupling 对象连接有关的规则

Design 可以检查有问题的设计，如SwitchStmtsShouldHaveDefault

Finalizers 使用finalizers时需遵循的规则，如FinalizeOnlyCallsSuperFinalize

Import Statements 和import有关的规则，如DuplicateImports重复import

J2EE 唯一规则UseProperClassLoader，class.getClassLoader()可能不正确，用

Thread.currentThread().getContextClassLoader() 代替

Javabeans 和javabean规范有关的规则，有BeanMembersShouldSerialize属性必须

序列化和MissingSerialVersionUID缺少序列化ID

JUnit Tests 和JUnit测试有关的，如JUnitSpelling拼写检查等

Logging (Java) 检查Logger的一些错误用法，如MoreThanOneLogger多个Logger

Logging (Jakarta) 使用Jakarta Logger的一些规则，有UseCorrectExceptionLogging

异常处理不当和ProperLogger是否正确定义Logger

Migrating JDK 版本移植的规则，如ReplaceVectorWithList用List代替Vector

Naming 和命名有关的规则，名称太短或太长，命名的约定等
```