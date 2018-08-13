package com.hand.dao;

public interface FilmEditDAO {
    int editFilm(Integer filmId,String title,String description,String languageId);
}
