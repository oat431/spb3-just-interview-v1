package panomate.interview.movie.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import panomate.interview.common.BaseEntity;

@Data
@Entity
@SuperBuilder
@Table(name = "tb_comment")
@EqualsAndHashCode(callSuper = true)
public class Comment extends BaseEntity {
    public Comment() {}

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "rate")
    private Double rate;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
}
