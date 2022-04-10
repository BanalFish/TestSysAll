package cn.code.testsys.service;

import cn.code.testsys.domain.Course;
import cn.code.testsys.domain.Question;
import cn.code.testsys.domain.User;

import java.util.List;

public interface IAdminService {

    List<Course> selectCour();
    List<Question> selectQues();
    List<Question> selectByQueId(Long[] queIds);
    List<Course> searchByName(String name);
    List<User> getAllTeach();
    List<User> getAllStu();
}
