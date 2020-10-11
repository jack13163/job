package job.jack.proxy.dynamicproxy.jdk;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        UserService proxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),
                new UserProxy(userService));
        proxy.sayHello();
        proxy.sayGoodbye();
    }
}
