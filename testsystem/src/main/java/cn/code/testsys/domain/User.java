package cn.code.testsys.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value="用户对象")
public class User {

    @ApiModelProperty
    private Long id;
    @ApiModelProperty
    private String number;
    @ApiModelProperty
    private String name;
    @ApiModelProperty
    private String password;
    @ApiModelProperty
    private int dep;
    @ApiModelProperty
    private int who;

}
