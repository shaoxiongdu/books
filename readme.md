# 书城管理系统

<br>
<div align="center">
    <img src="https://img.shields.io/badge/后端框架-JavaWeb-blue">
    <img src="https://img.shields.io/badge/数据源-MySQL-green">
    <img src="https://img.shields.io/badge/数据库连接池-C3P0-orange">
    <img src="https://img.shields.io/badge/前端表现层-CSS-red"> 
    <img src="https://img.shields.io/badge/前端行为层-JS&Jquery-red"> 
    <img src="https://img.shields.io/badge/后端架构-MVC-red"> 
  <img src="https://visitor-badge.glitch.me/badge?page_id=shaoxiongdu.books" >

<h3>
    <a href="https://shaoxiongdu.github.io/books/#/" target="_blank">在线站点 </a>
</h3>

</div>

## 一. Star曲线

[![Stargazers over time](https://starchart.cc/shaoxiongdu/books.svg)](https://github.com/shaoxiongdu/books)

## 二. 截图预览

### 2.1. 登录页面

![image-20211018224111780](https://images-1301128659.cos.ap-beijing.myqcloud.com/image-20211018224111780.png)

### 2.2. 注册页面

![image-20211018224127125](https://images-1301128659.cos.ap-beijing.myqcloud.com/image-20211018224127125.png)

### 2.3. 书城商品页

![image-20211018224157507](https://images-1301128659.cos.ap-beijing.myqcloud.com/image-20211018224157507.png)

### 2.4. 购物车页

![image-20211018224217108](https://images-1301128659.cos.ap-beijing.myqcloud.com/image-20211018224217108.png)

### 2.5 我的订单

![image-20211018224247680](https://images-1301128659.cos.ap-beijing.myqcloud.com/image-20211018224247680.png)

### 2.6 订单详情

![image-20211018224315130](https://images-1301128659.cos.ap-beijing.myqcloud.com/image-20211018224315130.png)

![image-20211018224329330](https://images-1301128659.cos.ap-beijing.myqcloud.com/image-20211018224329330.png)

### 2.7 图书管理页面

![image-20211018224405712](https://images-1301128659.cos.ap-beijing.myqcloud.com/image-20211018224405712.png)

### 2.8 添加图书

![image-20211018224420814](https://images-1301128659.cos.ap-beijing.myqcloud.com/image-20211018224420814.png)

### 2.9 订单管理

![image-20211018224441526](https://images-1301128659.cos.ap-beijing.myqcloud.com/image-20211018224441526.png)

## 二.项目选型

| 个人博客        | 语言                   | 版本   |
| --------------- | ---------------------- | ------ |
| 前端            | HTML+CSS+JavaScript    | ——     |
| 第三方验证码api | 谷歌kaptcha            | 2.3.2  |
| 数据库工具api   | 阿帕奇 commons-dbutils | 1.3    |
| 后端开发框架    | JavaWeb                |        |
| JDK版本         | Java                   | 1.8    |
| 数据持久层      | C3P0连接池             | 0.9.12 |
| 数据库驱动      | MySQL                  | 5.1.44 |
| 前端标签库      | jstl                   | 1.2.1  |

## 三.运行教程

#### 1.导入项目 [GitHub地址](https://github.com/shaoxiongdu/blog)

Fork本项目,用IDEA新建项目，点击 Create Project For Version Control，复制项目github地址 粘贴到IDEA中的Git地址输入框 ，点击clone　等待项目下载即可

### 2.数据库导入相关

- 新建一个名为books的数据库,选择UTF-8字符集，运行DB文件夹下的sql建表脚本,生成表结构。

- 导入DB文件夹下的数据.sql
- 修改src/main/resources/c3p0-config.xml文件中的数据库相关配置

### 3.测试

- 新建本地/远程tomcat服务器运行实例，并部署本项目即可运行。



## 四.说明

- #### 后端管理页面是http://主机:端口/项目名/admin

## 五、更多开源项目

### 【分享好玩的项目，挖掘开源的价值】。微信扫一扫，关注公众号！

> ![Github推荐](https://gitee.com/ShaoxiongDu/imageBed/raw/master/image-20210820144130666.png)
>
> ### 我是开源君，我爱这个世界！

## 六.项目反馈及改进（非常欢迎！）

如果您在学习或者部署本项目的时候遇到了任何问题，或者项目有任何可以改进的地方，欢迎提出issues,看到就会回馈.并且将您添加到项目贡献者列表中.

## 七.参与贡献 （非常欢迎！）

1. Fork 本仓库
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request，填写必要信息。
5. 等待审核即可。通过之后会邮件通知您。
