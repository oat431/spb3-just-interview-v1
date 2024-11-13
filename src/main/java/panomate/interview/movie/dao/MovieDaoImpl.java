package panomate.interview.movie.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import panomate.interview.movie.entity.Comment;
import panomate.interview.movie.entity.Movie;
import panomate.interview.movie.repository.CommentRepository;
import panomate.interview.movie.repository.MovieRepository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class MovieDaoImpl implements MovieDao {
    private final MovieRepository movieRepository;
    private final CommentRepository commentRepository;

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie getMovieById(UUID id) {
        return movieRepository.findById(id).orElse(null);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public void deleteMovie(Movie movie) {
        movieRepository.delete(movie);
    }

    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment getCommentById(UUID id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Comment> getCommentsByMovieId(UUID movieId) {
        return null;
    }

    @Override
    public void deleteComment(Comment comment) {
        commentRepository.delete(comment);
    }
}
