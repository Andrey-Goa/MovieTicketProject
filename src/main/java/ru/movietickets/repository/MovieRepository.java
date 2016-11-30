package ru.movietickets.repository;

import org.springframework.data.repository.CrudRepository;
import ru.movietickets.db.Movie;

/**
 * Created by andrey-goa on 27.11.16.
 */
public interface MovieRepository extends CrudRepository<Movie, Integer> {

}
