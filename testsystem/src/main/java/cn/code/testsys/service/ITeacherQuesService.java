package cn.code.testsys.service;

import cn.code.testsys.domain.Answer;
import cn.code.testsys.domain.Question;

import java.util.List;


public interface ITeacherQuesService {

    List<Question> seleQuesByPId(Long pId);

    void insert(Question question, Answer answer);

    void delete(Long id);

    void update(Question question,Answer answer);
}
