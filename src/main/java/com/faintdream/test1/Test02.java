package com.faintdream.test1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test02 {
    public static void main(String[] args) {
        String hostName = getHostName();
        System.out.print("主机名:");
        System.out.print(hostName);
        System.out.println();

    }
    /**
     * 获取主机名
     *
     * @return 本地主机名
     */
    public static String getHostName()
    {
        try
        {
            return InetAddress.getLocalHost().getHostName();
        }
        catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
        return "未知";
    }
}
