package cn.code.testsys.mapper;

import cn.code.testsys.domain.Question;
import cn.code.testsys.domain.TestPaper;
import cn.code.testsys.domain.outDTO.OutPaper;

import java.util.List;

public interface TeacherPaperMapper {

    List<OutPaper> paperList(List<Long> paperIDs);

    void paperInput(List<Question> questions);

    TestPaper selePaperById(Long pId);
}
