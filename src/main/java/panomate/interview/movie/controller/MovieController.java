package panomate.interview.movie.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import panomate.interview.common.ResponseDto;
import panomate.interview.movie.entity.Movie;
import panomate.interview.movie.mapper.MovieMapper;
import panomate.interview.movie.payload.request.CommentRequest;
import panomate.interview.movie.payload.request.MovieRequest;
import panomate.interview.movie.payload.response.MovieDto;
import panomate.interview.movie.service.MovieService;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/movie")
@Tag(name = "Movie API", description = "Movie API documentation")
public class MovieController {
    private final MovieService movieService;

    @GetMapping()
    @Operation(summary = "Get all movies", description = "Get all movies from the database")
    public ResponseEntity<ResponseDto<List<MovieDto>>> getAllMovies() {
        List<MovieDto> movies = MovieMapper.MOVIE_MAPPER.toMovieDto(movieService.getAllMovies());
        if(movies.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        ResponseDto<List<MovieDto>> response = new ResponseDto<>(
                movies,
                200
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a movie by id", description = "Get a movie by id from the database")
    public ResponseEntity<ResponseDto<MovieDto>> getMovieById(@PathVariable String id) {
        UUID uuid = UUID.fromString(id);
        Movie movie = movieService.getMovieById(uuid);
        if(movie == null) {
            ResponseDto<MovieDto> response = new ResponseDto<>(
                    null,
                    404
            );
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        MovieDto movieDto = MovieMapper.MOVIE_MAPPER.toMovieDto(movie);
        ResponseDto<MovieDto> response = new ResponseDto<>(
                movieDto,
                200
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping()
    @Operation(summary = "Create a movie", description = "Create a movie in the database")
    public ResponseEntity<ResponseDto<MovieDto>> createMovie(
            @RequestBody MovieRequest movieRequest
    ) {
        MovieDto movie = MovieMapper.MOVIE_MAPPER.toMovieDto(movieService.createMovie(movieRequest));
        ResponseDto<MovieDto> response = new ResponseDto<>(
                movie,
                201
        );
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a movie by id", description = "Update a movie by id in the database")
    public ResponseEntity<ResponseDto<MovieDto>> updateMovie(
            @PathVariable String id,
            @RequestBody MovieRequest movieRequest
    ) {
        UUID uuid = UUID.fromString(id);
        Movie movie = movieService.getMovieById(uuid);
        if(movie == null) {
            ResponseDto<MovieDto> response = new ResponseDto<>(
                    null,
                    404
            );
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        MovieDto movieDto = MovieMapper.MOVIE_MAPPER.toMovieDto(movie);
        ResponseDto<MovieDto> response = new ResponseDto<>(
                movieDto,
                200
        );
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a movie by id", description = "Delete a movie by id from the database")
    public ResponseEntity<ResponseDto<String>> deleteMovie(@PathVariable String id) {
        UUID uuid = UUID.fromString(id);
        Movie movie = movieService.getMovieById(uuid);
        if(movie == null) {
            ResponseDto<String> response = new ResponseDto<>(
                    null,
                    404
            );
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        movieService.deleteMovie(uuid);
        ResponseDto<String> response = new ResponseDto<>(
                String.format("Movie with id %s has been deleted", id),
                204
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{movieId}/comment")
    @Operation(summary = "Create a comment for a movie", description = "Create a comment for a movie in the database")
    public ResponseEntity<ResponseDto<MovieDto>> createComment(
            @PathVariable String movieId,
            @RequestBody CommentRequest commentRequest
    ) {
        UUID uuid = UUID.fromString(movieId);
        Movie movie = movieService.getMovieById(uuid);
        if(movie == null) {
            ResponseDto<MovieDto> response = new ResponseDto<>(
                    null,
                    404
            );
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        MovieDto movieDto = MovieMapper.MOVIE_MAPPER.toMovieDto(movieService.addComment(uuid, commentRequest));
        ResponseDto<MovieDto> response = new ResponseDto<>(
                movieDto,
                201
        );
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{movieId}/comment/{commentId}")
    @Operation(summary = "Update a comment for a movie", description = "Update a comment for a movie in the database")
    public ResponseEntity<ResponseDto<MovieDto>> updateComment(
            @PathVariable String movieId,
            @PathVariable String commentId,
            @RequestBody CommentRequest commentRequest
    ) {
        UUID movieUuid = UUID.fromString(movieId);
        UUID commentUuid = UUID.fromString(commentId);
        Movie movie = movieService.getMovieById(movieUuid);
        if(movie == null) {
            ResponseDto<MovieDto> response = new ResponseDto<>(
                    null,
                    404
            );
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        MovieDto movieDto = MovieMapper.MOVIE_MAPPER.toMovieDto(movieService.updateComment(movieUuid, commentUuid, commentRequest));
        ResponseDto<MovieDto> response = new ResponseDto<>(
                movieDto,
                200
        );
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{movieId}/comment/{commentId}")
    @Operation(summary = "Delete a comment for a movie", description = "Delete a comment for a movie in the database")
    public ResponseEntity<ResponseDto<MovieDto>> deleteComment(
            @PathVariable String movieId,
            @PathVariable String commentId
    ) {
        UUID movieUuid = UUID.fromString(movieId);
        UUID commentUuid = UUID.fromString(commentId);
        Movie movie = movieService.getMovieById(movieUuid);
        if(movie == null) {
            ResponseDto<MovieDto> response = new ResponseDto<>(
                    null,
                    404
            );
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        MovieDto movieDto = MovieMapper.MOVIE_MAPPER.toMovieDto(movieService.deleteComment(movieUuid, commentUuid));
        ResponseDto<MovieDto> response = new ResponseDto<>(
                movieDto,
                204
        );
        return ResponseEntity.ok(response);
    }

}
