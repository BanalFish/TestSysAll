package cn.code.testsys.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Answer {
    private Long id;
    private String answer;
    private Long isTrue;

}
