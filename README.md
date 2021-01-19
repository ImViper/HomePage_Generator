# 个人主页生成器

本项目制作了一个个人主页的生成器。能够实现输入个人数据，生成一个在线网站供他人查看你的信息。



# 项目地址

[https://github.com/ImViper/HomePage_Generator](https://github.com/ImViper/HomePage_Generator)



# 运行环境

- JavaWeb
- Mysql 8.0
- Tomcat 9.0.39
- VueJs
- 阿里服务器ECS （非必须）
- 阿里云数据库（非必须）



# 效果展示

填写信息界面

![image-20210118202103861](https://tuchuang666.oss-cn-shenzhen.aliyuncs.com/img/image-20210118202103861.png)

![image-20210118202159070](https://tuchuang666.oss-cn-shenzhen.aliyuncs.com/img/image-20210118202159070.png)

![image-20210118202226035](https://tuchuang666.oss-cn-shenzhen.aliyuncs.com/img/image-20210118202226035.png)

![image-20210118202239324](https://tuchuang666.oss-cn-shenzhen.aliyuncs.com/img/image-20210118202239324.png)

![image-20210118202252933](https://tuchuang666.oss-cn-shenzhen.aliyuncs.com/img/image-20210118202252933.png)

![image-20210118202258591](https://tuchuang666.oss-cn-shenzhen.aliyuncs.com/img/image-20210118202258591.png)

生成界面

![image-20210118202312318](https://tuchuang666.oss-cn-shenzhen.aliyuncs.com/img/image-20210118202312318.png)

![image-20210118202322401](https://tuchuang666.oss-cn-shenzhen.aliyuncs.com/img/image-20210118202322401.png)

![image-20210118202328018](https://tuchuang666.oss-cn-shenzhen.aliyuncs.com/img/image-20210118202328018.png)

![image-20210118202333474](https://tuchuang666.oss-cn-shenzhen.aliyuncs.com/img/image-20210118202333474.png)


# 部署到阿里云ECS服务器方法
# 1、阿⾥云服务器搭建概览

![image-20210119194350161](https://tuchuang666.oss-cn-shenzhen.aliyuncs.com/img/image-20210119194350161.png)



[阿⾥云ecs服务器购买地址](https://www.aliyun.com/product/ecs?userCode=k6ji3ksd)

# 2、搭建详细流程

### 1.购买时,如图选择按量付费

![img](https://tuchuang666.oss-cn-shenzhen.aliyuncs.com/img/wps5.png)



### 2.如图选择CPU

![image-20210119194852407](https://tuchuang666.oss-cn-shenzhen.aliyuncs.com/img/image-20210119194852407.png)



### 3.如图选择操作系统为 宝塔linux⾯板

![image-20210119194427148](https://tuchuang666.oss-cn-shenzhen.aliyuncs.com/img/image-20210119194427148.png)

### 4.选择按使⽤流量 设置为80M (学⽣机⽆法设置)

![image-20210119194915804](https://tuchuang666.oss-cn-shenzhen.aliyuncs.com/img/image-20210119194915804.png)

### 5.设置服务器密码



![img](C:\Users\Viper\AppData\Local\Temp\ksohtml14380\wps7.png)

### 6.配置安全组

![image-20210119194501485](https://tuchuang666.oss-cn-shenzhen.aliyuncs.com/img/image-20210119194501485.png)



![img](C:\Users\Viper\AppData\Local\Temp\ksohtml14380\wps9.png)



点击快速添加，添加对应的规则如图所示。

![img](C:\Users\Viper\AppData\Local\Temp\ksohtml14380\wps10.png)

![image-20210119195043644](https://tuchuang666.oss-cn-shenzhen.aliyuncs.com/img/image-20210119195043644.png)







### 7.在浏览器中输⼊ecs服务器的公⽹ip:8888, 根据提示⾃定义你的管理员账号和密码

如果不存在账号密码⾃定义⻚⾯**,** 可以按照下图流程获取默认账户和密码。

![image-20210119194708962](https://tuchuang666.oss-cn-shenzhen.aliyuncs.com/img/image-20210119194708962.png)







8. ### 进⼊宝塔控制⾯板后 , 进⼊软件商店,搜索tomcat后点击安装

   ![image-20210119195917551](https://tuchuang666.oss-cn-shenzhen.aliyuncs.com/img/image-20210119195917551.png)



![](https://tuchuang666.oss-cn-shenzhen.aliyuncs.com/img/wps15.png)

9. #### 安装后, 如图搜索tomcat, 并设置端⼝号



![img](C:\Users\Viper\AppData\Local\Temp\ksohtml14380\wps16.png)安装后, 如图搜索tomcat, 并设置端⼝号







![img](C:\Users\Viper\AppData\Local\Temp\ksohtml14380\wps17.jpg)

#### 10.如图点击进⼊tomcat安装的⽂件夹 , 并进⼊webapps⽂件夹



![img](C:\Users\Viper\AppData\Local\Temp\ksohtml14380\wps18.jpg)



|      |                                                              |
| ---- | ------------------------------------------------------------ |
|      | ![img](C:\Users\Viper\AppData\Local\Temp\ksohtml14380\wps19.png) |







11. #### 将你编写的程序⽂件上传到webapps/ROOT⽂件夹中 , 即可通过 ip地址  来访问你的项⽬

本次测试项目实例：

页面展示

![image-20210119200400206](https://tuchuang666.oss-cn-shenzhen.aliyuncs.com/img/image-20210119200400206.png)





# 免费获取ECS服务器方法

你也可以免费获取一个临时的ecs服务器，供自己测试。

首先选择体验阿里云ECS博客搭建。[网站](https://developer.aliyun.com/adc/scenario/fdecd528be6145dcbe747f0206e361f3?spm=a2c6h.15013979.J_7591448770.1.7f447077NAyF7i)如下：https://developer.aliyun.com/adc/scenario/fdecd528be6145dcbe747f0206e361f3?spm=a2c6h.15013979.J_7591448770.1.7f447077NAyF7i

在此处获取资源以后，登录进入账户获取实例。

![image-20210119195551231](https://tuchuang666.oss-cn-shenzhen.aliyuncs.com/img/image-20210119195551231.png)

点击更多，云盘和镜像，操作系统

![image-20210119195616404](https://tuchuang666.oss-cn-shenzhen.aliyuncs.com/img/image-20210119195616404.png)

在镜像市场里选择宝塔即可

![image-20210119195653202](https://tuchuang666.oss-cn-shenzhen.aliyuncs.com/img/image-20210119195653202.png)