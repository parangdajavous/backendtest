package co.kr.metacoding.backendtest.core.config;

import co.kr.metacoding.backendtest.core.filter.LogFilter;
import co.kr.metacoding.backendtest.core.filter.UrlFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<LogFilter> loggingFilter() {
        FilterRegistrationBean<LogFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new LogFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(2);
        return registrationBean;
    }


    @Bean
    public FilterRegistrationBean<UrlFilter> urlFilter() {
        FilterRegistrationBean<UrlFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new UrlFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(1);
        return registrationBean;
    }

}
