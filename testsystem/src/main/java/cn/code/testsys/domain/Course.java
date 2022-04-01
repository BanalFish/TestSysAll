package cn.code.testsys.domain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value="course对象")
public class Course {

    private Long id;
    private String name;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startDate;
    private int count;

}
