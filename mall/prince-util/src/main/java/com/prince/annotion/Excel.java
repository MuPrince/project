package com.prince.annotion;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description: Excel配置注解自定义接口
 *
 * @author Prince
 * @time 2020/9/21 13:52
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ java.lang.annotation.ElementType.FIELD })
public @interface Excel {
    /**
     * Excel中的列名
     *
     * @return
     */
    String name();

    /**
     * 列名对应的A,B,C,D...,不指定按照默认顺序排序
     *
     * @return
     */
    String column() default "";

    /**
     * 提示信息
     *
     * @return
     */
    String prompt() default "";

    /**
     * 设置只能选择不能输入的列内容
     *
     * @return
     */
    String[] combo() default {};

    /**
     * 是否导出数据
     *
     * @return
     */
    boolean isExport() default true;

    /**
     * 是否为重要字段（整列标红,着重显示）
     *
     * @return
     */
    boolean isMark() default false;

    /**
     * 是否合计当前列
     *
     * @return
     */
    boolean isSum() default false;
}
