package com.prince.mall.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Project mall <br\>
 * Package com.prince.mall.config <br\>
 * <p>
 * Description : mybatis配置类 <br\>
 *
 * @author StrangePrince <br\>
 * @since 2021/7/7 8:28
 */
@Configuration
public class MybatisConfiguration {

    /**
     * 分页拦截器
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDbType(DbType.MYSQL);
        return paginationInterceptor;
    }
}
