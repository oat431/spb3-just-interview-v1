package panomate.interview.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import panomate.interview.movie.entity.Movie;

import java.util.UUID;

public interface MovieRepository extends JpaRepository<Movie, UUID> {
}
