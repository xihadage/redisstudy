package com.redis.connection;

import com.redis.protocol.Protocol;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by goldencis on 2019/4/6.
 * 传输层
 */
public class Connection {
    private Socket socket;
    private String host;
    private int port;
    private OutputStream outputStream;
    private InputStream inputStream;

    public Connection(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Connection connection(){
        try {
            if (!isConnectioned()){
                socket=new Socket(host,port);
                inputStream = socket.getInputStream();
                outputStream=socket.getOutputStream();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    private boolean isConnectioned() {
        return socket!=null&&socket.isBound();
    }

    //发送数据
    public Connection sendCommand(Protocol.Command command,byte[] ... args){
        connection();
        Protocol.sendCommand(outputStream,command,args);
        return this;
    }

    //获取数据
    public  String getStatusCodeReply(){
        byte[] bytes = new byte[1024];
        try {
            socket.getInputStream().read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(bytes);
    }
}
