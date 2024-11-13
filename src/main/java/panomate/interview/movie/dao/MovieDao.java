package panomate.interview.movie.dao;

import panomate.interview.movie.entity.Comment;
import panomate.interview.movie.entity.Movie;

import java.util.List;
import java.util.UUID;

public interface MovieDao {
    Movie saveMovie(Movie movie);
    Movie getMovieById(UUID id);
    List<Movie> getAllMovies();
    void deleteMovie(Movie movie);

    Comment saveComment(Comment comment);
    Comment getCommentById(UUID id);
    List<Comment> getCommentsByMovieId(UUID movieId);
    void deleteComment(Comment comment);
}
