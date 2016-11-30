package ru.movietickets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.movietickets.db.Movie;
import ru.movietickets.repository.MovieRepository;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public Iterable<Movie> all() {
        return movieRepository.findAll();
    }

    public Movie create(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie find(int movieId) {
        return movieRepository.findOne(movieId);
    }


}
