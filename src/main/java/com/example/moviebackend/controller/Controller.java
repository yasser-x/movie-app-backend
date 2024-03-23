package com.example.moviebackend.controller;

import com.example.moviebackend.model.Comment;
import com.example.moviebackend.model.Movie;
import com.example.moviebackend.repository.CommentRepository;
import com.example.moviebackend.repository.MoviesRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class Controller {
    private final MoviesRepository moviesRepository;
    private final CommentRepository commentRepository;

    @GetMapping("/movies/{id}")
    public Movie getMovieById(@PathVariable Long id){
        return moviesRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie do not exist"));
    }



    @GetMapping("/comments/{movieId}")
    public List<Comment> getCommentsByMovie(@PathVariable Long movieId){
        return commentRepository.getCommentsByMovieId(movieId);
    }




    @PostMapping("/comments/{movieId}")
    public Comment addCommentToMovie(@PathVariable Long movieId, @RequestBody Comment comment) {
        return commentRepository.save(comment);
    }

    @GetMapping("/movies/{id}/isFavorite")
    public boolean isMovieFavorite(@PathVariable Long id) {
        Movie movie = moviesRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie does not exist"));
        return movie.isFavorite();
    }

    @GetMapping("/movies/{id}/exist")
    public boolean movieExists(@PathVariable Long id){
        System.out.println("The movie by ID : " + id + " Existence status : " + moviesRepository.existsById(id));
        return moviesRepository.existsById(id);
    }


    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie movie) {
        return moviesRepository.save(movie);
    }

    @PutMapping("/movies/{id}/updateFavorite")
    public Movie updateMovieFavoriteStatus(@PathVariable Long id, @RequestBody boolean isFavorite) {
        Movie movie = moviesRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie does not exist"));
        movie.setFavorite(isFavorite);
        return moviesRepository.save(movie);
    }

}
