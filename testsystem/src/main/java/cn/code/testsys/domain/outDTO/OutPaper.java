package cn.code.testsys.domain.outDTO;

import lombok.Data;

import java.util.List;

@Data
public class OutPaper {

    private Long paperID;
    private int status;
    private List<outQuestion> outQuestions;
}
@Data
class outQuestion{
    private Long queID;
    private String problem;
    private int score;
    private int type;
    private String courName;
    private int degree;
    private String answer;
    private int isTrue;
}