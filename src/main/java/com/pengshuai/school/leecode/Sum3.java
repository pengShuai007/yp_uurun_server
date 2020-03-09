package com.pengshuai.school.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by YangPeng on 2020/2/6.
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 注意：答案中不可以包含重复的三元组
 */
public class Sum3 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int zeroCnt = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                for(int k = j+1; k < nums.length; k++){
                    int r = nums[i] + nums[j] + nums[k];
                    if(r == 0){
                        List<Integer> med = new ArrayList<>();
                        med.add(nums[i]);
                        med.add(nums[j]);
                        med.add(nums[k]);
                        boolean flag = false;
                        if(nums[i] == nums[j] && nums[j] == nums[k]){
                            if(zeroCnt > 0){
                                flag = true;
                            }
                            zeroCnt += 1;
                        } else{
                            for(List<Integer> list : result){
                                if(list.contains(nums[i]) && list.contains(nums[j]) && list.contains(nums[k])){
                                    flag = true;
                                    break;
                                }
                            }
                        }
                        if(!flag){
                            result.add(med);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }

    public static void main(String args[]){
        int[] nums = {0,0,0,0};
        List<List<Integer>> result = threeSum2(nums);
        System.out.print(result.toString());
    }
}

