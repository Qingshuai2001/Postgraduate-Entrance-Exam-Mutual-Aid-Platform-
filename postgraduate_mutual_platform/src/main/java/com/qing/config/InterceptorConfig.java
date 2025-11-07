package com.qing.config;


import com.qing.interceptor.AuthorizationInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@Slf4j
public class InterceptorConfig extends WebMvcConfigurationSupport{

	@Bean
    public AuthorizationInterceptor getAuthorizationInterceptor() {
        return new AuthorizationInterceptor();
    }

	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getAuthorizationInterceptor()).addPathPatterns("/**").excludePathPatterns("/static/upload/**","/index/**");
        registry.addInterceptor(getAuthorizationInterceptor()).addPathPatterns("/**").excludePathPatterns("/front/index.html","/front/css/**","/front/elementui/**","/front/img/**","/front/js/**","/front/layui/**","/front/modules/**","/front/pages/**");
        super.addInterceptors(registry);
	}


	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("开始静态资源映射");
        registry.addResourceHandler("/backend/**").addResourceLocations("classpath:/backend/");
        registry.addResourceHandler("/front/**").addResourceLocations("classpath:/front/");
        String path="E:\\论文项目\\Help_Postgraduate\\src\\main\\resources\\static\\upload\\";  /*虚拟路径*/
        registry.addResourceHandler("/static/upload/**").addResourceLocations("file:"+path);
		super.addResourceHandlers(registry);
    }
}
