package com.ibn.annotation.config;

import com.ibn.entity.UserBaseDO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


/**
 * @version 1.0
 * @description:
 * @projectName：spring-framework-learn
 * @see: com.ibn.annotation.config
 * @author： RenBin
 * @createTime：2020/6/12 18:12
 */
@Configuration
@PropertySource({"classpath:application.properties"})
public class MyConfiguration {
    @Value("${user.username}")
    private String username;

    @Bean
    public UserBaseDO initUserBaseDO(UserBaseDO userBaseDO) {
        userBaseDO.setUsername(username);
        return userBaseDO;
    }
}
