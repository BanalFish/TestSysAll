package cn.code.testsys.mapper;

import cn.code.testsys.domain.Course;
import cn.code.testsys.qo.CourseQueryObject;

import java.util.List;

public interface TeacherCourseMapper {

    /**
     * 查询教师的课程信息
     * @return
     */
    List<Course> selectCour();

    /**
     * 查询课程分页
     */
    List<Course> selectCoursePage(CourseQueryObject queryObject);

    /**
     * 查询数据总条数
     */
    int selectCount();

    /**
     * 根据id删除部门信息
     */
    void delete(Long id);

    /**
     * 保存部门信息
     */
    void insert(Course course);

}
