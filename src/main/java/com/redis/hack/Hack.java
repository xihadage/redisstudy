package com.redis.hack;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by goldencis on 2019/4/6.
 * 模拟服务器
 *
 * 3  数组3
 $3   字符3
 SET
 $6   字符6
 wukong
 $4   字符4
 2018
 */
public class Hack {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6379);
        Socket socket=serverSocket.accept();
        byte[] bytes = new byte[1024];
        socket.getInputStream().read(bytes);
        System.out.println(new String(bytes));
    }
}
