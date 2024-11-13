package panomate.interview.movie.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import panomate.interview.movie.entity.Movie;
import panomate.interview.movie.payload.response.MovieDto;

import java.util.List;

@Mapper
public interface MovieMapper {
    MovieMapper MOVIE_MAPPER = Mappers.getMapper(MovieMapper.class);

    MovieDto toMovieDto(Movie movie);
    List<MovieDto> toMovieDto(List<Movie> movie);
}
