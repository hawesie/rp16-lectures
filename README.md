# Robot Programming Lecture Code

Code from Robot Programming lectures 2016/17

You will also need: 
 * https://github.com/hawesie/rp-shared
 * https://github.com/hawesie/rp-utils

If you are using Eclipse, both these repos should be used to create NXT projects. If you are compiling from the command line, you can download the [jar files](https://docs.oracle.com/javase/tutorial/deployment/jar/basicsindex.html) from these projects and including them in your classpath for compilation. Download the jars from here: 

 * https://raw.githubusercontent.com/hawesie/rp-shared/master/export/rp-shared.jar
 * https://raw.githubusercontent.com/hawesie/rp-utils/master/export/rp-utils.jar

Include them in compilation for an nxt executable as follows:

 ```
 nxjc -cp rp-utils.jar:rp-shared.jar  src/rp/lectures/HelloWorld.java
 ```