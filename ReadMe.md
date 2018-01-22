# 拯救世界项目

## 系统功能
内容加密
个人信息记录
装修记录



## 技术选型
### 1、后端
  - 核心框架：Spring Boot
  - 安全框架：Apache Shiro
  - 模板引擎：Thymeleaf
  - 持久层框架：MyBatis
  - 数据库连接池：Alibaba Druid
  - 缓存框架：Ehcache 、Redis
  - 日志管理：log4J2
  - 工具类：Apache Commons、Jackson 、Xstream 1.4、Dozer 5.3、POI 3.9

### 2、前端
  - 前端框架:ivew
  - JS框架：vue.js
  - 客户端验证：JQuery Validation
  - 富文本在线编辑：summernote
  - 在线文件管理：CKFinder
  - 数据表格：bootstrapTable
  - 弹出层：layer
  - 树结构控件：jsTree

### 3.平台
  - 服务器中间件：SpringBoot内置
  - 数据库支持：MYSQL
  - 开发环境：Java、IDEA 、Maven 、Git

### 4.安全考虑
  1. 开发语言：系统采用Java 语言开发，具有卓越的通用性、高效性、平台移植性和安全性。
  2. 分层设计：（数据库层，数据访问层，业务逻辑层，展示层）层次清楚，低耦合，各层必须通过接口才能接入并进行参数校验（如：在展示层不可直接操作数据库），保证数据操作的安全。
  3. 双重验证：用户表单提交双验证：包括服务器端验证及客户端验证，防止用户通过浏览器恶意修改（如不可写文本域、隐藏变量篡改、上传非法文件等），跳过客户端验证操作数据库。
  4. 安全编码：用户表单提交所有数据，在服务器端都进行安全编码，防止用户提交非法脚本及SQL注入获取敏感数据等，确保数据安全。
  5. 密码加密：登录用户密码进行SHA1散列加密，此加密方法是不可逆的。保证密文泄露后的安全问题。
  6. 强制访问：系统对所有管理端链接都进行用户身份权限验证，防止用户直接填写url进行访问。

## 参考资料
[easypoi：POI 的封装工具类](http://easypoi.mydoc.io/)

AG-Admin：基于 Spring Cloud 微服务化开发平台
xxl-job：轻量级分布式任务调度框架
Mybatis_PageHelper：Mybatis 分页插件
ybg-spring-fast：基于 SpringBoot 的模块化开发系统

