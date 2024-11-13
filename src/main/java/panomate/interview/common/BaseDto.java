package panomate.interview.common;

import java.time.LocalDateTime;
import java.util.UUID;

public record BaseDto(
        UUID id,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        Long version
) {

}
