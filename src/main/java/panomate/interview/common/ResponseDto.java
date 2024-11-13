package panomate.interview.common;

public record ResponseDto<T>(
        T data,
        int status
) {
}
