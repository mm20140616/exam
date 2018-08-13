package com.hand.dao.impl;

import com.hand.dao.FilmEditDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @ProjectName Exam-19499-20180813-1
 * @ClassName FilmEditDAOImpl
 * @Description TODO
 * @Author 赵晓宇
 * @Date 2018/8/13 21:27
 * @Version 1.0
 **/
public class FilmEditDAOImpl implements FilmEditDAO {
    @Override
    public int editFilm(Integer filmId, String title, String description, String languageId) {
        String sql = "update film set title=?,description=?,language_id=? where film_id=?";
        Connection conn = null;
        PreparedStatement ps = null;
        int flag = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila"
                    ,"root"
                    ,"admin");
            ps = conn.prepareStatement(sql);
            ps.setString(1,title);
            ps.setString(2,description);
            ps.setString(3,languageId);
            ps.setInt(4,filmId);

            flag = ps.executeUpdate();

        }catch (Exception e) {
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
