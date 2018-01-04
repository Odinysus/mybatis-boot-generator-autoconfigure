# mybatis-boot-generator-autoconfigure
mybatis plus spring-boot generator autoconfigure

use spring boot autoconfigure to replace code configure.

---
## Usage

``` xml
<groupId>com.github.odinysus</groupId>
	<artifactId>mybatis-boot-generator-autoconfigure</artifactId>
<version>0.0.1</version>
```

all generator configure is under `mybatis.gen`.

fewest config like this:

``` yml
mybatis:
  gen:
    datasource:
      url: jdbc:mysql://localhost:3306/database?useSSL=false
      username: root
      password:
    strategy:
      include:
        - user   //  table you want to generate
```
## Detail config
[mybatis plus generator](https://github.com/baomidou/mybatis-plus/blob/master/mybatis-plus-generate/src/test/java/com/baomidou/mybatisplus/test/generator/CodeGeneratorTest.java)
