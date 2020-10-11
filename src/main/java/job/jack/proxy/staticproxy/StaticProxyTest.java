package job.jack.proxy.staticproxy;

public class StaticProxyTest {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        UserService proxy = new UserProxy(userService);
        proxy.sayHello();
        proxy.sayGoodbye();
    }
}
