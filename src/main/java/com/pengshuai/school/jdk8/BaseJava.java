package com.pengshuai.school.jdk8;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by YangPeng on 2019/2/3.
 */
public class BaseJava {

    public static void main(String[] args){
        HashMap hashMap = new HashMap();
        Map map = new HashMap();
        Hashtable hashtable = new Hashtable();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
    }

    public synchronized void  test(){
        int[] aa = new int[10];
        System.out.print("123");
    }
}
