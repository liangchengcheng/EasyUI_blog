package com.lcc.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * Created by lcc on 2017/1/6.
 */
public class CryptographyUtil {

    public static String md5(String str,String salt){
        return new Md5Hash(str, salt).toString();
    }

    public static void main(String[] args) {
        String password="123456";
    }
}
