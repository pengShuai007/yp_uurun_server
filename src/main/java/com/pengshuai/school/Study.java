package com.pengshuai.school;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YangPeng on 2019/2/22.
 */
public class Study {

//    static int a= 1;
//    static {
//        a = 10;
//        System.out.println("1");
//    }
//
//    public Study(){
//        System.out.println("2");
//    }


    public static void main(String args[]){
//        List<String> a = null;
//        test(a);
//        System.out.println(a.size());

//        Study s = new Study();
//        System.out.println(s.value());

//        int x = 2;
//        int y = 3;
//        System.out.print(x|y);
//        System.out.print(",");
//        System.out.print(x&y);
//        System.out.print(",");
//        System.out.print(x^y);
//        System.out.print(",");
//        System.out.print(y << x);
//        System.out.print(",");
//        System.out.print(~x);

//        System.out.println("3");
//        Study s = new Test();

        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int num4 = 0;
        int num5 = 0;
        for(int i =0 ;i < 5;i++){
            switch (i){
                case 1: num1++;
                case 2: num2++;
                case 3: num3++;
                case 4: num4++;
                case 5: num5++;
            }
        }
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
        System.out.println(num4);
        System.out.println(num5);
    }

//    public String value(){
//        int a = 5;
//        try {
//            throw new Exception();
//        } catch (Exception e) {
//            return "a=" + a;
//        }finally {
//            a = 7;
//            System.out.println("a=" + a);
//        }
//    }

    public static void test(List<String> a ){
        a = new ArrayList<>();
        a.add("abc");
    }
}
