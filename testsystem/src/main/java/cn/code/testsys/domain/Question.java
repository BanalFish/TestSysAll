package cn.code.testsys.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Question {
    @ApiModelProperty
    @JsonIgnore
    private Long id;
    @ApiModelProperty
    private String problem;
    @ApiModelProperty
    private int score;
    @ApiModelProperty
    private int type;
    @ApiModelProperty
    private Course course;
    @ApiModelProperty
    private int degree;//难易程度
    private Answer answer;

}
