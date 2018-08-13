package com.hand.service;

import com.hand.pojo.FilmDTO;

import java.util.List;

public interface ListShowService {
    List<FilmDTO> findFilmByPage(int page, int rows);
    Integer getTotal();
}
