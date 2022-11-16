package com.junit.exception.handling.junitExceptionHandling.service;

import com.junit.exception.handling.junitExceptionHandling.model.Movie;
import com.junit.exception.handling.junitExceptionHandling.repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public List<Movie> getMovies(){
        List<Movie> result = repository.findAll();
        return result;
    }

    public Movie saveMovie(Movie movie){
        Movie savedMovie = repository.save(movie);
        return savedMovie;
    }

    public String deleteMovies(ObjectId id) {
        repository.deleteById(id);
        return "Successfully deleted";
    }

    public Movie getMovieById(ObjectId id) {
        return repository.findById(id).get();

    }

    public Movie updateMovies(Movie movie) {
        return repository.save(movie);
    }
}