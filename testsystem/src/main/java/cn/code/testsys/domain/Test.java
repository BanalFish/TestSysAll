package cn.code.testsys.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Test {
    private Long id;
    private String name;
    private TestPaper testPaper;
    private Date startTime;
    private Date endTime;
    private int status;
    private Course course;
}
