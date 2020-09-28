package job.validation;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 参数检验
 */
@RestController
public class ParemeterValidation {
    /**
     * 声明要检查的参数
     * @param user
     * @return
     */
    @RequestMapping("/user")
    public JsonResult testValidation(@Validated User user){
        JsonResult jsonResult = new JsonResult(10000, user.toString());
        return jsonResult;
    }
}
