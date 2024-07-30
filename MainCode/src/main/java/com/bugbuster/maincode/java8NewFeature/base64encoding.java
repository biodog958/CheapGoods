package com.bugbuster.maincode.java8NewFeature;

import io.netty.handler.codec.base64.Base64Encoder;

import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Base64;

/**
 * base64编码
 */
public class base64encoding {


    public static void main(String[] args) throws UnsupportedEncodingException {
        String base64encodedString = Base64.getEncoder().encodeToString("runoob?java8".getBytes("utf-8"));
        System.out.println(base64encodedString);
        byte[] decode = Base64.getDecoder().decode(base64encodedString);
        String s = new String(decode, Charset.defaultCharset());
        System.out.println(s);
        System.out.println("这是一个新的分支");
        System.out.println("这是另一个测试");
        System.out.println("branch1");


    }


}
