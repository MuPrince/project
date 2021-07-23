package com.prince.util;


/**
 * @description: 手机号码生成工具
 *
 * @author Prince
 * @time 2020/8/25 9:42
 */
public class TelephoneNumberUtil {
    private static String[] telFirst="181,185,136,137,138,179,150,151,152,157,158,159,130,131,132,155,156,199,153,189,166".split(",");
    public static String getTel() {
        int index=getNum(0,telFirst.length-1);
        String first=telFirst[index];
        String second=String.valueOf(getNum(1,888)+10000).substring(1);
        String third=String.valueOf(getNum(1,9100)+10000).substring(1);
        return first+second+third;
    }
    private static int getNum(int start,int end) {
        return (int)(Math.random()*(end-start+1)+start);
    }

}
