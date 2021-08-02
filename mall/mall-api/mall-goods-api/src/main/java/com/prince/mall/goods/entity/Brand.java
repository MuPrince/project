package com.prince.mall.goods.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.function.Function;

/**
 * Project mall <br\>
 * Package com.prince.mall.goods <br\>
 * <p>
 * Description : 品牌Bean <br\>
 *
 * @author StrangePrince <br\>
 * @since 2021/7/7 2:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "brand")
public class Brand {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 图片
     */
    private String image;
    /**
     * 首字母
     */
    private String initial;
    /**
     * 排序
     */
    private Integer sort;

}
