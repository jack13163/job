package job.jack.proxy.dynamicproxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * 基于cglib的动态代理
 */
public class UserProxy implements MethodInterceptor {

    public void before(){
        System.out.println(new Date());
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o, objects);// 注意，这里调用invokeSuper，而不是invoke，否则会发生死循环
        return result;
    }
}
