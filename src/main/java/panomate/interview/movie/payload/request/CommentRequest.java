package panomate.interview.movie.payload.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "CommentRequest", description = "Request payload for creating a comment")
public record CommentRequest(
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
