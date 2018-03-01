## 学生网上选课系统

#### 环境配置
 - Java: 1.8
 - Gradle: 4.4.1
 - Tomcat: 9.0.0
 - 开发工具: IntellJ IDEA
 
#### 技术选型
##### 后端技术

| 技术        | 名称   |  官网  |
| --------   | ---------:  | :---------------------:  |
| Spring Framework     | 容器 | http://projects.spring.io/spring-framework/     |
| SpringMVC        |   MVC框架   |   http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc   |
| MyBatis        |    ORM框架    |  	http://www.mybatis.org/mybatis-3/zh/index.html  |
| PageHelper     |MyBatis物理分页插件|http://git.oschina.net/free/Mybatis_PageHelper|
|HikariCP|数据库连接池|http://brettwooldridge.github.io/HikariCP/|	
|Ehcache|进程内缓存框架|http://www.ehcache.org/|
|Slf4j|日志组件|https://www.slf4j.org|
|logback|日志组件|https://logback.qos.ch|
|Swagger2|接口测试框架|http://swagger.io/|
|Gradle|项目管理工具|https://gradle.org|
|...|...|...|

##### 前端技术

|技术|名称|官网|
|---|----|----|
|jquery|函式库|http://jquery.com/|
|MDUI|前端响应式框架|https://www.mdui.org|
|...|...|...|

##### 所需jar包
    testCompile group: 'junit', name: 'junit', version: '4.11'
    compile group: 'junit', name: 'junit', version: '4.12'
    //spring 系列包 4.4.13
    // spring mvc
    compile group: 'org.springframework', name: 'spring-webmvc', version: '4.3.13.RELEASE'
    // spring 核心包
    compile group: 'org.springframework', name: 'spring-core', version: '4.3.13.RELEASE'
    // spring beans
    compile group: 'org.springframework', name: 'spring-beans', version: '4.3.13.RELEASE'
    // spring 上下文
    compile group: 'org.springframework', name: 'spring-context', version: '4.3.13.RELEASE'
    // spring web
    compile group: 'org.springframework', name: 'spring-web', version: '4.3.13.RELEASE'
    // spring orm
    compile group: 'org.springframework', name: 'spring-orm', version: '4.3.13.RELEASE'
    // spring测试包
    compile group: 'org.springframework', name: 'spring-test', version: '4.3.13.RELEASE'

    // https://mvnrepository.com/artifact/org.springframework/spring-context-support
    compile group: 'org.springframework', name: 'spring-context-support', version: '4.3.13.RELEASE'

    // https://mvnrepository.com/artifact/net.sf.ehcache/ehcache
    compile group: 'net.sf.ehcache', name: 'ehcache', version: '2.10.4'

    // 日志记录 1.7.25
    compile group: 'org.slf4j', name: 'slf4j-simple', version: '1.7.25'



    // 数据库连接 5.1.38
    compile group: 'mysql', name: 'mysql-connector-java', version: '5.1.38'

    // 数据库连接池 2.7.7
    compile group: 'com.zaxxer', name: 'HikariCP', version: '2.7.7'

    // spring与Mybatis整合 1.3.0
    compile group: 'org.mybatis', name: 'mybatis-spring', version: '1.3.0'

    // mybatis 3.4.1
    compile group: 'org.mybatis', name: 'mybatis', version: '3.4.1'

    // https://mvnrepository.com/artifact/com.google.code.gson/gson
    //compile group: 'com.google.code.gson', name: 'gson', version: '2.3.1'

    // 页面输出json数据所需jar包
    compile group: 'com.fasterxml.jackson.core', name: 'jackson-databind', version: '2.9.0'
    compile group: 'com.fasterxml.jackson.core', name: 'jackson-core', version: '2.9.0'
    compile group: 'com.fasterxml.jackson.core', name: 'jackson-annotations', version: '2.9.0'

    // swagger2所需jar包
    compile group: 'io.springfox', name: 'springfox-swagger2', version: '2.7.0'
    compile group: 'io.springfox', name: 'springfox-swagger-ui', version: '2.7.0'

    //注解@Validator 所需jar包

    compile group: 'javax.validation', name: 'validation-api', version: '1.1.0.Final'
    compile group: 'org.apache.bval', name: 'bval-jsr303', version: '0.5'

    //email
    compile group: 'javax.mail', name: 'mail', version: '1.4.7'


