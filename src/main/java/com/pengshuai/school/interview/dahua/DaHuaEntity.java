package com.pengshuai.school.interview.dahua;

/**
 * Created by YangPeng on 2019/3/11.
 */
public class DaHuaEntity {
    private String name;
    private String gender;
    private int age;
    private String height;

    public DaHuaEntity(){}

    public DaHuaEntity(String name,String gender,int age,String height){
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "DaHuaEntity{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", height='" + height + '\'' +
                '}';
    }
}
