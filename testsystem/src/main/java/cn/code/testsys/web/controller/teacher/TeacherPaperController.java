package cn.code.testsys.web.controller.teacher;

import cn.code.testsys.domain.TestPaper;
import cn.code.testsys.mapper.TeacherTestMapper;
import cn.code.testsys.qo.Result;
import cn.code.testsys.service.ITeacherPaperService;
import cn.code.testsys.service.ITeacherTestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.bytebuddy.asm.Advice;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//试卷管理
@RestController
@RequestMapping("/teacher")
@Api(tags="教师试卷管理")
public class TeacherPaperController {

    @Autowired
    private ITeacherTestService testService;
    @Autowired
    private ITeacherPaperService paperService;

    @GetMapping("/paper/list")
    @ApiOperation(value="展示试卷")
    public Result<TestPaper> paperList(@RequestParam("teachID") Long teachID){
        List<Long> paperIds = testService.getPaperIds(teachID);
        List<TestPaper> testPapers = paperService.paperList(paperIds);
        return new Result().setCode(200).setMessage("查询试卷成功").setData(testPapers);
    }

}
