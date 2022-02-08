package cn.code.testsys.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class stuTest {
    private int id;
    private Test test;
    private User student;
    private int total;
}
