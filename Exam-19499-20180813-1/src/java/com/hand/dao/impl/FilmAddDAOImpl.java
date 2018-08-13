package com.hand.dao.impl;

import com.hand.dao.FilmAddDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @ProjectName Exam-19499-20180813-1
 * @ClassName FilmAddDAOImpl
 * @Description TODO
 * @Author 赵晓宇
 * @Date 2018/8/13 16:52
 * @Version 1.0
 **/
public class FilmAddDAOImpl implements FilmAddDAO {
    @Override
    public void saveFilm(Integer filmId,String title,String description,String languageId) {
        String sql = "insert into film(film_id,title,description,language_id) values(?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila"
                    ,"root"
                    ,"admin");
            ps = conn.prepareStatement(sql);
            ps.setInt(1,filmId);
            ps.setString(2,title);
            ps.setString(3,description);
            ps.setString(4,languageId);
            ps.executeUpdate();
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
    }
}