##### 数据库设计


    /*
        Navicat MySQL Data Transfer
        
        Source Server         : localhost_3306
        Source Server Version : 50717
        Source Host           : localhost:3306
        Source Database       : demo
        
        Target Server Type    : MYSQL
        Target Server Version : 50717
        File Encoding         : 65001
        
        Date: 2018-02-17 23:02:30
        */
        
        SET FOREIGN_KEY_CHECKS=0;
        
        -- ----------------------------
        -- Table structure for position
        -- ----------------------------
        DROP TABLE IF EXISTS `position`;
        CREATE TABLE `position` (
          `P_ID` int(11) NOT NULL AUTO_INCREMENT,
          `NAME` varchar(255) COLLATE utf8_bin NOT NULL,
          `DESCRIPTION` varchar(255) COLLATE utf8_bin NOT NULL,
          PRIMARY KEY (`P_ID`)
        ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
        
        -- ----------------------------
        -- Records of position
        -- ----------------------------
        
        -- ----------------------------
        -- Table structure for tb_course
        -- ----------------------------
        DROP TABLE IF EXISTS `tb_course`;
        CREATE TABLE `tb_course` (
          `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程编号',
          `name` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '课程名称',
          `schooltime` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '上课时间',
          `addr` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '上课地点',
          `credit` decimal(3,0) NOT NULL COMMENT '课程学分',
          `courseInfo` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '课程介绍',
          `teacherName` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '授课老师',
          `teacherInfo` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '教师介绍',
          `isFinish` int(11) NOT NULL COMMENT '是否结业',
          `specialtyId` int(11) NOT NULL COMMENT '专业编号',
          PRIMARY KEY (`id`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
        
        -- ----------------------------
        -- Records of tb_course
        -- ----------------------------
        
        -- ----------------------------
        -- Table structure for tb_specialty
        -- ----------------------------
        DROP TABLE IF EXISTS `tb_specialty`;
        CREATE TABLE `tb_specialty` (
          `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '专业编号',
          `enterYear` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '入学年份',
          `name` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '专业名称',
          `langthYear` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '学制',
          `isFinish` int(11) NOT NULL COMMENT '是否结业',
          PRIMARY KEY (`id`)
        ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
        
        -- ----------------------------
        -- Records of tb_specialty
        -- ----------------------------
        
        -- ----------------------------
        -- Table structure for tb_stucourse
        -- ----------------------------
        DROP TABLE IF EXISTS `tb_stucourse`;
        CREATE TABLE `tb_stucourse` (
          `stuID` int(11) DEFAULT NULL COMMENT '学生编号',
          `courseID` int(11) DEFAULT NULL COMMENT '课程编号',
          `id` int(11) NOT NULL,
          PRIMARY KEY (`id`),
          KEY `stu_ID` (`stuID`),
          KEY `course_ID` (`courseID`),
          CONSTRAINT `course_ID` FOREIGN KEY (`courseID`) REFERENCES `tb_course` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
          CONSTRAINT `stu_ID` FOREIGN KEY (`stuID`) REFERENCES `tb_stuuser` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
        
        -- ----------------------------
        -- Records of tb_stucourse
        -- ----------------------------
        
        -- ----------------------------
        -- Table structure for tb_stuuser
        -- ----------------------------
        DROP TABLE IF EXISTS `tb_stuuser`;
        CREATE TABLE `tb_stuuser` (
          `id` int(11) NOT NULL COMMENT '学生编号',
          `stuName` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '学生姓名',
          `stuNo` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '学号',
          `specialtyId` int(11) NOT NULL COMMENT '专业编号',
          `stuSex` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '性别',
          `birthday` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '出生日期',
          `homeAddr` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '家庭住址',
          `tel` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '联系电话',
          `addr` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '现住址',
          PRIMARY KEY (`id`),
          KEY `specialty_Id` (`specialtyId`),
          CONSTRAINT `specialty_Id` FOREIGN KEY (`specialtyId`) REFERENCES `tb_specialty` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
        
        -- ----------------------------
        -- Records of tb_stuuser
        -- ----------------------------
        
        -- ----------------------------
        -- Table structure for tb_userlogin
        -- ----------------------------
        DROP TABLE IF EXISTS `tb_userlogin`;
        CREATE TABLE `tb_userlogin` (
          `id` int(11) NOT NULL COMMENT '用户编号',
          `loginName` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '登录名',
          `pwd` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '密码',
          `type` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '用户类型',
          `mail` varchar(255) COLLATE utf8_bin NOT NULL,
          PRIMARY KEY (`id`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
        
        -- ----------------------------
        -- Records of tb_userlogin
        -- ----------------------------
        SET FOREIGN_KEY_CHECKS=1;

#### 项目进度

 - 2018/2/11, 完成项目环境的搭建，三大框架的整合。
      
    > 连接池更换为**HikariCP**,相比较c3p0,druid性能有很大提升。启动速度由9,458 milliseconds缩短到4,875 milliseconds
    >
    > 使用**Slf4j+logback**配置日志框架
 - 2018/2/12, 使用RESTful风格规范，测试Ajax，页面输出json数据。
    
    > 使用@ResponseBody注解，需依次导入jackson-databind，jackson-core，jackson-annotations三个jar包，才能在页面上输出json数据
 - 2018/2/13, mybatis增删改查的实现
       
    > 使用注解的方式，注意SQL语句空格，否则会有语法错误。
      
 - 2018/2/17,数据库结构完善
 - 2018/2/19, 数据库实体类创建完成，Dao层，Service层，Controller创建完成
       
    > 业务逻辑，数据库操作语句并没有写完善，测试语句完善。
 
 - 2018/2/22, 前端UI框架采用MDUI,添加Swag2支持。后端返回Json数据格式化
   ```
   { 
    "code": 0,
    "msg": "访问成功",
    "data": {
      "id": "1",
      "loginName": "李前",
      "pwd": "111",
      "type": "管理员",
      "mail": "51103942@qq.com"
    }
  
   ```
- 2018/2/26, MDUI资源添加，测试多对一，完善登陆界面
- 2018/3/1, 添加spring通过QQ邮箱发送Email
> 添加依赖 compile group: 'javax.mail', name: 'mail', version: '1.4.7'

    测试代码
     @Test
        public void sendTextEmail() {
            //
            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            // 参考QQ邮箱帮助中心
            mailSender.setHost("smtp.qq.com"); // QQ邮箱smtp发送服务器地址
            //mailSender.setPort(465); // QQ这个端口不可用
            mailSender.setPort(587);// 端口号
            mailSender.setUsername("51103942@qq.com"); // 使用你自己的账号
            mailSender.setPassword("jtmoybnwknrnbjha"); // 授权码-发短信获取
            // 邮件信息
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setFrom("51103942@qq.com"); // 发件人邮箱
            msg.setTo("51103942@qq.com"); // 收件人邮箱
            msg.setSubject("测试Spring邮件"); // 标题
            msg.setText("您的订单号码******; 请勿告诉别人!"); // 文本信息
            try {
                mailSender.send(msg);
                System.out.println("邮件发送成功!"); // 没有报错就是好消息 :-)
            } catch (MailException ex) {
                System.err.println("发送失败:" + ex.getMessage());
            }
        }

