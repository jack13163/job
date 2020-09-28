package job.norepeat;

import job.validation.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/test")
    public JsonResult test() {
        return new JsonResult(95002, "hello");
    }

    @NoRepeatSubmit// 自定义注解，放置表单重复提交
    @RequestMapping("/test2")
    public JsonResult test2() {
        return new JsonResult(95002, "test");
    }
}
