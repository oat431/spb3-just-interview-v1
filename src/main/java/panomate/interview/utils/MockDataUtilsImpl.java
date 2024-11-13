package panomate.interview.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import panomate.interview.movie.entity.Comment;
import panomate.interview.movie.entity.Movie;
import panomate.interview.movie.repository.CommentRepository;
import panomate.interview.movie.repository.MovieRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MockDataUtilsImpl implements MockDataUtils {
    final MovieRepository movieRepository;
    final CommentRepository commentRepository;

    @Override
    public void mockMovie() {
        Movie movie1 = Movie.builder()
                .title("The Shawshank Redemption")
                .description("Two imprisoned")
                .releaseDate(LocalDate.of(1994, 10, 14))
                .build();
        movieRepository.save(movie1);
        Comment comment1 = Comment.builder()
                .movie(movie1)
                .content("This is a great movie")
                .rate(5.0)
                .build();
        Comment comment2 = Comment.builder()
                .movie(movie1)
                .content("This is a great movie")
                .rate(4.5)
                .build();
        commentRepository.save(comment1);
        commentRepository.save(comment2);
        List<Comment> comments = List.of(comment1, comment2);
        movie1.setComments(comments);

        Movie movie2 = Movie.builder()
                .title("The Godfather")
                .description("The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant")
                .releaseDate(LocalDate.of(1972, 3, 24))
                .build();
        movieRepository.save(movie2);
        Comment comment3 = Comment.builder()
                .movie(movie2)
                .content("This is a great movie")
                .rate(5.0)
                .build();
        Comment comment4 = Comment.builder()
                .movie(movie2)
                .content("This is a great movie")
                .rate(4.5)
                .build();
        commentRepository.save(comment3);
        commentRepository.save(comment4);
        List<Comment> comments2 = List.of(comment3, comment4);
        movie2.setComments(comments2);
    }

    @Override
    public long checkMovie() {
        return movieRepository.count();
    }
}
