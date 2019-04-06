package com.redis;

import com.redis.client.Client;
import redis.clients.jedis.Jedis;

import java.io.IOException;

/**
 * Created by goldencis on 2019/4/6.
 */
public class demo {
    public static void main(String[] args) throws IOException {
        //调用jedis
        Jedis jedis=new Jedis("127.0.0.1",6379);
        jedis.set("wukong","2018");
        System.out.println(jedis.get("wukong"));

        //自定义
        Client client=new Client("127.0.0.1",6379);
        System.out.println(client.set("wukong","2019"));
        System.out.println(client.get("wukong"));
    }
}
