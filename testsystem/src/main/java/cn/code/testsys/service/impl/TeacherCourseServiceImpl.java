package cn.code.testsys.service.impl;

import cn.code.testsys.domain.Course;
import cn.code.testsys.mapper.TeacherCourseMapper;
import cn.code.testsys.qo.CourseQueryObject;
import cn.code.testsys.qo.PageResult;
import cn.code.testsys.service.ITeacherCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherCourseServiceImpl implements ITeacherCourseService {

    @Autowired
    private TeacherCourseMapper teacherCourseMapper;

    @Override
    public List<Course> selectCour() {
        return teacherCourseMapper.selectCour();
    }

    @Override
    public PageResult<Course> selectCoursePage(CourseQueryObject queryObject) {
        PageResult<Course> pageResult = null;
        int totalCount = teacherCourseMapper.selectCount();
        if (totalCount == 0){
            //表里面 没有我们查询的数据
            pageResult = new PageResult<>(queryObject.getCurrentPage(),queryObject.getPageSize(),
                    0,new ArrayList<>());
        }else{
            List<Course> departmentList = teacherCourseMapper.selectCoursePage(queryObject);
            pageResult = new PageResult<>(queryObject.getCurrentPage(),queryObject.getPageSize(),
                    totalCount,departmentList);
        }
        return pageResult;
    }

    @Override
    public void delete(Long id) {
        teacherCourseMapper.delete(id);
    }

    @Override
    public void save(Course course) {
        teacherCourseMapper.insert(course);
    }
}
