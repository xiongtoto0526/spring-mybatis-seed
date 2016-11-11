# 后端代码工程

##迁移为实际工程
- 修改工程中涉及到 seed 配置的地方
- - 包括 datasource.java, application.java, package-name,generatorconfig.xml
    logback-qa.xml,
- 修改数据源配置
- - application.properties(如果是idea，确保main/resource目录被标记为source状态)



## trouble-shotting:
- idea中classPath不生效。
检查：file-project structure-module，resource是否标记为source状态 , 若没有，则resource下的properties文件无法拷贝到out目录下，导致配置文件读取失败，程序启动找不到datasource

- idea连接mysql，插入的中文编码错误。
检查：
-- 数据库编码，table编码 均为utf-8
-- properties中数据库连接的配置为encoding=utf-8
-- idea-ide中，file-editor-encoding. ide-encoding+project-encoding+default-properties-file-encoding 均为utf-8

## coding-relative
-- mapper层 
   updateByPrimaryKeySelective(Model model) :只获取model中不为空的字段 
   updateByPrimaryKey(Model model) ：即使字段为空，也全部更新。

