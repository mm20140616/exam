package com.hand.controller;

import com.hand.service.FilmEditService;
import com.hand.service.impl.FilmEditServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ProjectName Exam-19499-20180813-1
 * @ClassName FilmEdit
 * @Description TODO
 * @Author 赵晓宇
 * @Date 2018/8/13 19:35
 * @Version 1.0
 **/
public class FilmEdit extends HttpServlet {
    FilmEditService service = new FilmEditServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer filmId = Integer.parseInt(req.getParameter("filmId"));
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String languageId = req.getParameter("languageId");
        int flag = service.editFilm(filmId,title,description,languageId);
        PrintWriter out = resp.getWriter();
        out.print(flag);
        out.flush();
        out.close();
    }
}
