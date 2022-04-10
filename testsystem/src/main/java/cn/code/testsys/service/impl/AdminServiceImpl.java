package cn.code.testsys.service.impl;

import cn.code.testsys.domain.Course;
import cn.code.testsys.domain.Question;
import cn.code.testsys.domain.User;
import cn.code.testsys.mapper.AdminMapper;
import cn.code.testsys.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Course> selectCour() {
        return adminMapper.selectCour();
    }

    @Override
    public List<Question> selectQues() {
        return adminMapper.selectQues();
    }

    @Override
    public List<Question> selectByQueId(Long[] queIds) {
        return adminMapper.selectByQueId(queIds);
    }

    @Override
    public List<Course> searchByName(String name) {
        return adminMapper.searchByName(name);
    }

    @Override
    public List<User> getAllTeach() {
        return adminMapper.getAllTeach();
    }

    @Override
    public List<User> getAllStu() {
        return adminMapper.getAllStu();
    }
}
