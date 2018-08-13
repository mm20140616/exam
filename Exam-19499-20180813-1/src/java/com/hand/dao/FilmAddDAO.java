package com.hand.dao;

import com.hand.pojo.FilmDTO;

public interface FilmAddDAO {
    void saveFilm(Integer filmId,String title,String description,String languageId);
}
