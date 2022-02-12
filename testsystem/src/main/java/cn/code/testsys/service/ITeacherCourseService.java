package cn.code.testsys.service;

import cn.code.testsys.domain.Course;
import cn.code.testsys.qo.CourseQueryObject;
import cn.code.testsys.qo.PageResult;

import java.util.List;

public interface ITeacherCourseService {

    List<Course> selectCour();

    PageResult<Course> selectCoursePage(CourseQueryObject queryObject);

    void delete(Long id);

    //本系统功能不支持对已有课程进行编辑信息，这里的save只能新增课程
    void save(Course course);
}
