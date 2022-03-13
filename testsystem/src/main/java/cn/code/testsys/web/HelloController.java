package cn.code.testsys.web;

import cn.code.testsys.domain.Course;
import cn.code.testsys.domain.User;
import cn.code.testsys.qo.Result;
import cn.code.testsys.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@Controller
@RequestMapping(value="/TestExcelFast")
@Api(tags = {"tag1"},description = "测试")
public class HelloController {

    @Autowired
    private IAdminService adminService;
    static Map<Long, User> users= Collections.synchronizedMap(new HashMap<Long, User>());

    @ApiOperation(value="获取用户列表",notes="")
    @RequestMapping(value = {""},method = RequestMethod.GET)
    public List<User> get(){
        List<User> r=new ArrayList<User>();
        return r;
    }

    @ApiOperation(value="创建用户",notes="根据user对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user",required = true,dataType = "User")
    @RequestMapping(value="", method=RequestMethod.POST)
    public String postUser(User user){
        users.put(user.getId(), user);
        return "success";
    }


    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id",value = "用户ID",required = true,dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getuser(@PathVariable Long id) {
        return users.get(id);
    }



    @ApiOperation(value = "测试专用",notes="备注说明")
    @RequestMapping(value="/testMCSwagger",method= RequestMethod.GET)
    @ResponseBody
    public String test(){
        String str = "123";
        System.out.println(1);
        return str;
    }


    @ApiOperation(value = "返回全部课程",notes="管理员专用")
    @RequestMapping(value="/admin/courList",method= RequestMethod.GET)
    @ResponseBody
    public Result getAllCourse(){

        List<Course> courses = adminService.selectCour();

        return new Result().setCode(200).setData(courses).setMessage("查询成功");
    }

}