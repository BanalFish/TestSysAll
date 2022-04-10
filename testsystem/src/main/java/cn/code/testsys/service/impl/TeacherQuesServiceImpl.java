package cn.code.testsys.service.impl;

import cn.code.testsys.domain.Answer;
import cn.code.testsys.domain.Question;
import cn.code.testsys.mapper.TeacherQuesMapper;
import cn.code.testsys.service.ITeacherQuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TeacherQuesServiceImpl implements ITeacherQuesService {

    @Autowired
    private TeacherQuesMapper teacherQuesMapper;

    @Override
    public List<Question> seleQuesByPId(Long pId) {
        return teacherQuesMapper.seleQuesByPId(pId);
    }

    @Override
    public void insert(Question question, Answer answer) {
        teacherQuesMapper.insert(question);
        teacherQuesMapper.insQueAndAns(question.getId(), answer);
    }

    @Override
    public void delete(Long id) {
        teacherQuesMapper.delete(id);
        teacherQuesMapper.delQueAndAns(id);
    }

    @Override
    public void update(Question question,Answer answer) {
        teacherQuesMapper.delete(question.getId());
        teacherQuesMapper.insert(question);
        teacherQuesMapper.insQueAndAns(question.getId(), answer);
    }


}
