package com.easydev.config;

import com.easydev.component.LoginHandlerInterceptor;
import com.easydev.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

//使用WebMvcConfigurer 可以扩展SpringMVC的功能
//@EnableWebMvc
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送 easydev , 请求来到 success 页面
        registry.addViewController("/easydev").setViewName("success");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    //注册拦截器
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //静态资源 Springboot已经做好了静态资源映射
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/" , "/index" , "/index.html" , "/user/login");
//    }

    /**
     * 自己配置的国际化解析器
     * @return
     */
    @Bean
    public LocaleResolver localeResolver () {
        return new MyLocaleResolver();
    }


}
