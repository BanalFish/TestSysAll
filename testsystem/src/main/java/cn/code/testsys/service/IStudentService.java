package cn.code.testsys.service;

import cn.code.testsys.domain.Course;
import cn.code.testsys.domain.Test;
import cn.code.testsys.domain.outDTO.OutPaper;

import java.util.List;

public interface IStudentService {
    List<Course> courList(Long sId);

    List<Test> testList(Long sId);

    List<Test> get1cTest(Long cId);

    OutPaper get1paper(Long pId);

    void addCour(Long sId,Long cId);
}
