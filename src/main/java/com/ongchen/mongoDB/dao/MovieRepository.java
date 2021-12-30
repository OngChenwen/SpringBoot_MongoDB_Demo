package com.ongchen.mongoDB.dao;

import com.ongchen.mongoDB.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MovieRepository extends MongoRepository<Movie,String> {
   Optional<Movie> findMovieById(String MovieId);
}
