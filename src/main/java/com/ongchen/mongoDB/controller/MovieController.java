package com.ongchen.mongoDB.controller;

import java.util.List;
import java.util.Optional;

import com.ongchen.mongoDB.dao.MovieRepository;
import com.ongchen.mongoDB.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/")
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movieList = movieRepository.findAll();
        if (movieList.size() == 0) return ResponseEntity.internalServerError().build();
        return new ResponseEntity<>(movieList,HttpStatus.ACCEPTED);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable String movieId) {
        Optional<Movie> movie = movieRepository.findMovieById(movieId);
        if (movie.isPresent()) return new ResponseEntity<>(movie,HttpStatus.ACCEPTED);
        return ResponseEntity.notFound().build();
    }
    @PostMapping( "/")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        if (movie == null) return ResponseEntity.internalServerError().build();
        Movie newMovie = new Movie(movie.getName(),movie.getCategory(),movie.getRating());
        return new ResponseEntity<>(movieRepository.save(newMovie),HttpStatus.ACCEPTED);
    }
    @PutMapping(value = "/{movieId}")
    public ResponseEntity<Movie> updateMovie(@PathVariable String movieId, @RequestBody Movie movie) {
        if (movieRepository.findMovieById(movieId).isEmpty()) return ResponseEntity.notFound().build();
        return new ResponseEntity<>(movieRepository.save(movie), HttpStatus.ACCEPTED);
    }
    @DeleteMapping(value = "/{movieId}")
    public ResponseEntity<Void> deleteMovie(@PathVariable String movieId) {
        if (movieRepository.findMovieById(movieId).isEmpty()) return ResponseEntity.notFound().build();
        movieRepository.deleteById(movieId);
        return ResponseEntity.ok().build();
    }

}