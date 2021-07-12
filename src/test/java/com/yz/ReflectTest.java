package com.yz;


import com.yz.bean.Student;

import java.lang.reflect.Method;
import java.util.StringJoiner;

/**
 * @ClassName ReflectTest
 * @Description TODO
 * @Author noah
 * @Date 2020-04-17 19:50
 * @Version 1.0
 **/
public class ReflectTest {

    public static void main(String[] args) throws Exception{
        //调用String的substring方法(int, int)
//        Class<String> stringClass = String.class;
//        String demoStr = "ni da ye de";
//        Method substring = stringClass.getMethod("substring", int.class, int.class);
//        String invoke = (String)substring.invoke(demoStr, 0, 2);
//        System.out.println(invoke);


        //调用一个静态方法
//        Class<Integer> integerClass = Integer.class;
//        String intStr = "1";
//        Method parseInt = integerClass.getMethod("parseInt", String.class);
//        Integer invoke = (Integer) parseInt.invoke(null, intStr);
//        System.out.println(invoke instanceof Integer);

        //调用一个非public方法
        /*
                      报错：object is not an instance of declaring class
                      由于没有实例化可以有如下两种方法：
                      1、反射方法定义成为static的，故被反射类就不需要实例化；
                      2、method.invoke(_class.newInstance(), args);
                      
         */
        Class<Student> studentClass = Student.class;
        Method playp = studentClass.getDeclaredMethod("playp", String.class);
        playp.setAccessible(true);
        Student student = studentClass.newInstance();
        student.setName("qiuqiu ");
        playp.invoke(student,"球");
    }
}
