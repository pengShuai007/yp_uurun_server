package com.pengshuai.school.leecode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2019/9/15 0015.
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class GetLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        ArrayList list = new ArrayList();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(list.contains(c)){
                longest = list.size() > longest ? list.size() : longest;
                list.removeAll(list.subList(0,list.indexOf(c) + 1));
                list.add(c);
            }else{
                list.add(c);
            }
        }
        return list.size() > longest ? list.size() : longest;
    }

    /**
     * 别人写的高效方法
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        HashMap<Character, Integer> res = new HashMap<>();
        int len = s.length();
        int i = 0, j = 0;
        int sum = 0;
        while (i < len && j < len){
            // 重复子串，滑动左边窗口
            if (res.containsKey(s.charAt(j))){
                i = Math.max(res.get(s.charAt(j)) + 1, i);
            }
            res.put(s.charAt(j), j++);
            sum = Math.max(sum, j - i);
        }
        return sum;
    }

    public static void main(String args[]){
        String s = "ohomm";
        GetLongestSubstring getLongestSubstring = new GetLongestSubstring();
        int p = getLongestSubstring.lengthOfLongestSubstring2(s);
        System.out.println(p);
    }
}
