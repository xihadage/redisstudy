package com.redis.client;

import com.redis.connection.Connection;
import com.redis.protocol.Protocol;

import java.io.IOException;

/**
 * Created by goldencis on 2019/4/6.
 * API层
 */
public class Client {

    Connection connection;

    public Client(String host,int port) {
        this.connection = new Connection(host,port);
    }

    public String set(String key,String value) throws IOException {
        connection.sendCommand(Protocol.Command.SET,key.getBytes(),value.getBytes());
        return connection.getStatusCodeReply();
    }

    public String get(String key){
        connection.sendCommand(Protocol.Command.GET,key.getBytes());
        return connection.getStatusCodeReply();
    }

}
