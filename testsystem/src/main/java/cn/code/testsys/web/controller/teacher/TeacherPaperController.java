package cn.code.testsys.web.controller.teacher;

import cn.code.testsys.domain.Question;
import cn.code.testsys.domain.TestPaper;
import cn.code.testsys.domain.outDTO.OutPaper;
import cn.code.testsys.qo.DoubResult;
import cn.code.testsys.qo.Result;
import cn.code.testsys.service.ITeacherPaperService;
import cn.code.testsys.service.ITeacherQuesService;
import cn.code.testsys.service.ITeacherTestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private ITeacherQuesService quesService;

    @GetMapping("/paper/list")
    @ApiOperation(value="展示所有试卷")
    public Result<TestPaper> paperList(@RequestParam("teachID") Long teachID){
        List<Long> paperIds = testService.getPaperIds(teachID);
        List<OutPaper> testPapers = paperService.paperList(paperIds);
        return new Result().setCode(200).setMessage("查询试卷成功").setData(testPapers);
    }

    @PostMapping("/paper/input")
    @ApiOperation(value="组卷或者修改试卷")
    public DoubResult paperInput(@RequestBody ParamPaper paper){
        Long pId=paper.getPaper().getId();
        DoubResult doub=new DoubResult();
        if(pId!=null){//修改试卷
            TestPaper testPaper = paperService.selePaperById(pId);
            List<Question> questions=quesService.seleQuesByPId(pId);
            doub.setData(testPaper);
            doub.setDataSec(questions);
            doub.setCode(200);
        }
        //新增试卷
        return doub;
    }

    @PostMapping("/paper/save")
    @ApiOperation(value="保存试卷问题")
    public Result paperSaveQues(@RequestParam ParamPaper paper){
        //如果传入的问题为空
        if(paper.getQuestions()==null)
            return new Result<>().setData(202).setMessage("请添加题目到试卷");
        //新增
        if(paper.getPaper().getId()==null){
            //添加试卷基本信息
        }
        return null;
    }

    @PostMapping("/paper/savePaper")
    @ApiOperation(value="保存试卷基本信息")
    public Result paperSavePaper(@RequestParam ParamPaper paper){
        return null;
    }
}

@ApiModel
@Data
class ParamPaper{
    List<Question> questions;
    TestPaper paper;
}