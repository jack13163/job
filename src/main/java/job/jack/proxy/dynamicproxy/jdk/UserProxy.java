package job.jack.proxy.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 基于jdk的动态代理
 */
public class UserProxy implements InvocationHandler {

    private UserService userService;

    public UserProxy(UserService userService) {
        this.userService = userService;
    }

    public void before(){
        System.out.println(new Date());
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(userService, args);
        return result;
    }
}
