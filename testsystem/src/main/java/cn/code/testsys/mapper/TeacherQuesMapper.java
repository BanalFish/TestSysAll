package cn.code.testsys.mapper;

import cn.code.testsys.domain.Answer;
import cn.code.testsys.domain.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherQuesMapper {

    //根据试卷Id返回包含的题目
    List<Question> seleQuesByPId(Long pId);

    /**
     * 新增题目信息
     * @param question
     */
    void insert(Question question);

    /**
     * 增加题目与答案关系
     */
    void insQueAndAns(@Param("queID") Long queID, @Param("answer") Answer answer);

    void delete(Long queID);

    void delQueAndAns(Long queID);

}
