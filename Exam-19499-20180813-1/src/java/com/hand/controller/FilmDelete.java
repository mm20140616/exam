package com.hand.controller;

import com.hand.service.FilmDeleteService;
import com.hand.service.impl.FilmDeleteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ProjectName Exam-19499-20180813-1
 * @ClassName FilmDelete
 * @Description TODO
 * @Author 赵晓宇
 * @Date 2018/8/13 17:32
 * @Version 1.0
 **/
public class FilmDelete extends HttpServlet {
    FilmDeleteService service = new FilmDeleteServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Cache-Control", "no-cache");

        String id = req.getParameter("id");
        int filmId = Integer.parseInt(id);
        int flag = service.deleteFilm(filmId);
        PrintWriter out = resp.getWriter();
        out.print(flag);
        out.flush();
        out.close();

    }
}
