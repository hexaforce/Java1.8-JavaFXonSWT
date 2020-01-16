# Java1.8-JavaFXonSWT

## 0. SWT download

[swt-4.14-cocoa-macosx-x86_64.zip](https://download.eclipse.org/eclipse/downloads/drops4/R-4.14-201912100610/download.php?dropFile=swt-4.14-cocoa-macosx-x86_64.zip)

## 1. install local repo
```
mvn install:install-file \
    -Dfile=/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/jfxswt.jar \
    -DgroupId=javafx.embed \
    -DartifactId=swt \
    -Dversion=1.8.0_241 \
    -Dpackaging=jar \
    -DgeneratePom=true

mvn install:install-file \
    -Dfile=swt.jar \
    -DgroupId=org.eclipse.swt \
    -DartifactId=org.eclipse.swt.cocoa.macosx.x86_64 \
    -Dversion=4.14 \
    -Dpackaging=jar \
    -DgeneratePom=true
```

## 2. add pom
```
    <dependency>
        <groupId>javafx.embed</groupId>
        <artifactId>swt</artifactId>
        <version>1.8.0_241</version>
    </dependency>
    <dependency>
        <groupId>org.eclipse.swt</groupId>
        <artifactId>org.eclipse.swt.cocoa.macosx.x86_64</artifactId>
        <version>4.14</version>
    </dependency>
```
## 3. switch JVM
```
export JAVA_HOME=`/System/Library/Frameworks/JavaVM.framework/Versions/A/Commands/java_home -v "1.8"`
```

## 4. build
```
mvn test clean package
```

## 5. run 
```
java -XstartOnFirstThread -jar swt-application-jar-with-dependencies.jar
```
