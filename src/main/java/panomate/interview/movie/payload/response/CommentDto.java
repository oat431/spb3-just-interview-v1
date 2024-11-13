package panomate.interview.movie.payload.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "CommentDto", description = "Response payload for comment")
public record CommentDto(
        @Schema(
                name = "id",
                description = "Unique identifier of the comment",
                example = "550e8400-e29b-41d4-a716-446655440000",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String id,

        @Schema(
                name = "content",
                description = "Content of the comment",
                example = "This movie is awesome!",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String content,

        @Schema(
                name = "rate",
                description = "Rate of the movie",
                example = "3.5",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        Double rate
) {
}
