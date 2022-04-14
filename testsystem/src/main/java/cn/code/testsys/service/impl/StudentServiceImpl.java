package cn.code.testsys.service.impl;

import cn.code.testsys.domain.Course;
import cn.code.testsys.domain.Test;
import cn.code.testsys.domain.TestPaper;
import cn.code.testsys.domain.outDTO.OutPaper;
import cn.code.testsys.mapper.StudentMapper;
import cn.code.testsys.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Course> courList(Long sId) {
        return studentMapper.courList(sId);
    }

    @Override
    public List<Test> testList(Long sId) {
        return studentMapper.testList(sId);
    }

    @Override
    public List<Test> get1cTest(Long cId) {
        return studentMapper.get1cTest(cId);
    }

    @Override
    public OutPaper get1paper(Long pId) {
        return studentMapper.get1paper(pId);
    }

    @Override
    public void addCour(Long sId, Long cId) {
        studentMapper.addCour(sId,cId);
        studentMapper.addCourPeople(cId);
    }
}
