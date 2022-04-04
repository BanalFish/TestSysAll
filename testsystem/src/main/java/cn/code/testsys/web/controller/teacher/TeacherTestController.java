package cn.code.testsys.web.controller.teacher;

import cn.code.testsys.domain.Question;
import cn.code.testsys.domain.Test;
import cn.code.testsys.qo.Result;
import cn.code.testsys.service.ITeacherTestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


//考试管理
@RestController
@RequestMapping("/teacher")
@Api(tags="教师考试管理")
public class TeacherTestController {

    @Autowired
    private ITeacherTestService testService;

    @GetMapping("/test/list")
    @ApiOperation(value="展示该教师所有考试")
    public Result<Test> quesList(@RequestParam("teachID") Long teachID){
        List<Test> tests = testService.testListById(teachID);
        return new Result().setCode(200).setMessage("查询考试成功").setData(tests);
    }


}
