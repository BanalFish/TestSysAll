package cn.code.testsys.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Answer {
    private Long id;
    private Question question;
    private String answer;

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", question=" + question +
                ", answer='" + answer + '\'' +
                '}';
    }
}
