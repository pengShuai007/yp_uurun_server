package com.pengshuai.school;

import java.util.ArrayList;

/**
 * Created by YangPeng on 2019/2/22.
 */
public class Study {

    public static void main(String args[]){
        ArrayList arrayList = new ArrayList();
        int[] a = new int[10];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        a[3] = 4;
        int[] b = new int[10];
        System.arraycopy(a,1,b,0,4);
        for(int i = 0; i < b.length;i++ ){
            System.out.println(b[i]);
        }
    }
}
