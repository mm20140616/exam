package com.hand.dao.impl;

import com.hand.dao.ListShowDAO;
import com.hand.pojo.CustomerDTO;
import com.hand.pojo.FilmDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName Exam-19499-20180813-1
 * @ClassName ListShowDAOImpl
 * @Description TODO
 * @Author 赵晓宇
 * @Date 2018/8/13 14:27
 * @Version 1.0
 **/
public class ListShowDAOImpl implements ListShowDAO {
    @Override
    public List<FilmDTO> findFilmByPage(int begin, int count) {
        String sql = "select f.film_id,f.title,f.description,l.name " +
                "from film f,language l where f.language_id=l.language_id order by film_id limit ?,?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila"
                    ,"root"
                    ,"admin");
            ps = conn.prepareStatement(sql);
            ps.setInt(1,begin);
            ps.setInt(2,count);
            List<FilmDTO> list = new ArrayList<FilmDTO>();
            rs=ps.executeQuery();
            while(rs.next()){
                int filmId = rs.getInt("film_id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                String languageName = rs.getString("name");
                FilmDTO fd = new FilmDTO(filmId,title,description,languageName);

                list.add(fd);
            }
            return list;

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

    @Override
    public Integer getTotal() {
        String sql = "select count(1) from film";
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        int total = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila"
                    ,"root"
                    ,"admin");
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                total = rs.getInt(1);
            }
            return total;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try{
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
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
