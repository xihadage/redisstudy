package com.redis.protocol;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by goldencis on 2019/4/6.
 */
public class Protocol {
    public static final String DOLLAR_BYTE="$";
    public static final String ASTERISK_BYTE="*";
    public static final String BLACK_STRING="\r\n";

    //组装数据
/*
*  * 3  数组3
    $3   字符3
    SET
    $6   字符6
    wukong
    $4   字符4
    2018*/
    public static void sendCommand(OutputStream os,Command command,byte[] ... args){
        StringBuilder sb = new StringBuilder();
        sb.append(ASTERISK_BYTE).append(args.length+1).append(BLACK_STRING);
        sb.append(DOLLAR_BYTE).append(command.name().length()).append(BLACK_STRING);
        sb.append(command.name()).append(BLACK_STRING);

        for ( final byte[] arg:args){
            sb.append(DOLLAR_BYTE).append(arg.length).append(BLACK_STRING);
            sb.append(new String(arg)).append(BLACK_STRING);
        }
        try {
            os.write(sb.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static enum Command{
        GET,SET,KEYS
    }
}
