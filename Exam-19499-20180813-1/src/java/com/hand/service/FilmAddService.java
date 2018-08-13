package com.hand.service;

import com.hand.pojo.FilmDTO;

public interface FilmAddService {
    void saveFilm(Integer filmId,String title,String description,String languageId);
}
