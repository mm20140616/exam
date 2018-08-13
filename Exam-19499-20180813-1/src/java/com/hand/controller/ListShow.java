package com.hand.controller;

import com.google.gson.Gson;
import com.hand.pojo.FilmDTO;
import com.hand.service.ListShowService;
import com.hand.service.impl.ListShowServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName Exam-19499-20180813-1
 * @ClassName ListShow
 * @Description TODO
 * @Author 赵晓宇
 * @Date 2018/8/13 13:18
 * @Version 1.0
 **/
public class ListShow extends HttpServlet {
    ListShowService service = new ListShowServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Cache-Control", "no-cache");

        int page = Integer.parseInt(req.getParameter("page"));
        int rows = Integer.parseInt(req.getParameter("rows"));
        List<FilmDTO> list = service.findFilmByPage(page,rows);
        int total = service.getTotal();
        Map<String,Object> result = new HashMap<>();
        result.put("rows",list);
        result.put("total",total);
        Gson g = new Gson();
        String json = g.toJson(result);
        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();
        out.close();
    }
}
