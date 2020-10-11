package job.jack.proxy.staticproxy;

public class UserServiceImpl implements UserService {

    @Override
    public void sayHello() {
        System.out.println("hello jack");
    }

    @Override
    public void sayGoodbye() {
        System.out.println("goodbye jack");
    }
}
