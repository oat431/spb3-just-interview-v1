package panomate.interview.movie.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import panomate.interview.movie.dao.MovieDao;
import panomate.interview.movie.entity.Comment;
import panomate.interview.movie.entity.Movie;
import panomate.interview.movie.payload.request.CommentRequest;
import panomate.interview.movie.payload.request.MovieRequest;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{
    private final MovieDao movieDao;

    @Override
    public Movie createMovie(MovieRequest request) {
        Movie newMovie = Movie.builder()
                .title(request.title())
                .description(request.description())
                .releaseDate(request.releaseDate())
                .build();
        return movieDao.saveMovie(newMovie);
    }

    @Override
    public Movie updateMovie(UUID id, MovieRequest request) {
        Movie oldMovie = movieDao.getMovieById(id);
        if(oldMovie == null) {
            return null;
        }
        oldMovie.setTitle(request.title());
        oldMovie.setDescription(request.description());
        oldMovie.setReleaseDate(request.releaseDate());
        return movieDao.saveMovie(oldMovie);
    }

    @Override
    public Movie getMovieById(UUID id) {
        return movieDao.getMovieById(id);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieDao.getAllMovies();
    }

    @Override
    public Movie deleteMovie(UUID id) {
        Movie movie = movieDao.getMovieById(id);
        if(movie != null) {
            movieDao.deleteMovie(movie);
        }
        return null;
    }

    @Override
    public Movie addComment(UUID movieId, CommentRequest request) {
        Movie movie = movieDao.getMovieById(movieId);
        if(movie == null) {
            return null;
        }
        Comment newComment = Comment.builder()
                .movie(movie)
                .content(request.content())
                .rate(request.rate())
                .build();
        movieDao.saveComment(newComment);
        return movieDao.getMovieById(movieId);
    }

    @Override
    public Movie updateComment(UUID movieId, UUID commentId, CommentRequest request) {
        Movie movie = movieDao.getMovieById(movieId);
        if(movie == null) {
            return null;
        }
        Comment comment = movieDao.getCommentById(commentId);
        if(comment == null) {
            return null;
        }
        comment.setContent(request.content());
        comment.setRate(request.rate());
        movieDao.saveComment(comment);
        return movieDao.getMovieById(movieId);
    }

    @Override
    public Comment getComment(UUID movieId, UUID commentId) {
        return movieDao.getCommentById(commentId);
    }

    @Override
    public Movie deleteComment(UUID movieId, UUID commentId) {
        Comment comment = movieDao.getCommentById(commentId);
        if(comment != null) {
            movieDao.deleteComment(comment);
        }
        return movieDao.getMovieById(movieId);
    }
}
