package com.pengshuai.school;

import java.util.Scanner;

/**
 * Created by YangPeng on 2019/3/8.
 */
public class Test {

    public static void main(String args[]){
        char c = 'c';
        String s = "avDre";
        String findStr = " ";
        char compareOne = findStr.toUpperCase().toCharArray()[0];
        char compareTwo = findStr.toLowerCase().toCharArray()[0];
        Scanner in = new Scanner(System.in);
        String input = in.next();
        System.out.println(input);
        if(in.hasNextLine()){
            String ss = in.next();
            System.out.println(ss);
        }

    }
}
