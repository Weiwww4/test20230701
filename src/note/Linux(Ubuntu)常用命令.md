### Linux(Ubuntu)常用命令

* ip `ip addr show` 显示和配置网络接口和路由表的信息

* *ping `ping 192.168.117.1` 向主机发送 ICMP 回显请求并接收 ICMP 回显回复。通常用于测试网络连接和检测目标主机的可达性
  
* *curl `curl www.bilibili.com` 通过 URL 发送请求并获取响应

* wget `wget https://dlcdn.apache.org/maven/maven-3/3.9.3/binaries/apache-maven-3.9.3-bin.zip`
  下载文件(支持 HTTP、HTTPS 和 FTP 协议)
  * `wget -b https://dlcdn.apache.org/maven/maven-3/3.9.3/binaries/apache-maven-3.9.3-bin.zip`
  htxz

* netstat `netstat` 显示网络连接、路由表和网络统计信息
  * `netstat -a` 显示所有活动的网络连接  
  * `netstat -l` 显示监听状态的端口
  * `netstat -p` 显示进程与网络连接之间的关联
  * `netstat -i` 显示当前系统上的网络接口信息
  * `netstat -c` 显示当前接口的所有连接信息


