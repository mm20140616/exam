package com.hand.service.impl;

import com.hand.controller.ListShow;
import com.hand.dao.ListShowDAO;
import com.hand.dao.impl.ListShowDAOImpl;
import com.hand.pojo.FilmDTO;
import com.hand.service.ListShowService;

import java.util.List;

/**
 * @ProjectName Exam-19499-20180813-1
 * @ClassName ListShowServiceImpl
 * @Description TODO
 * @Author 赵晓宇
 * @Date 2018/8/13 14:23
 * @Version 1.0
 **/
public class ListShowServiceImpl implements ListShowService {
    ListShowDAO dao = new ListShowDAOImpl();
    @Override
    public List<FilmDTO> findFilmByPage(int page, int rows) {
        int begin = (page-1)*rows;
        int count = rows;
        List<FilmDTO> list = dao.findFilmByPage(begin,count);
        return list;
    }

    @Override
    public Integer getTotal() {
        int total = dao.getTotal();
        return total;
    }
}
