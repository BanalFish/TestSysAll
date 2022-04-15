package cn.code.testsys.web.controller.student;

import cn.code.testsys.domain.Course;
import cn.code.testsys.domain.Test;
import cn.code.testsys.domain.outDTO.OutPaper;
import cn.code.testsys.domain.stuPaper;
import cn.code.testsys.domain.stuTest;
import cn.code.testsys.qo.Result;
import cn.code.testsys.service.IStudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/student")
@Api(tags = "学生管理")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping("/courList")
    @ApiOperation(value = "根据学生id查询课程")
    public Result courList(@ApiParam("学生id") @RequestParam("sId") Long sId) {
        List<Course> courses = studentService.courList(sId);
        return new Result<>().setCode(200).setData(courses).setMessage("查询课程成功");
    }

    @PostMapping("/addCour")
    @ApiOperation(value = "学生加入课程")
    public Result addCour(@RequestParam("sId") Long sId, @RequestParam("cId") Long cId) {
        studentService.addCour(sId, cId);
        return new Result<>().setCode(200).setMessage("加入课程成功");
    }

    @PostMapping("/testList")
    @ApiOperation(value = "进入课程后显示对应课程的考试")
    public Result testList(@RequestParam("cId") Long cId) {
        List<Test> tests = studentService.get1cTest(cId);
        if(tests!=null)
            return new Result().setCode(200).setData(tests).setMessage("显示考试成功");
        else
            return new Result().setCode(404).setMessage("该课程暂时没有考试");
    }

    @PostMapping("/stuPaper")
    @ApiOperation(value = "返回考试对应的试卷内容", notes = "testList已经存储了paperId")
    public Result get1Paper(@ApiParam("试卷id") @RequestParam("pId") Long pId) {
        OutPaper paper = studentService.get1paper(pId);
        if (paper != null)
            return new Result().setCode(200).setData(paper).setMessage("返回试卷成功");
        else
            return new Result().setCode(404).setMessage("无可用试卷");
    }

    /**
     * 进入考试
     */
    @PostMapping("/stuTest")
    @ApiOperation(value = "学生进入相应的考试", notes = "testList已经存储了testId")
    public Result addStuTest(@RequestBody stuTest stuTest) {
        try {
            studentService.addStuTest(stuTest);
        }catch (Exception e){
            return new Result().setCode(500).setMessage("不能再次进入考试");
        }
        return new Result().setCode(200).setMessage("进入考试成功");
    }


    /**
     * 交卷
     * 交卷后更新结束时间、状态
     */

    @PostMapping("/submit")
    @ApiOperation(value = "学生答卷后交卷",notes = "应该封装除了grade以外的数据")
    public Result stuPaper(@ApiParam("学生试卷")@RequestBody stuPaper stuPaper,
                           @ApiParam("交卷时间")@RequestParam Date date) {

        List<Long> queID = stuPaper.getQueID();
        List<String> myanswer = stuPaper.getMyanswer();
        List<Map> mapList = new ArrayList<>();

        for(int i=0;i<queID.size();i++){
            Map map=new HashMap<>();
            map.put("queID",queID.get(i));
            map.put("myanswer",myanswer.get(i));
            mapList.add(map);
        }
        studentService.submit(stuPaper.getStutestID(),mapList);

        //时间字符串转换为date
        studentService.updateFin(date);
        return new Result<>().setCode(200).setMessage("交卷成功");
    }

}
