package com.prince.mall;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Project mall <br\>
 * Package com.prince.mall <br\>
 * <p>
 * Description :  <br\>
 *
 * @author StrangePrince <br\>
 * @since 2021/7/7 5:12
 */
@SpringBootApplication
@MapperScan(basePackages = {"com/prince/mall/goods/mapper"})
public class MallGoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallGoodsApplication.class, args);
    }
}
