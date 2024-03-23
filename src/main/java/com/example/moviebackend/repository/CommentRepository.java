package com.example.moviebackend.repository;

import com.example.moviebackend.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    public List<Comment> getCommentsByMovieId(Long MovieId);
}
