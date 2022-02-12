package cn.code.testsys.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter

public class stuPaper {
    private stuTest stuTest;
    private int queID;
    private List<String> myanswer;
    private List<Integer> grade;
}
