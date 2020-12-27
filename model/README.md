# 皮卡丘系统 持久层框架使用指南

## 背景

皮卡丘 model 模块负责持久化数据,ORM 框架采用 mybatis-plus

## 生成代码

由于 mybatis mapper.xml 编写繁琐极易出错,故 皮卡丘 使用 idea 插件自动生成.

1. 打开 idea 插件中心,安装插件 Free Mybatis plugin ,安装完毕,重启启用.
2. 打开 idea 配置中心,按照如下配置:
   ![](https://itguang.oss-cn-beijing.aliyuncs.com/20201227155153.png)

3. 打开 pikachu 项目, 点击右边窗口 DataSource 窗口,连接数据,进行 mybatis 代码生成

![](https://itguang.oss-cn-beijing.aliyuncs.com/20201227155329.png)

4. 生成完毕,可以看到 model 模块多了几个文件

![](https://itguang.oss-cn-beijing.aliyuncs.com/20201227155514.png)

5. 最后在生成 的 xxxRepository 类上添加 @Mapper 注解 


## 分页使用



## 枚举使用
