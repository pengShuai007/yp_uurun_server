package com.pengshuai.school.leecode;

import java.util.Arrays;

/**
 * Created by YangPeng on 2019/2/18.
 */
public class SimpleSubject {
    int size = 2048;
    int[] map = new int[size];
    int length = 2047;
    int index;
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            index = nums[i]&length; //
            if (map[index] != 0) {
                return new int[] { map[index] - 1, i };
            } else {
                map[(target - index)&length ] = i + 1;
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i< nums.length; i++){
            int one = nums[i];
            for(int j = i + 1; j < nums.length; j++){
                int two = nums[j];
                if(one + two == target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public static void main(String args[]){
        SimpleSubject simpleSubject = new SimpleSubject();
        int[] nums = {2, 7, 11, 15,3,3,3,3,3,3,3,3,2050,3,3};
        int target = 2057;
//        long t0 = System.nanoTime();
        int[] result = simpleSubject.twoSum(nums,target);
//        long t1 = System.nanoTime();
//        long mills = TimeUnit.NANOSECONDS.toMicros(t1 - t0);
//        long mills = t0 - t1;
        System.out.print(Arrays.toString(result));
    }
}
