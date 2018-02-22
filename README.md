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
      
 - 2018/2/17,数据库结构完善

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

 - 2018/2/19, 数据库实体类创建完成，Dao层，Service层，Controller创建完成
       
    > 业务逻辑，数据库操作语句并没有写完善，测试语句完善。
 
 - 2019/2/22, 前端UI框架采用MDUI,添加Swag2支持。后端返回Json数据格式化
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
