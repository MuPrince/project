package com.prince.mall.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Project mall <br\>
 * Package com.prince.mall.file <br\>
 * <p>
 * Description :  <br\>
 *
 * @author StrangePrince <br\>
 * @since 2021/7/7 9:29
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MallFileApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallFileApplication.class, args);
    }
}
