package com.pengshuai.school;

public class Main {

    public static void main(String args[]){
        String a = "1234567890";
        for(int i = 0; i< a.length();i+=8){
            if(i + 8 > a.length()){
                String out = a.substring(i);
                while(out.length() < 8){
                    out += "0";
                }
                System.out.println(out);
            }else{
                System.out.println(a.substring(i,i+8));
            }
        }
    }
}