package panomate.interview.movie.payload.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(name = "MovieRequest", description = "Request payload for creating a movie")
public record MovieRequest(
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
                requiredMode = Schema.RequiredMode.NOT_REQUIRED
        )
        String description,

        @Schema(
                name = "releaseDate",
                description = "Release date of the movie",
                example = "1994-10-14",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        LocalDate releaseDate
) {
}
