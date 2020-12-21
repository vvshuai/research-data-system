package com.sau.data.utils;

import java.security.MessageDigest;

/**
 * @Author: vvshuai
 * @Description:
 * @Date: Created in 22:58 2020/12/18
 * @Modified By:
 */
public class MD5Util {

    public static String getMd5_16(String string) {
        return encrypt32(string).substring(8, 24);
    }

    public static String encrypt32(String encryptStr) {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md5.digest(encryptStr.getBytes());
            StringBuffer hexValue = new StringBuffer();
            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16)
                    hexValue.append("0");
                hexValue.append(Integer.toHexString(val));
            }
            encryptStr = hexValue.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return encryptStr;
    }
}
