package panomate.interview.movie.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import panomate.interview.common.BaseEntity;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@SuperBuilder
@Table(name = "tb_movie")
@EqualsAndHashCode(callSuper = true)
public class Movie extends BaseEntity {
    public Movie() {}
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Comment> comments;
}
