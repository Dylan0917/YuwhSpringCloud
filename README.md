# YuwhSpringCloud
微服务学习



##项目启动

先安装 cloud-api-commons模块











##其他知识

###**服务治理**

服务治理，也称为SOA治理，是指用来管理SOA的采用和实现的过程。以下是在2006年时IBM对于服务治理要点的总结：

1.服务定义（服务的范围、接口和边界）

2.服务部署生命周期（各个生命周期阶段）

3.服务版本治理（包括兼容性）

4.服务迁移（启用和退役）

5.服务注册中心（依赖关系）

6.服务消息模型（规范数据模型）

7.服务监视（进行问题确定）

8.服务所有权（企业组织）

9.服务测试（重复测试）

10.服务安全（包括可接受的保护范围）

###安装Consul

![](E:\myProject\myResource\YuwhSpringCloud\readmeimg\image-20210224105607749.png)

> 直接在目录下执行即可

cmd 命令窗口执行：`consul agent -dev`

consul 自带 UI 界面，打开网址：[http://localhost:8500](https://link.zhihu.com/?target=http%3A//localhost%3A8500/) ，可以看到当前注册的服务界面

cmd 命令窗口执行:consul.exe agent -server ui -bootstrap -client 0.0.0.0 -data-dir="E:\consul" -bind X.X.X.X

其中X.X.X.X为服务器ip,即可使用http://X.X.X.X:8500 访问ui而不是只能使用localhost连接

###CAP定理

![img](E:\myProject\myResource\YuwhSpringCloud\readmeimg\bg2018071607.jpg)

> - Consistency 一致性
> - Availability 可用性
> - Partition tolerance  分区容错

http://www.ruanyifeng.com/blog/2018/07/cap.html