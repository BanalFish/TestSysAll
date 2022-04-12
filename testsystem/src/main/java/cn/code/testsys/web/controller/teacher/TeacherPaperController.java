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
        if(pId!=null){//修改试卷返回试卷及问题
            TestPaper testPaper = paperService.selePaperById(pId);
            List<Question> questions=quesService.seleQuesByPId(pId);
            doub.setData(testPaper);
            doub.setDataSec(questions);
            doub.setCode(204);
            doub.setMessage("返回已存试卷信息成功");
            return doub;
        }
        //新增试卷不返回任何数据
        else{
            return (DoubResult) doub.setCode(206).setMessage("新增试卷页面");
        }

    }

    @PostMapping("/paper/save")
    @ApiOperation(value="保存试卷问题")
    public Result paperSaveQues(@RequestParam ParamPaper paper){
        //如果传入的问题为空
        if(paper.getQuestionIds()==null)
            return new Result<>().setData(208).setMessage("请添加题目到试卷");
        //新增试卷
        if(paper.getPaper().getId()==null){
            //添加试卷基本信息
            paperService.insertPaper(paper.getPaper());
            TestPaper p=paperService.getLast();//获取最新的试卷
            paperService.inputQues(paper.getQuestionIds(),p.getId());

            return new Result().setCode(210).setMessage("新增试卷成功");
        }
        //修改试卷，只修改题号的组合，不能修改题目
        else{
            paperService.updateQues(paper.getQuestionIds(),paper.getPaper().getId());
            return new Result().setCode(212).setMessage("修改试卷成功");
        }

    }
}

@ApiModel
@Data
class ParamPaper{
    List<Long> questionIds;
    TestPaper paper;
}