package cn.code.testsys.mapper;

import cn.code.testsys.domain.Test;

import java.util.List;

public interface TeacherTestMapper {

    /**
     * 根据教师id展示所教课程的考试，如果有同一门课程也被另外的教师教，则另一个
     * 教师的考试也会展示
     * @param teachID
     * @return
     */
    List<Test> testListById(Long teachID);

    /**
     * 返回该教师所有试卷的ID
     * @param teachID
     * @return
     */
    List<Long> getPaperIds(Long teachID);
}
