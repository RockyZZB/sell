package com.imooc.utils;

import java.util.Random;

/**
 * 生成唯一的主键
 * 时间+随机数
 * Creat by ZZZB
 * 2019-02-03 11:18
 */
public class  KeyUtil {
    public static synchronized String genUniqueKey(){
        Random random=new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis()+String.valueOf(number);


    }


}
