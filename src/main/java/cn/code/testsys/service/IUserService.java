package cn.code.testsys.service;

import cn.code.testsys.domain.User;
import org.apache.ibatis.annotations.Param;

public interface IUserService {
    User getNameAndPass(@Param("name") String name, @Param("password") String password);

    User selectUser(Long userid);
}
