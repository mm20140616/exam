package com.hand.controller;

import com.hand.pojo.CustomerDTO;
import com.hand.service.LoginService;
import com.hand.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName Exam-19499-20180813-1
 * @ClassName CheckLogin
 * @Description TODO
 * @Author 赵晓宇
 * @Date 2018/8/13 10:08
 * @Version 1.0
 **/
public class CheckLogin extends HttpServlet {
    LoginService service = new LoginServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("customer_id");
        int customerId = Integer.parseInt(id);
        String firstName = req.getParameter("first_name");
        CustomerDTO cust = service.checkLoginByName(customerId);
        String fstName = cust.getFirstName();
        if (firstName.equals(fstName)){
            req.getSession().setAttribute("loginUser",firstName);
            resp.sendRedirect("main.jsp");
        } else {
          resp.sendRedirect("error.jsp");
        }

    }
}
