package cn.code.testsys.web.controller.teacher;

import cn.code.testsys.domain.Answer;
import cn.code.testsys.domain.Course;
import cn.code.testsys.domain.Question;
import cn.code.testsys.mapper.AdminMapper;
import cn.code.testsys.qo.DoubResult;
import cn.code.testsys.qo.Result;
import cn.code.testsys.service.ITeacherQuesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//题库管理
@RestController
@RequestMapping("/teacher")
@Api(tags="教师题库管理")
public class TeacherQuesController {

    @Autowired
    private ITeacherQuesService iTeacherQuesService;
    @Autowired
    private AdminMapper adminMapper;


    @GetMapping("/ques/list")
    @ApiOperation(value="展示所有题目（管理员功能）")
    public Result<Question>  quesList(){
        List<Question> questions =adminMapper.selectQues();
        return new  Result().setCode(200).setData(questions).setMessage("查询题库题目成功");
    }


    @GetMapping("/ques/input")
    @ApiOperation(value="增加/修改题目到题库",notes = "如果增加则只返回所有课程，修改则返回原题目信息")
    @ApiImplicitParam(name = "qId",value="题目id",required = false,dataType = "Long",paramType ="path")
    public DoubResult quesInput(@RequestParam("qId")Long qId){
        DoubResult result=new DoubResult();

        if(qId!=null){//修改
            Question que = adminMapper.selectByQueId(qId);
            result.setDataSec(que);
        }
        //增加
        List<Course> courses = adminMapper.selectCour();
        result.setData(courses).setCode(200).setMessage("获取信息成功");

        return result;
    }

    @PostMapping("/ques/save")
    @ApiOperation(value="保存操作,前端应该在question中把courseId封好")
    public Result<Question> save(@RequestBody Param param) {

        Question question = param.getQuestion();
        Answer answer= param.getAnswer();

        if(question.getId()==null){
            iTeacherQuesService.insert(question,answer);
        }
        else{
            iTeacherQuesService.update(question,answer);
        }
        return quesList();
    }

    @DeleteMapping("/ques/delete")
    @ApiOperation(value="删除操作")
    @ApiImplicitParam(name = "qId",value="题目id",required = true,dataType = "Long",paramType ="path")
    public String courDel(@RequestParam("qId")Long qId ){
        iTeacherQuesService.delete(qId);
        return "删除成功";
    }

}

class Param{
    private Question question;
    private Answer answer;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
