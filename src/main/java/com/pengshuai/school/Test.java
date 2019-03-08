package com.pengshuai.school;

/**
 * Created by YangPeng on 2019/3/8.
 */
public class Test extends Study {
    static int a = 2;
    static {
        a = 20;
        System.out.println("4");
    }
    public Test(){
        System.out.println("5");
    }
}
