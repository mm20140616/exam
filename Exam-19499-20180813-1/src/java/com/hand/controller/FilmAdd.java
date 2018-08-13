package com.hand.controller;

import com.hand.pojo.FilmDTO;
import com.hand.service.FilmAddService;
import com.hand.service.impl.FilmAddServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName Exam-19499-20180813-1
 * @ClassName FilmAddService
 * @Description TODO
 * @Author 赵晓宇
 * @Date 2018/8/13 16:32
 * @Version 1.0
 **/
public class FilmAdd extends HttpServlet {
    FilmAddService service = new FilmAddServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer filmId = Integer.parseInt(req.getParameter("filmId"));
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String languageId = req.getParameter("languageId");
        service.saveFilm(filmId,title,description,languageId);

    }
}
