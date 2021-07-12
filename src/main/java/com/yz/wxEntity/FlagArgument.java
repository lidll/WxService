package com.yz.wxEntity;

/**
 * @ClassName FlagArgument
 * @Description TODO
 * @Author noah
 * @Date 2019-08-27 16:36
 * @Version 1.0
 **/
public class FlagArgument {
    private static String flag ;

    public static void setFlag(String flag){
        FlagArgument.flag = flag;
    }

    public static String getFlag(){
        return FlagArgument.flag;
    }

    public static void reset(){
        FlagArgument.flag = null;
    }
}
