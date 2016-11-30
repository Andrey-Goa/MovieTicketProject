package ru.movietickets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.movietickets.db.Movie;


import javax.annotation.PostConstruct;

@Component
@Scope(value = "singleton")
public class InitMovie {

    @Autowired
    MovieService movieService;

    Movie m1 = new Movie();
    Movie m2 = new Movie();
    Movie m3 = new Movie();

    @PostConstruct
    public void init() {
        m1.setMovieTitle("Фильм 1");
        m2.setMovieTitle("Фильм 2");
        m3.setMovieTitle("Фильм 3");
        movieService.create(m1);
        movieService.create(m2);
        movieService.create(m3);

    }
}
