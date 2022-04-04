package cn.code.testsys.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Question {
    @JsonIgnore
    private Long id;
    private String problem;
    private int score;
    private int type;
    private Course course;
    private int degree;//难易程度
    private Answer answer;

}
