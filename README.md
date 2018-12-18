<p align="center">
    <a href="http://fsblog.letec.top">
        <img width="200" src="screenshots/logo.png">
    </a>
</p>


## 基于 Spring Boot 的个人博客


### 1. 涉及技术及工具

- 核心框架：SpringBoot
- ORM 框架：MyBatis
- MyBatis 工具：MyBatis Mapper 
- MVC 框架：Spring MVC
- 模板引擎：Freemarker
- 编译辅助插件：Lombok
- CSS 框架：BootStrap 4.0
- Markdown 编辑器：Editor.md
- 数据库：MySQL


### 2. 效果图

#### 2.1 首页
![首页](screenshots/home.png)

#### 2.2 博客列表页
![文章列表](screenshots/posts.png)


#### 2.3 博客阅读页
![文章阅读](screenshots/blog.png)


#### 2.4 个人简历页
![个人简历](screenshots/resume.png)


#### 2.5 文章编辑页
![编辑器](screenshots/editor.png)


### 3. 构建及运行

#### 3.1 服务器环境

- 安装 ``MySQL``
- 安装 ``Gradle``
- 在项目目录下运行 ``gradle clean build``，生成的 jar 包位于 ``build/libs`` 目录下，使用 ``java -jar .../fsblog.jar`` 运行
- 在 ``application-dev.yml`` 中配置数据库用户名和密码，默认为：``username: root password: root``
- 默认自动创建数据库、数据表并自动导入初始数据，同样在``application-dev.yml``中配置
- 后台管理默认用户名为 ``admin``，密码为 ``123456``

#### 3.2 开发环境

- 可直接在 IntelliJ IDEA 或 Eclipse 中打开项目进行二次开发

### 6. 开源协议

[Apache License 2.0](http://apache.org/licenses/LICENSE-2.0.html)

Copyright (c) 2017-present, czbcxy



### 7. docker部署
1.创建Dockerfile 
创建一个文件名为Dockerfile的文件，复制以下内容到文件中

`FROM java:8 
VOLUME /tmp 
ADD lemon-member-0.0.1.jar app.jar 
RUN bash -c ‘touch /app.jar’ 
ENTRYPOINT [“java”,”-Djava.security.egd=file:/dev/./urandom”,”-jar”,”/app.jar”]`

其中 lemon-member-0.0.1.jar为你的jar包的名字,其他配置解释后续添加

2.创建docker镜像 
将创建好的Dockerfile文件和jar包上传到服务器，放在同一文件夹下,进入jar包所在文件夹,执行命令

`docker build -t lemon-order .`

lemon-order为生成的镜像名， .表示当前目录

3.查看生成的镜像

`docker images`

可以看到有一个名为lemon-order的镜像

4.创建容器并运行jar包

`docker run -d -p 8080:8080 lemon-order`

-d表示在后台运行

-p 指定端口号 第一个8080 为 容器内部的端口号 第二个8080位外界访问的端口号,将容器内的8080端口号映射到外部的8080端口号

5.然后就可以通过外网ip+端口号访问项目

"# myblogo" 
