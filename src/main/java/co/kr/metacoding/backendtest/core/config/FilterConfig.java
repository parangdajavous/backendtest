package co.kr.metacoding.backendtest.core.config;

import co.kr.metacoding.backendtest.core.filter.LogFilter;
import co.kr.metacoding.backendtest.core.filter.UriFilter;
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
    public FilterRegistrationBean<UriFilter> uriFilter() {
        FilterRegistrationBean<UriFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new UriFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(1);
        return registrationBean;
    }

}
