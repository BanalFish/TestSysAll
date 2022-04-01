package cn.code.testsys.service;

import cn.code.testsys.domain.Answer;
import cn.code.testsys.domain.Question;


public interface ITeacherQuesService {

    void insert(Question question, Answer answer);

    void delete(Long id);

    void update(Question question,Answer answer);
}
