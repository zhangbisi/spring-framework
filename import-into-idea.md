The following has been tested against IntelliJ IDEA 2016.2.2

## Steps

_Within your locally cloned spring-framework working directory:_

1. Precompile `spring-oxm` with `./gradlew :spring-oxm:compileTestJava`
2. Import into IntelliJ (File -> New -> Project from Existing Sources -> Navigate to directory -> Select build.gradle)
3. When prompted exclude the `spring-aspects` module (or after the import via File-> Project Structure -> Modules)
4. Code away

## Known issues

1. `spring-core` and `spring-oxm` should be pre-compiled due to repackaged dependencies.
See `*RepackJar` tasks in the build and https://youtrack.jetbrains.com/issue/IDEA-160605).
2. `spring-aspects` does not compile due to references to aspect types unknown to
IntelliJ IDEA. See http://youtrack.jetbrains.com/issue/IDEA-64446 for details. In the meantime, the
'spring-aspects' can be excluded from the project to avoid compilation errors.
3. While JUnit tests pass from the command line with Gradle, some may fail when run from
IntelliJ IDEA. Resolving this is a work in progress. If attempting to run all JUnit tests from within
IntelliJ IDEA, you will likely need to set the following VM options to avoid out of memory errors:
    -XX:MaxPermSize=2048m -Xmx2048m -XX:MaxHeapSize=2048m
4. If you invoke "Rebuild Project" in the IDE, you'll have to generate some test
resources of the `spring-oxm` module again (`./gradlew :spring-oxm:compileTestJava`)    


## Tips

In any case, please do not check in your own generated .iml, .ipr, or .iws files.
You'll notice these files are already intentionally in .gitignore. The same policy goes for eclipse metadata.

## FAQ

Q. What about IntelliJ IDEA's own [Gradle support](http://confluence.jetbrains.net/display/IDEADEV/Gradle+integration)?

A. Keep an eye on http://youtrack.jetbrains.com/issue/IDEA-53476


## 导入idae 的步骤：
一、准备环境：
1、JDK：安装好JDK1.8
2、安装 Gradle 

二、源码编译
3、先进入 …/spring-framework 目录，执行 ./gradlew :spring-oxm:compileTestJava  先对 Spring-oxm 模块进行预编译。
4、 spring-core需要依賴日志包 commons-logging-1.2.jar,添加本地依赖,在spring-core.gradle文件中 dependencies {} 内添加：
项目的根目录中创建libs 目录，把依赖包放到这个目录下
```
dependencies {
    .....
    //添加本地依赖包
   compile fileTree(dir:'libs',includes:['*jar'])
}
```
5、手动构建cglibRepack.jar 和 objenesisRepackJar

6、缺少包直接添加到spring-zwisdom 的xml中