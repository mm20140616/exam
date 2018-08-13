package com.hand.dao;

import com.hand.pojo.FilmDTO;

import java.util.List;

public interface ListShowDAO {
    List<FilmDTO> findFilmByPage(int begin, int count);
    Integer getTotal();
}
