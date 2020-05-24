package com.imlehr.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lehr
 */
@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean filterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        //注入过滤器
        registration.setFilter(new CorsFilter());
        //拦截规则
        registration.addUrlPatterns("/*");
        //过滤器名称
        registration.setName("CorsFilter");

        registration.setEnabled(true);
        //过滤器顺序
        registration.setOrder(1);
        return registration;
    }

}
