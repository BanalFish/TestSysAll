package cn.code.testsys.mapper;

import cn.code.testsys.domain.Question;
import cn.code.testsys.domain.TestPaper;
import cn.code.testsys.domain.outDTO.OutPaper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherPaperMapper {

    List<OutPaper> paperList(List<Long> paperIDs);

    void insertPaper(TestPaper paper);

    //添加题目到试卷
    void inputQues(@Param("questions") List<Long> questionIds, @Param("pId") Long pId);
    //删除
    void delPaperQues(Long pId);

    TestPaper selePaperById(Long pId);

    //获取最后一条（最新）插入的试卷
    TestPaper getLast();
}
