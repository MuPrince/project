package com.prince.util;


/**
 * @description: 数据验证工具类
 *
 * @author Prince
 * @time 2020/9/21 14:50
 */
public class ValidateUtil {

    /**
     * @description: 验证一个字符串是否可以转换成浮点型
     * @param value
     * @return boolean
     * @author Prince
     * @date 2020/9/21 14:53
     */
    public static boolean isFloat(String value) {
        if(value == null || "".equals(value)){
            return false;
        }
        try{
            Float.valueOf(value);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
