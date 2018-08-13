package com.hand.service.impl;

import com.hand.dao.FilmDeleteDAO;
import com.hand.dao.impl.FilmDeleteDAOImpl;
import com.hand.service.FilmDeleteService;

/**
 * @ProjectName Exam-19499-20180813-1
 * @ClassName FilmDeleteServiceImpl
 * @Description TODO
 * @Author 赵晓宇
 * @Date 2018/8/13 18:02
 * @Version 1.0
 **/
public class FilmDeleteServiceImpl implements FilmDeleteService {
    FilmDeleteDAO dao = new FilmDeleteDAOImpl();
    @Override
    public int deleteFilm(int filmId) {
        int flag = dao.deleteFilm(filmId);
        return flag;
    }
}
