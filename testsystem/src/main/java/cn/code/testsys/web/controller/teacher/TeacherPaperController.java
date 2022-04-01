package cn.code.testsys.web.controller.teacher;

import cn.code.testsys.domain.TestPaper;
import cn.code.testsys.qo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//试卷管理
@RestController
@RequestMapping("/teacher")
@Api(tags="教师试卷管理")
public class TeacherPaperController {

//    @GetMapping("/paper/list")
//    @ApiOperation(value="展示试卷")
//    public Result<TestPaper> paperList(){
//
//    }

}
