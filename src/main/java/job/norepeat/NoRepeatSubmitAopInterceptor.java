package job.norepeat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;

/**
 * 拦截@NoRepeatSubmit注解
 */
public class NoRepeatSubmitAopInterceptor implements HandlerInterceptor {

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        if(!(handler instanceof HandlerMethod)){
            return true;
        }

        // 判断方法是否标注@NoRepeatSubmit注解
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        NoRepeatSubmit methodAnnotation = handlerMethod.getMethodAnnotation(NoRepeatSubmit.class);
        if(methodAnnotation == null){
            return true;
        }

        // 判断是否是重复提交的表单
        ValueOperations valueOperations = redisTemplate.opsForValue();
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        String key = requestAttributes.getSessionId() + ((ServletRequestAttributes) requestAttributes).getRequest().getServletPath();
        System.out.println(key);
        if (valueOperations.get(key) == null) {
            valueOperations.set(key, key, Duration.ofSeconds(10));
            return true;
        } else {
            System.out.println("表单重复提交");
            return false;
        }
    }
}
