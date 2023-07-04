package com.faintdream.test1;

import java.io.IOException;
import java.net.InetAddress;

public class Test03 {
    public static void main(String[] args) throws IOException {
        InetAddress localHost = InetAddress.getLocalHost();
        show(localHost);

        InetAddress baidu = InetAddress.getByName("www.baidu.com");
        show(baidu);

        InetAddress bilibili = InetAddress.getByName("www.bilibili.com");
        show(bilibili);
    }

    protected static void show(InetAddress inetAddress) throws IOException {
        // 主机名
        String host = inetAddress.getHostName();
        System.out.println("主机名" + host);

        // 主机IP
        String ip = inetAddress.getHostAddress();
        System.out.println("主机IP:" + ip);


        // 规范主机名
        String canonicalHostName = inetAddress.getCanonicalHostName();
        System.out.println("规范主机名:" + canonicalHostName);


        new Thread(() -> {

            // 是否可达
            boolean reachable = false; // 5000 毫秒超时时间
            try {
                reachable = inetAddress.isReachable(5000);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("%s[%s]是否可达:%s\n",host,ip,reachable);
        } ).start();

        System.out.println();

    }
}
