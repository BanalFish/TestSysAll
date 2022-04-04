package cn.code.testsys.service.impl;

import cn.code.testsys.domain.Test;
import cn.code.testsys.mapper.TeacherTestMapper;
import cn.code.testsys.service.ITeacherTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherTestServiceImpl implements ITeacherTestService {

    @Autowired
    private TeacherTestMapper teacherTestMapper;

    @Override
    public List<Test> testListById(Long teachID) {
        return teacherTestMapper.testListById(teachID);
    }

    @Override
    public List<Long> getPaperIds(Long teachID) {
        return teacherTestMapper.getPaperIds(teachID);
    }
}
