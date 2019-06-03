package com.pengshuai.school.leecode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 *
 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 */
public class SimpleSubject {
    int size = 2048; // 2的11次方 二进制为：100000000000
    int[] map = new int[size];
    int length = 2047; //二进制为：011111111111
    int index;

    /**
     * 因为加入了2047的与运算，导致在只能找出2047以内的数字相加之和等于目标值
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            index = nums[i]&length; //只要值在2047以内，则与运算的结果就等于num[i]
            if (map[index] != 0) {
                return new int[] { map[index] - 1, i };
            } else {
                map[(target - index)&length ] = i + 1;
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum3(int[] nums, int target) {
        Map<Integer,Integer> result = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (result.containsKey(nums[i])) {
                return new int[] { result.get(nums[i]), i };
            } else {
                result.put(target-nums[i],i);
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
        int[] nums = {12,2047,0,3};
        int target = 2059;
//        long t0 = System.nanoTime();
        int[] result = simpleSubject.twoSum3(nums,target);
//        long t1 = System.nanoTime();
//        long mills = TimeUnit.NANOSECONDS.toMicros(t1 - t0);
//        long mills = t0 - t1;
        System.out.print(Arrays.toString(result));
    }
}
