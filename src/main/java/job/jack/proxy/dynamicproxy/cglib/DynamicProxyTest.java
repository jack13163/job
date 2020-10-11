package job.jack.proxy.dynamicproxy.cglib;

import net.sf.cglib.proxy.Enhancer;

public class DynamicProxyTest {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        UserProxy userProxy = new UserProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(userService.getClass());
        enhancer.setCallback(userProxy);
        UserServiceImpl proxy = (UserServiceImpl) enhancer.create();
        proxy.sayHello();
        proxy.sayGoodbye();
    }
}
