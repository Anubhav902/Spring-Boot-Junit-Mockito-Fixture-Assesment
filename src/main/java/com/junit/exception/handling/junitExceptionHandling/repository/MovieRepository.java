package com.junit.exception.handling.junitExceptionHandling.repository;

import com.junit.exception.handling.junitExceptionHandling.model.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
}