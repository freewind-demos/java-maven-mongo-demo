Java Maven DocumentDB Demo
=====================

DocumentDB是AWS提供的与MongoDB兼容的no-sql数据库服务。与MongoDB兼容到直接使用mongodb的命令行和各种sdk就可以访问。

它的问题在于：它创建之后只能在同一个VPC（虚拟私有云）里被其它服务访问，而不允许从外部访问，就算把它的Security Group（防火墙）设置为允许所有流入流量也不行，必须在同一个VPC内创建一台EC2，并在本机电脑使用ssh tunnel将其作为跳板机才行。这相当反直觉，并且配置过程很复杂，对于新人很不友好。

下面这个视频完整展示了整个流程：

- 创建DocumentDB实例
- 创建同VPC内的EC2实例，并在其上访问DocumentDB
- 通过SSH隧道将EC2实例配置为跳板机，并从本机访问

视频教程：<https://photos.app.goo.gl/Dk3Kq9AJWkXHAbjz5>

当我们按照教程内容可以在本地访问mongodb后，将其连接字符串复制到Hello.java中，即可试用。

Run `Hello.java` in your IDE.