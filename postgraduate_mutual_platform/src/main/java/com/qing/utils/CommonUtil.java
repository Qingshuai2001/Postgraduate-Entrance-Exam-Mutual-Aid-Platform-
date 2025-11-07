package com.qing.utils;

import java.util.Random;

public class CommonUtil {
	/**
     * 获取随机字符串，用于验证码
     * @param num
     * @return
     */
    public static String getRandomString(Integer num) {
        String base = "abcdefghkmnopqrstuvwxyz023456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
