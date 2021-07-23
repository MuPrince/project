package com.prince.mall.file.config;

import lombok.Data;
import org.javaswift.joss.client.factory.AccountConfig;
import org.javaswift.joss.client.factory.AccountFactory;
import org.javaswift.joss.client.factory.AuthenticationMethod;
import org.javaswift.joss.model.Account;
import org.javaswift.joss.model.Container;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Project mall <br\>
 * Package com.prince.mall.file <br\>
 * <p>
 * Description : 容器初始化配置类 <br\>
 *
 * @author StrangePrince <br\>
 * @since 2021/7/7 8:59
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "ceph")
public class ContainerConfiguration {

    private String username;

    private String password;

    private String authUrl;

    private String defaultContainerName;

    /**
     * 创建账号信息
     */
    @Bean
    public Account account() {
        AccountConfig accountConfig = new AccountConfig();
        accountConfig.setUsername(username);
        accountConfig.setPassword(password);
        accountConfig.setAuthUrl(authUrl);
        accountConfig.setAuthenticationMethod(AuthenticationMethod.BASIC);
        return new AccountFactory(accountConfig).createAccount();
    }

    /**
     * 创建容器对象
     */
    @Bean
    public Container container() {
        Container container = account().getContainer(defaultContainerName);
        if (!container.exists()) {
            return container.create();
        }
        return container;
    }
}
