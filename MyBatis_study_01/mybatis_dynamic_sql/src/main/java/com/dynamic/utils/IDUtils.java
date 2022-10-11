package com.dynamic.utils;

import org.junit.Test;

import java.util.UUID;

public class IDUtils {
    // 获取随机的id
    public static String getId(){
        return UUID.randomUUID().toString().replace("-","");
    }
    @Test
    public void test(){
        System.out.println(IDUtils.getId());
    }
}
