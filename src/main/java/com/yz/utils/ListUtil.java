package com.yz.utils;

import java.util.Collection;
import java.util.List;

/**
 * @ClassName ListUtil
 * @Description 集合工具
 * @Author noah
 * @Date 2021/7/13 11:33
 * @Version 1.0
 **/
public class ListUtil {

    public static boolean isEmpty(Collection c){
        if (c == null || c.isEmpty()) {
            return true;
        }
        return false;
    }


    public static boolean isNotEmpty(Collection c){
        return !isEmpty(c);
    }
}
