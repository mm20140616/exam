package com.hand.dao.impl;

import com.hand.dao.FilmDeleteDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @ProjectName Exam-19499-20180813-1
 * @ClassName FilmDeleteDAOImpl
 * @Description TODO
 * @Author 赵晓宇
 * @Date 2018/8/13 18:05
 * @Version 1.0
 **/
public class FilmDeleteDAOImpl implements FilmDeleteDAO {
    @Override
    public int deleteFilm(int filmId) {
        String sql = "delete from film where film_id=?";
        Connection conn = null;
        PreparedStatement ps = null;
        int flag = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila"
                    ,"root"
                    ,"admin");
            ps = conn.prepareStatement(sql);
            ps.setInt(1,filmId);
            int a = ps.executeUpdate("set FOREIGN_KEY_CHECKS = 0"); //清除外键
            flag = ps.executeUpdate();
            int a1 = ps.executeUpdate("set FOREIGN_KEY_CHECKS = 1");//把外键设置回来

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
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
        return flag;
    }
}
