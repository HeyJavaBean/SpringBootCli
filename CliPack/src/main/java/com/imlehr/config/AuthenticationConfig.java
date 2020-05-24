package com.imlehr.config;

import com.imlehr.security.CredentialsService;
import com.imlehr.security.CredentialsServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Lehr
 * @create: 2020-05-24
 */
@Configuration
public class AuthenticationConfig {

    @ConditionalOnMissingBean(CredentialsService.class)
    @Bean("authenticationManager")
    public CredentialsService defalutManager()
    {
        return new CredentialsServiceImpl();
    }


}
