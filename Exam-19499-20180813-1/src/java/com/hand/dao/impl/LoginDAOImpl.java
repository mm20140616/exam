package com.hand.dao.impl;

import com.hand.dao.LoginDAO;
import com.hand.pojo.CustomerDTO;
import java.sql.*;

/**
 * @ProjectName Exam-19499-20180813-1
 * @ClassName LoginDAOImpl
 * @Description TODO
 * @Author 赵晓宇
 * @Date 2018/8/13 10:55
 * @Version 1.0
 **/
public class LoginDAOImpl implements LoginDAO {
    @Override
    public CustomerDTO checkLoginByName(int customerId){

        String sql = "select * from customer where customer_id=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila"
                    ,"root"
                    ,"admin");
            ps = conn.prepareStatement(sql);
            ps.setInt(1,customerId);
            rs = ps.executeQuery();
            while (rs.next()) {
                int cid = rs.getInt("customer_id");
                String firstName = rs.getString("first_name");
                CustomerDTO customerDTO = new CustomerDTO(cid,firstName);
                return customerDTO;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try{
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }

}

