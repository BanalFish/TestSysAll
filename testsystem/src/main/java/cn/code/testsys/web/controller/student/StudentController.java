package cn.code.testsys.web.controller.student;

import cn.code.testsys.domain.Course;
import cn.code.testsys.domain.Test;
import cn.code.testsys.domain.TestPaper;
import cn.code.testsys.domain.outDTO.OutPaper;
import cn.code.testsys.qo.Result;
import cn.code.testsys.service.IStudentService;
import cn.code.testsys.service.ITeacherCourseService;
import cn.code.testsys.service.ITeacherTestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@Api(tags="学生管理")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping("/courList")
    @ApiOperation(value="根据学生id查询课程")
    public Result courList(@ApiParam("学生id") @RequestParam("sId") Long sId){
        List<Course> courses = studentService.courList(sId);
        return new Result<>().setCode(200).setData(courses).setMessage("查询课程成功");
    }

    @PostMapping("/addCour")
    @ApiOperation(value="学生加入课程")
    public Result addCour(@RequestParam("sId")Long sId,@RequestParam("cId")Long cId){
        studentService.addCour(sId,cId);
        return new Result<>().setCode(200).setMessage("加入课程成功");
    }

    @GetMapping("/testList")
    @ApiOperation(value="进入课程后显示对应课程的考试")
    public Result testList(@RequestParam("cId")Long cId){
        List<Test> tests = studentService.get1cTest(cId);
        return new Result().setCode(200).setData(tests).setMessage("显示考试成功");
    }

    @GetMapping("/stuPaper")
    @ApiOperation(value="返回考试对应的试卷内容",notes = "testList已经存储了paperId")
    public Result get1Paper(@ApiParam("试卷id")@RequestParam("pId")Long pId){
        OutPaper paper = studentService.get1paper(pId);
        if(paper!=null)
            return new Result().setCode(200).setData(paper).setMessage("返回试卷成功");
        else
            return new Result().setCode(202).setMessage("无可用试卷");
    }

    /**
     * 待做
     * @return
     */

    @GetMapping("/stuSave")
    @ApiOperation(value="学生答卷后交卷")
    public Result stuPaper(){
        return null;
    }

}
