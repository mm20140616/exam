package com.hand.service.impl;

import com.hand.dao.LoginDAO;
import com.hand.dao.impl.LoginDAOImpl;
import com.hand.pojo.CustomerDTO;
import com.hand.service.LoginService;

/**
 * @ProjectName Exam-19499-20180813-1
 * @ClassName LoginServiceImpl
 * @Description TODO
 * @Author 赵晓宇
 * @Date 2018/8/13 10:50
 * @Version 1.0
 **/
public class LoginServiceImpl implements LoginService {

    LoginDAO ld = new LoginDAOImpl();
    @Override
    public CustomerDTO checkLoginByName(int customerId) {
        CustomerDTO cd = ld.checkLoginByName(customerId);

        return cd;
    }
}
