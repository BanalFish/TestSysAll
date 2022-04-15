package cn.code.testsys.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value="用户对象")
public class User implements Serializable {


    private Long id;
    private String number;
    private String name;
    private String password;
    private int dep;
    private int who;

}
