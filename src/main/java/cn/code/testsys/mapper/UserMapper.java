package cn.code.testsys.mapper;

import cn.code.testsys.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    //根据用户名和密码返回登录结果
    User getNameAndPass(@Param("name") String name, @Param("password") String password);

    //根据Id返回用户的所有信息
    User selectUser(Long userid);
}
