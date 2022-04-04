package cn.code.testsys.service;

import cn.code.testsys.domain.Test;

import java.util.List;

public interface ITeacherTestService {

    List<Test> testListById(Long teachID);

    List<Long> getPaperIds(Long teachID);
}
