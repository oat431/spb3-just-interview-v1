package panomate.interview.movie.payload.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(name = "MovieDto", description = "Response payload for movie")
public record MovieDto(
        @Schema(
                name = "id",
                description = "Unique identifier of the movie",
                example = "550e8400-e29b-41d4-a716-446655440000",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String id,

        @Schema(
                name = "title",
                description = "Title of the movie",
                example = "The Shawshank Redemption",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String title,

        @Schema(
                name = "description",
                description = "Description of the movie",
                example = "Two imprisoned",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String description,

        @Schema(
                name = "releaseDate",
                description = "Release date of the movie",
                example = "1994-10-14",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String releaseDate,

        @Schema(
                name = "comments",
                description = "Comments of the movie",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        List<CommentDto> comments
) {
}
