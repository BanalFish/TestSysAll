package cn.code.testsys.service.impl;

import cn.code.testsys.domain.TestPaper;
import cn.code.testsys.mapper.TeacherPaperMapper;
import cn.code.testsys.mapper.TeacherTestMapper;
import cn.code.testsys.service.ITeacherPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherPaperServiceImpl implements ITeacherPaperService {

    @Autowired
    private TeacherPaperMapper teacherPaperMapper;

    @Override
    public List<TestPaper> paperList(List<Long> paperIDs) {
        return teacherPaperMapper.paperList(paperIDs);
    }
}