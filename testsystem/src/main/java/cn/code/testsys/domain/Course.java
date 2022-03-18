package cn.code.testsys.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ApiModelProperty(value="课程id",required = true)
    private Long id;
    @ApiModelProperty(value="课程名称",required = true)
    private String name;
    @ApiModelProperty(value="创立日期",required = true)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startDate;
    @ApiModelProperty(value="课程参与人数",required = true)
    private int count;

}
