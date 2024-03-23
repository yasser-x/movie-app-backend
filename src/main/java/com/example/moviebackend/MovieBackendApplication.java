package com.example.moviebackend;

import com.example.moviebackend.model.Comment;
import com.example.moviebackend.model.Movie;
import com.example.moviebackend.repository.CommentRepository;
import com.example.moviebackend.repository.MoviesRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@AllArgsConstructor
public class MovieBackendApplication {


    public static void main(String[] args) {
        SpringApplication.run(MovieBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(MoviesRepository moviesRepository, CommentRepository commentRepository){
        return args -> {
            moviesRepository.save(Movie.builder().id((long) 2).isFavorite(true).build());
            commentRepository.save(Comment.builder().Text("Good movie").publisher("anwar").movieId((long) 2).build());
            commentRepository.save(Comment.builder().Text("Love it!").publisher("Adnan").movieId((long) 2).build());
            commentRepository.save(Comment.builder().Text("5/5 stars!").publisher("Soufiane").movieId((long) 2).build());
        };
    }


}
