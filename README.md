# Gradle构建多工程项目

## 功能

- modular-net(网络库)
  
## 文档

 - [gradle-user-guide](https://dongchuan.gitbooks.io/gradle-user-guide-/content/overview/features.html)
 - [getting-started-with-gradle](https://www.petrikainulainen.net/getting-started-with-gradle/)

## 目标

 - Gradle搭建一般Java项目
 - Gradle搭建Java Web项目
 - Gradle搭建Java Web多项目引用,多项目的Java构建

## 环境

### BulidShip插件 

 - eclipse 集成Gradle插件BulidShip
 - eclipse 导入gradle项目，需要选择import gradle 类型的方式;否则eclipse编译会报gradle本地路径找不到的错误
 
### eclipse-integration-gradle插件

  - 插件搭建方式参考:[eclipse搭建Gradle多工程项目](https://www.zybuluo.com/Arison/note/811901) 

## 更新


2017-07-12

- 开始构建gradle多工程项目-javaSE;资料参考：[Gradle多工程配置](https://www.zybuluo.com/Arison/note/744011)

2017-05-10

- okhttp 缓存策略简单处理。

2017-04-20

- 网络库完善：retrofit+okhttp+rxjava 框架进行基本的单个文件上传和下载。多个文件上传和下载。

2017-04-19

- builder设计模式的引入
- 网络库完善：初步利用简单工厂模式来隔离  网络请求具体实现 ,你可以选择retrofit,okhttp,httpClient,HttpUrlConnection,Volley等具体框架或者类库,变换具体类改动比较小。后期打算整改为工厂模式,完全符合开闭原则。
- 案例接口用的是本地服务器程序，有springboot搭建的web应用。[服务器源码](https://github.com/Arisono/Chapter)关于部署springboot 请自行百度。

2017-04-05

- 网络库完善： 封装Retrofit+Rxjava+Okhttp 网络请求
- 网络库完善：添加统一请求头，get，post添加公共参数，利用okhttp的拦截器机制
- 网络库完善：添加响应时间，超时时间，是否打印日志。
- 网络库完善：okhttp错误重试，rxjava错误重试机制，网络请求失败后再次尝试请求

2017-03-13

- 归类java常用的加密算法以及补充测试程序

2017-03-10

- 解析fastjson 序列化反序列化排序问题;toString和parseObject
- api 再次封装和优化okhttp的get,post方法

2017-02-17
  
- 建立rxjava包目录； 测试rxjava1 rxjava2的基本使用
- 了解rxjava的两个方法observeOn与subscribeOn
- 了解rxjava 的rxbus基本封装方式，主要了解PublishSubject的使用

2017-02-15

- 集成okhttp
- 测试接口
