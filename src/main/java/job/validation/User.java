package job.validation;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class User {
    @NotNull(message = "用户id不能为空")
    private Integer id;
    @NotNull(message = "用户名不能为空")
    private String name;
    @IsPhone
    private String phone;
}
