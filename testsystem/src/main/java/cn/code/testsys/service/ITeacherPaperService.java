package cn.code.testsys.service;

import cn.code.testsys.domain.Question;
import cn.code.testsys.domain.TestPaper;
import cn.code.testsys.domain.outDTO.OutPaper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ITeacherPaperService {

    List<OutPaper> paperList(List<Long> paperIDs);

    void insertPaper(TestPaper paper);

    TestPaper selePaperById(Long pId);

    TestPaper getLast();

    void inputQues(List<Long> questionIds, Long pId);

    void delQues(Long pId);

    void updateQues(List<Long> questionIds, Long pId);
}
