package com.hand.service.impl;

import com.hand.dao.FilmAddDAO;
import com.hand.dao.impl.FilmAddDAOImpl;
import com.hand.pojo.FilmDTO;
import com.hand.service.FilmAddService;

/**
 * @ProjectName Exam-19499-20180813-1
 * @ClassName FilmAddServiceImpl
 * @Description TODO
 * @Author 赵晓宇
 * @Date 2018/8/13 16:51
 * @Version 1.0
 **/
public class FilmAddServiceImpl implements FilmAddService {
    FilmAddDAO fad = new FilmAddDAOImpl();
    @Override
    public void saveFilm(Integer filmId,String title,String description,String languageId) {
        fad.saveFilm(filmId,title,description,languageId);
    }
}
