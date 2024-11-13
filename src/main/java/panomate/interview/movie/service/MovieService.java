package panomate.interview.movie.service;

import panomate.interview.movie.entity.Comment;
import panomate.interview.movie.entity.Movie;
import panomate.interview.movie.payload.request.CommentRequest;
import panomate.interview.movie.payload.request.MovieRequest;

import java.util.List;
import java.util.UUID;

public interface MovieService {
    Movie createMovie(MovieRequest request);
    Movie updateMovie(UUID id, MovieRequest request);
    Movie getMovieById(UUID id);
    List<Movie> getAllMovies();
    Movie deleteMovie(UUID id);

    Movie addComment(UUID movieId, CommentRequest request);
    Movie updateComment(UUID movieId, UUID commentId, CommentRequest request);
    Comment getComment(UUID movieId, UUID commentId);
    Movie deleteComment(UUID movieId, UUID commentId);
}
