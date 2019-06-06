package com.pengshuai.school.leecode;

/**
 * Created by YangPeng on 2019/6/5.
 */
public class RegexTest {

    public static void main(String args[]){
        String input = "%%_%_%";
        String r = input.replaceAll("((%_%)|(%%)|(%)|(_%))", "");
        System.out.print(r);
    }
}
