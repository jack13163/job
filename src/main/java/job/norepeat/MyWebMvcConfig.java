package job.norepeat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 添加接口拦截器
 */
@Configuration
public class MyWebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(noRepeatSubmitAopInterceptor());
    }

    @Bean
    public NoRepeatSubmitAopInterceptor noRepeatSubmitAopInterceptor(){
        return new NoRepeatSubmitAopInterceptor();
    }
}
