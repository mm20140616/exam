package com.hand.pojo;

/**
 * @ProjectName Exam-19499-20180813-1
 * @ClassName FilmDTO
 * @Description TODO
 * @Author 赵晓宇
 * @Date 2018/8/13 13:53
 * @Version 1.0
 **/
public class FilmDTO {
    private Integer filmId;
    private String title;
    private String description;
    private String lanuageName;

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanuageName() {
        return lanuageName;
    }

    public void setLanuageName(String lanuageName) {
        this.lanuageName = lanuageName;
    }

    public FilmDTO(Integer filmId, String title, String description, String lanuageName) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.lanuageName = lanuageName;
    }
}
