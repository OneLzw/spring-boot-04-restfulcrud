package com.easydev.config;

import com.easydev.filter.MyFilter;
import com.easydev.listener.MyListener;
import com.easydev.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyServletConfig {

    //注册servlet容器
    @Bean
    public ServletRegistrationBean myServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new MyServlet() , "/myservlet");
        return servletRegistrationBean;
    }

    //注册Filter 过滤器
    @Bean
    public FilterRegistrationBean myFilter () {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello" , "/myservlet"));
        return filterRegistrationBean;
    }

    //注册 listener 监听器
    @Bean
    public ServletListenerRegistrationBean myListener () {
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean(new MyListener());
        return servletListenerRegistrationBean;
    }
}
