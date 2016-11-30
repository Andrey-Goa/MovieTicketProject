package ru.movietickets.db;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movieId")
    private Integer movieId;

    @NotNull
    @Column(name = "movieTitle")
    private String movieTitle;

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

}

