package cn.code.testsys.web.controller.teacher;

import cn.code.testsys.domain.Answer;
import cn.code.testsys.domain.Course;
import cn.code.testsys.domain.Question;
import cn.code.testsys.mapper.AdminMapper;
import cn.code.testsys.qo.DoubResult;
import cn.code.testsys.qo.Result;
import cn.code.testsys.service.ITeacherQuesService;
import io.swagger.annotations.Api;
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

    public Result<Question>  quesList(){
        List<Question> questions =adminMapper.selectQues();
        return new  Result().setCode(200).setData(questions).setMessage("查询题库题目成功");
    }


    @GetMapping("/ques/input")
    @ApiOperation(value="增加/修改**一道**题目到题库",notes = "如果增加则只返回所有课程，修改则返回原题目信息+课程信息")
    //复用方法，传入数组，实际这里应该只有一个值
    public DoubResult quesInput(@RequestParam("qIds")Long[] qIds){
        DoubResult result=new DoubResult();

        if(qIds!=null){//修改
            List<Question> que =adminMapper.selectByQueId(qIds);
            result.setDataSec(que);
        }
        //增加
        List<Course> courses = adminMapper.selectCour();
        result.setData(courses).setCode(200).setMessage("获取课程信息成功");

        return result;
    }

    @PostMapping("/ques/save")
    @ApiOperation(value="保存题目操作,前端应该在question中把courseId封好")
    public Result<Question> save(@RequestBody Question question) {
        Answer answer=question.getAnswer();

        if(question.getId()==null){//新增
            if(question.getProblem()==null){
                return new Result<Question>().setCode(202).setMessage("请先添加题目信息");
            }
            iTeacherQuesService.insert(question,answer);
        }
        else{//修改
            iTeacherQuesService.update(question,answer);
        }
        return quesList();
    }

    @DeleteMapping("/ques/delete")
    @ApiOperation(value="删除操作")
    public String courDel(@RequestParam("qId")Long qId ){
        iTeacherQuesService.delete(qId);
        return "删除成功";
    }

}

