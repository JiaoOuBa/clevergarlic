  
# 上嘉我好运服务

## 数据库设计规范

-[ ] 数据使用标记删除，用**deleted**字段表示删除，**1**表示已删除，**0**表示未删除
-[ ] 数据库任何数据行必须要有**admin_id**、**create_time**、**update_time**表示数据的最后修改人，创建时间，最后修改时间。
-[ ] 数据库任意表都要有**history**表，且数据需要在**tablename_his**表中备份历史数据。**history**表需要存储业务数据与**admin_id**,**update_time**。
  
## why系统 运营后台+手机App JAVA API 项目
本仓库于 2019-05-20 12:10:48 使用了源码自动生成模板 spring-boot 。详情见template_info.md文件。

测试环境：http://xxxxx.com
生产环境：http://xxxxx.com

### 项目部署
项目中使用 `jar包方式` 部署：

maven打包命令为：`mvn clean package -Dmaven.test.skip=true`

jar运行方式为：`java -jar jar包名` （命令行进入jar包目录下）, 同时可以添加参数 `-Dspring.profiles.active=prod` 指定为生产环境， 添加 `-Duser.timezone=GMT+08` 指定时区

linux中后台启动使用nohup命令：`nohup java -jar jar包名 > nohup.out 2>&1 &`
