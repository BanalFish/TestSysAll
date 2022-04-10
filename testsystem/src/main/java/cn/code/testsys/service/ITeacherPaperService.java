package cn.code.testsys.service;

import cn.code.testsys.domain.TestPaper;
import cn.code.testsys.domain.outDTO.OutPaper;

import java.util.List;

public interface ITeacherPaperService {

    List<OutPaper> paperList(List<Long> paperIDs);

    TestPaper selePaperById(Long pId);
}
