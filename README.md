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

##  Star曲线

[![Stargazers over time](https://starchart.cc/shaoxiongdu/blog.svg)](https://github.com/shaoxiongdu/books)

## 需求分析

### 1.1编写目的

​	软件需求说明书描述了“维信书城”1.0版本的软件功能性需求和非功能性需求。这一文档计划有实现系统功能和验证系统功能正确的项目团队和成员来使用。编写此说明书可以保证软件开发的质量，需求的完整性和可追溯性，编写此文档，通过此文档，以保证业务需求和需求分析人员，开发人员，测试人员以及相关利益人对需求达成共识。

### **1.2**  项目背景描述

​	随着社会的不断进步,网络的不断发展,越来越多的网上商城相继出现。例如全球知名的亚马逊网上书店,国内的当当上商城和卓越网等。顾客甚至足不出户就可以买到所需要的商品,从而节约大量时间,将更多的时间应用于其他更有意义的事情上

​	传统的书店存在着许多弊端,如商品种类太少,经营成本高等。相比之下电商城具有以下优势:商品种类多,信息量大;检索、订购快捷方便;书店成本低,商品价格低廉;节约顾客购买时间;为了降低商店的成本,节约顾客的时从而开发此电子商城

系统主要分为前台和后台。

前台包括书籍的展示及购物车模块，订单管理模块，登录退出模块

后台是管理模块，主要包括商品信息、订单信息的管理等。

### 1.3 参考资料

(1)需求工程--软件建模与分析（第二版） 骆斌 丁二玉所著

(2)数据库系统概念（原书第6版） 希尔伯沙茨所著

(3)Java开发实战经典(名师讲坛)  李兴华所著



## 总体描述

### 产品前景

​	传统的书籍购买需要到书店中，此系统利用电子商务，创新性的将系统搬到网上。更加方便。

### 产品功能

​	维信书城是在线购买书籍的网站。顾客可以将想要的书籍添加到自己的购物车。然后下单。也可查看自己的订单列表。

​	管理员可以对书籍的信息，订单信息，用户信息进行管理。

### 用户类型及其特征

| 用户类 | 描述                                                         |
| ------ | ------------------------------------------------------------ |
| 管理员 | 对书籍的信息，订单信息，用户信息进行管理，对订单进行发货     |
| 用户   | 想要的书籍添加到自己的购物车。然后下单。也可查看自己的订单列表。 对订单i进行确认收货 |

### 运行环境

#### 客户机：普通PC 

 CPU：P4 1.8GHz 

内存：256MB以上  

分辨率：推荐使用1024*768像素 l

#### WEB服务器 

 Internet 信息服务（IIS）管理器 l

数据库服务器  

CPU：P4 1.8GHz

 内存：256MB以上

#### 设计和实现上的约束

CO-1: 系统的设计、编码和维护文档遵照Process Impact Intranet 	Development Standard(Process Impact 公司互联网开发标准)版本1.3.

CO-2: 系统将采用标准的MySql数据库引擎.

CO-3: 所有HTML代码将遵照HTML5.0标准.

#### 假设和依赖

AS-1:只要服务器正常运行，顾客或者管理员即可访问。

DE-1：本系统不依赖任何系统。

## 非功能性业务需求

(1)允许多人同时注册登录

(2)系统响应速度不能太慢

(3)允许不同用户在不同pc访问页面

(4)界面美观大方友好易于操作,相应的地方具有提示性文字

(5)系统可以配置部署到不同环境中

(6)代码格式规范,具有较强可读性,具有相应注释

##  关系图

![img](https://images-1301128659.cos.ap-beijing.myqcloud.com/wps1.jpg) 

## 表清单

| **#** | **数据表** | **名称** | **备注说明** |
| ----- | ---------- | -------- | ------------ |
| 1     | BOOK       | 书籍表   |              |
| 2     | ORDER      | 订单表   |              |
| 3     | ORDER_ITEM | 订单项表 |              |
| 4     | USER       | 用户表   |              |

## 表字段明细

### 	BOOK 书籍表

| **#** | **字段** | **名称**    | **数据类型**  | **主键** | **非空** | **默认值** | **备注说明** |
| ----- | -------- | ----------- | ------------- | -------- | -------- | ---------- | ------------ |
| 1     | ID       | 书籍ID      | VARCHAR(32)   | √        | √        |            | 书籍ID       |
| 2     | NAME     | 书籍名称    | VARCHAR(90)   |          |          |            | 书籍名称     |
| 3     | PRICE    | 价格        | DECIMAL(24,6) |          |          |            | 价格         |
| 4     | AUTHOR   | 作者        | VARCHAR(90)   |          |          |            | 作者         |
| 5     | SALES    | 销量        | INT           |          |          |            | 销量         |
| 6     | STOCK    | 库存        | INT           |          |          |            | 库存         |
| 7     | IMG_PATH | 封面图片URL | VARCHAR(900)  |          |          |            | 封面图片URL  |

### 	ORDER 订单表

| **#** | **字段**    | **名称** | **数据类型**  | **主键** | **非空** | **默认值** | **备注说明** |
| ----- | ----------- | -------- | ------------- | -------- | -------- | ---------- | ------------ |
| 1     | ORDER_ID    | 订单号   | VARCHAR(32)   | √        | √        |            | 订单号       |
| 2     | CREATE_TIME | 创建时间 | DATETIME      |          |          |            | 创建时间     |
| 3     | PRICE       | 订单总价 | DECIMAL(24,6) |          |          |            | 订单总价     |
| 4     | STATUS      | 订单状态 | VARCHAR(90)   |          |          |            | 订单状态     |
| 5     | USER_ID     | 用户ID   | VARCHAR(32)   |          |          |            | 用户ID       |

###  ORDER_ITEM 订单项表

| **#** | **字段**    | **名称** | **数据类型**  | **主键** | **非空** | **默认值** | **备注说明** |
| ----- | ----------- | -------- | ------------- | -------- | -------- | ---------- | ------------ |
| 1     | ID          | 订单项ID | VARCHAR(32)   | √        | √        |            | 订单项ID     |
| 2     | NAME        | 商品名称 | VARCHAR(90)   |          |          |            | 书籍名称     |
| 3     | COUNT       | 数量     | INT           |          |          |            | 数量         |
| 4     | PRICE       | 单价     | DECIMAL(24,6) |          |          |            | 单价         |
| 5     | TOTAL_PRICE | 总价     | DECIMAL(24,6) |          |          |            | 总价         |
| 6     | ORDER_ID    | 订单号   | VARCHAR(32)   |          |          |            | 订单号       |

### USER 用户表

| **#** | **字段** | **名称** | **数据类型** | **主键** | **非空** | **默认值** | **备注说明** |
| ----- | -------- | -------- | ------------ | -------- | -------- | ---------- | ------------ |
| 1     | ID       | 用户ID   | VARCHAR(32)  | √        | √        |            | 用户ID       |
| 2     | ACCOUNT  | 账号     | VARCHAR(90)  |          |          |            | 账号         |
| 3     | PASSWORD | 密码     | VARCHAR(90)  |          |          |            | 密码         |
| 4     | EMAIL    | 邮箱     | VARCHAR(90)  |          |          |            | 邮箱         |

## 详细设计

1. 订单模块分析

   ![订单模块架构分析](https://images-1301128659.cos.ap-beijing.myqcloud.com/%E8%AE%A2%E5%8D%95%E6%A8%A1%E5%9D%97%E6%9E%B6%E6%9E%84%E5%88%86%E6%9E%90.png)

## 截图预览

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

## 项目选型

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

## 运行教程

#### 1.导入项目 [GitHub地址](https://github.com/shaoxiongdu/blog)

Fork本项目,用IDEA新建项目，点击 Create Project For Version Control，复制项目github地址 粘贴到IDEA中的Git地址输入框 ，点击clone　等待项目下载即可

### 2.数据库导入相关

- 新建一个名为books的数据库,选择UTF-8字符集，运行DB文件夹下的sql建表脚本,生成表结构。

- 导入DB文件夹下的数据.sql
- 修改src/main/resources/c3p0-config.xml文件中的数据库相关配置

### 3.测试

- 新建本地/远程tomcat服务器运行实例，并部署本项目即可运行。

## 说明

- #### 后端管理页面是http://主机:端口/项目名/admin

> ###

## 项目反馈及改进（非常欢迎！）

如果您在学习或者部署本项目的时候遇到了任何问题，或者项目有任何可以改进的地方，欢迎提出issues,看到就会回馈.并且将您添加到项目贡献者列表中.

## 参与贡献 （非常欢迎！）

1. Fork 本仓库
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request，填写必要信息。
5. 等待审核即可。通过之后会邮件通知您。
