## 学生网上选课系统



#### 环境配置

 - Java: 1.8
 - Gradle: 4.4.1
 - Tomcat: 9.0.0
 - 开发工具: IntellJ IDEA



#### 项目进度

 - 2018/2/11, 完成项目环境的搭建，三大框架的整合。
      
    > 连接池更换为**HikariCP**,相比较c3p0,druid性能有很大提升。启动速度由9,458 milliseconds缩短到4,875 milliseconds
    >
    > 使用**Slf4j+logback**配置日志框架
 - 2018/2/12, 使用RESTful风格规范，测试Ajax，页面输出json数据。
    
    > 使用@ResponseBody注解，需依次导入jackson-databind，jackson-core，jackson-annotations三个jar包，才能在页面上输出json数据
 - 2018/2/13, mybatis增删改查的实现
       
    > 使用注解的方式，注意SQL语句空格，否则会有语法错误。
      
 



