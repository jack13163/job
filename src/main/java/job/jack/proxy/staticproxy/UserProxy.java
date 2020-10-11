package job.jack.proxy.staticproxy;

import java.util.Date;

public class UserProxy implements UserService {

    private UserService userService;

    public UserProxy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void sayHello() {
        before();
        userService.sayHello();
    }

    @Override
    public void sayGoodbye() {
        before();
        userService.sayGoodbye();
    }

    public void before(){
        System.out.println(new Date());
    }
}
