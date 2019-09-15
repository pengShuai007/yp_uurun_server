package com.pengshuai.school.leecode;

/**
 * Created by YangPeng on 2019/9/10.
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 回文子串：正着念跟反着念是一样的
 */
public class GetHuiWenInStr {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            i = findLongest(str, i, range);
        }
        return s.substring(range[0],range[1] + 1);
    }

    public int findLongest(char[] str,int low,int[] range){
        int high = low;
        while(high < str.length - 1 && str[high + 1] == str[low]){
            high++;
        }
        int ans = high;
        while(low > 0 && high < str.length -1 && str[low-1] == str[high+1]){
            low --;
            high ++;
        }
        if(high - low > range[1] - range[0]){
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }

    public static void main(String args[]){
        GetHuiWenInStr getHuiWenInStr = new GetHuiWenInStr();
        System.out.println(getHuiWenInStr.longestPalindrome("gfaabccbaqwd"));
    }
}
