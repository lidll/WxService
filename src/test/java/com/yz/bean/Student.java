package com.yz.bean;

import lombok.ToString;

import java.io.OutputStream;

/**
 * @ClassName Student
 * @Description TODO
 * @Author noah
 * @Date 2020-04-17 19:00
 * @Version 1.0
 **/
@ToString
public class Student {
    private String name;
    private int age;
    private String nickName;

    public Student setName(String name){
        this.name = name;
        return this;
    }
    public Student setAge(int age){
        this.age = age;
        return this;
    }
    public Student setNickName(String nickName){
        this.nickName = nickName;
        return this;
    }

    public void play(String thing){
        System.out.println(this.name + "now do" + thing);
    }

    private void playp(String thing){
        System.out.println(this.name + "now do" + thing);
    }
}


