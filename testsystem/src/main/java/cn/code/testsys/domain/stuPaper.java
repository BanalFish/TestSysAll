package cn.code.testsys.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter

public class stuPaper {
    @ApiModelProperty(value = "学生试卷id")
    private Long id;
    private Long stutestID;
    private List<Long> queID;
    private List<String> myanswer;
    private List<Integer> grade;
}
