package cn.code.testsys.domain;


import lombok.*;

@Data
public class TestPaper {
    private Long id;
    private String name;
    private int status;
    private String allAnswer;
}
