package cn.code.testsys.mapper;

import cn.code.testsys.domain.Course;
import cn.code.testsys.domain.Test;
import cn.code.testsys.domain.TestPaper;
import cn.code.testsys.domain.outDTO.OutPaper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    List<Course> courList(Long sId);

    List<Test> testList(Long sId);

    List<Test> get1cTest(Long cId);

    OutPaper get1paper(Long pId);

    void addCour(@Param("sId")Long sId,@Param("cId")Long cId);

    void addCourPeople(Long cId);
}
