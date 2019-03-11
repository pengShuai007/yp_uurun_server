package com.pengshuai.school.interview.dahua;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by YangPeng on 2019/3/11.
 * 大华面试相关问题整理
 * 面试时间：2019-03-09
 */
public class InterviewDaHua {

    public static void main(String[] args){
        InterviewDaHua interviewDaHua = new InterviewDaHua();
        interviewDaHua.sortListJdk8();
    }

    /**
     * String类中常用的静态方法
     */
    public void StringStaticMethod(){
        System.out.println(String.join(",","a","b","c"));
        System.out.println(String.copyValueOf(new char[]{'a','b','c'}));
        System.out.println(String.format("Hi,%s","鹏"));
        System.out.println(String.valueOf(123));
    }

    /**
     * double和long哪个可以存放的数值范围更大
     */
    public void doubleAndLong(){
        System.out.println("double的最大值" + Double.MAX_VALUE);
        System.out.println("double的最小值" + Double.MIN_VALUE);
        System.out.println("long的最大值" + Long.MAX_VALUE);
        System.out.println("long的最小值" + Long.MIN_VALUE);
    }

    /**
     * HashMap如何实现key不能重复
     */
    public void hashMapKey(){
        HashMap hashMap = new HashMap();
        hashMap.put("yang","peng");
        hashMap.put("yang","yang");
    }

    /**
     * 通过实体某一属性对list里对象排序 JDK7
     */
    public void sortList(){
        DaHuaEntity daHuaEntity = new DaHuaEntity("姓名1","男",8,"180cm");
        DaHuaEntity daHuaEntity1 = new DaHuaEntity("姓名1","男",9,"180cm");
        DaHuaEntity daHuaEntity2 = new DaHuaEntity("姓名1","男",10,"180cm");
        DaHuaEntity daHuaEntity3 = new DaHuaEntity("姓名1","男",11,"180cm");
        DaHuaEntity daHuaEntity4 = new DaHuaEntity("姓名1","男",12,"180cm");

        ArrayList<DaHuaEntity> entityArrayList = new ArrayList<>();
        entityArrayList.add(daHuaEntity4);
        entityArrayList.add(daHuaEntity);
        entityArrayList.add(daHuaEntity2);
        entityArrayList.add(daHuaEntity3);
        entityArrayList.add(daHuaEntity1);

        entityArrayList.forEach(a->System.out.println(a.toString()));

        Collections.sort(entityArrayList, new Comparator<DaHuaEntity>(){
            @Override
            public int compare(DaHuaEntity o1, DaHuaEntity o2) {
                int diff = o1.getAge() - o2.getAge();
                if(diff > 0){
                    return 1;
                }else if(diff < 0){
                    return -1;
                }
                return 0; //相等
            }
        });
        System.out.println("----------排序后----------");
        entityArrayList.forEach(a->System.out.println(a.toString()));
    }

    public void sortListJdk8(){
        DaHuaEntity daHuaEntity = new DaHuaEntity("姓名1","男",8,"180cm");
        DaHuaEntity daHuaEntity1 = new DaHuaEntity("姓名1","男",9,"180cm");
        DaHuaEntity daHuaEntity2 = new DaHuaEntity("姓名1","男",10,"180cm");
        DaHuaEntity daHuaEntity3 = new DaHuaEntity("姓名1","男",11,"180cm");
        DaHuaEntity daHuaEntity4 = new DaHuaEntity("姓名1","男",12,"180cm");

        ArrayList<DaHuaEntity> entityArrayList = new ArrayList<>();
        entityArrayList.add(daHuaEntity4);
        entityArrayList.add(daHuaEntity);
        entityArrayList.add(daHuaEntity2);
        entityArrayList.add(daHuaEntity3);
        entityArrayList.add(daHuaEntity1);
        List<DaHuaEntity> list = entityArrayList.stream().sorted(Comparator.comparing(DaHuaEntity::getAge)).collect(Collectors.toList());
        System.out.println("----------排序后----------");
        list.forEach(a->System.out.println(a.toString()));
    }
}
