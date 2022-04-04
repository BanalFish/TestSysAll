package cn.code.testsys.service;

import cn.code.testsys.domain.TestPaper;

import java.util.List;

public interface ITeacherPaperService {

    List<TestPaper> paperList(List<Long> paperIDs);
}
