package com.yz.enums;

/**
 * @ClassName Week
 * @Description TODO
 * @Author noah
 * @Date 2020-04-17 19:23
 * @Version 1.0
 **/
public enum Week {
    SUN(1), MON(2), TUE(3), WED(4), THU(5), FRI(6), SAT(7);

    public final int value;

    private Week(int value){
        this.value = value;
    }
}
