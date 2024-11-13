package panomate.interview.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import panomate.interview.movie.entity.Comment;

import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
}
