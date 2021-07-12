package com.yz;

import com.yz.bean.Student;
import com.yz.enums.Week;
import org.junit.Test;

import java.util.*;

/**
 * @ClassName string_execies
 * @Description TODO
 * @Author noah
 * @Date 2020-04-17 18:53
 * @Version 1.0
 **/
public class string_execies {
    @Test
    public void test(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("hello")
                .append("world");
        System.out.println(stringBuffer.toString());
    }

    @Test
    public void chans(){
        Student student = new Student();
        student.setName("yangzheng").setAge(12).setNickName("zhengge");
        System.out.println(student.toString());

    }

    @Test
    public void stringjoiner(){
        StringJoiner sj = new StringJoiner(" ","hello ","!");
        sj.add("world").add("yang").add("zheng");
        System.out.println(sj.toString());
    }

    @Test
    public void enumTest(){
        System.out.println(Week.MON.value);
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();
        HashMap hashMap = new HashMap();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        HashSet hashSet = new HashSet();
    }
}

