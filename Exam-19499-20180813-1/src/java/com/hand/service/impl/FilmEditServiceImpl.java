package com.hand.service.impl;

import com.hand.dao.FilmEditDAO;
import com.hand.dao.impl.FilmEditDAOImpl;
import com.hand.service.FilmEditService;

/**
 * @ProjectName Exam-19499-20180813-1
 * @ClassName FilmEditServiceImpl
 * @Description TODO
 * @Author 赵晓宇
 * @Date 2018/8/13 21:26
 * @Version 1.0
 **/
public class FilmEditServiceImpl implements FilmEditService {
    FilmEditDAO dao = new FilmEditDAOImpl();
    @Override
    public int editFilm(Integer filmId, String title, String description, String languageId) {
        int flag = dao.editFilm(filmId,title,description,languageId);

        return flag;
    }
}
