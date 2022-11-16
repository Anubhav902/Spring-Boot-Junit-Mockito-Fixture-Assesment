package com.junit.exception.handling.junitExceptionHandling.controller;

import com.junit.exception.handling.junitExceptionHandling.exceptionHandling.MovieException;
import com.junit.exception.handling.junitExceptionHandling.model.Movie;
import com.junit.exception.handling.junitExceptionHandling.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService service;


    @PostMapping(value = "/saveMovie")
    public Movie savingAMovie(@RequestBody Movie movie) throws MovieException {
        if (movie.getName() == null) {
            throw new MovieException("Movie name can't be null.");
        }
        if (movie.getReleaseDate() == null) {
            throw new MovieException("Release Date can't be null");
        }
        return service.saveMovie(movie);
    }

    @GetMapping("/getMovies")
    public List<Movie> GatMovies() {
        return service.getMovies();
    }

    @DeleteMapping("/deleteMovie/{id}")
    public String deleteMovie(@PathVariable("id") ObjectId id) throws MovieException {
        try {
            service.getMovieById(id);
            return service.deleteMovies(id);
        } catch (Exception e) {
            throw new MovieException("Movie not found");
        }
    }

    @GetMapping("/getMovie/{id}")
    public Movie getMovie(@PathVariable("id") ObjectId id) throws MovieException {
        Movie movie = null;
        try {
            movie = service.getMovieById(id);
            return movie;
        } catch (Exception e) {
            if (movie == null) {
                throw new MovieException("Movie not found");
            }
        }
        throw new MovieException("Unknown Error.");

    }


    @PatchMapping(value = "/updateMovie")
    public Movie updateMovie(@RequestBody Movie movie) throws MovieException {
        Movie movie_ = null;
        try {
            movie_ = service.getMovieById(movie.getId());
            return service.updateMovies(movie);
        } catch (Exception e) {
            if (movie == null) {
                throw new MovieException("Movie not found");
            }
            throw new MovieException(e.getMessage());
        }
    }
}