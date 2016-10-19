#Spring Boot集成MyBatis、shiro、thymeleaf的项目

#MyBatis3.3.0

#Spring Boot 1.3.0.RELEASE

项目使用Spring Boot 1.4.1.RELEASE + Mybatis3.3.0+shiro1.2.5+thymeleaf3.0.0.RELEASE

项目集成了Mybatis分页插件和通用Mapper插件

项目使用的mysql数据库，根据需要可以切换为其他数据库

##说明

虽然MyBatis官方提供了`mybatis-spring-boot-starter`，但是该配置的可以控制的地方太少，因此短时间不会直接使用该`starter`。

在集成MyBatis配置`MapperScannerConfigurer`需要特别注意，将该类单独放在一个配置文件中，例如本项目中的`MyBatisMapperScannerConfig`类：


##SSM集成的基础项目

###https://github.com/abel533/Mybatis-Spring

##MyBatis工具

###http://www.mybatis.tk

##推荐使用Mybatis通用Mapper3

###https://github.com/abel533/Mapper

##推荐使用Mybatis分页插件PageHelper

###https://github.com/pagehelper/Mybatis-PageHelper

###通用mapper的使用简介参考：http://git.oschina.net/free/Mapper/blob/master/wiki/mapper3/3.Use.md#2-%3Ccode%3E-generatedvalue-strategy-=-generationtype-identity-%3C-code
###pageHelper使用参考：http://git.oschina.net/free/Mybatis_PageHelper/blob/master/wikis/HowToUse.markdown

##项目中配置了自动生成model、sqlMapper、mapperXml，建议大家使用。具体使用方法如下：
###1.找到项目resource下面的generator-config.properties文件，把数据库连接修改为对应的数据库，其他属性视情况修改
###2.打开resource目录下面generatorConfig.xml文件，找到table标签，把通配符%修改成对应需要生成的表名字
###3.在intelliJ idea编辑器的右侧有一个maven projects选项，单击打开后找到对应的项目(eg:iotek-user-provider)展开项目，展开Plugins，找到mybatis-generator
双击mybatis-generator:generate
###4.正常配置对的情况下，会构建成功，然后会在指定配置的目录下生成对应的文件(目前项目配置默认生成路径在项目的target目录下的mybatis-generator下面),
然后把生成的文件copy到对应的目录,对应的继承相应的类就可以happy了！