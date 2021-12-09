package arbis.crypto.api.exception;

import arbis.crypto.api.domain.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler({CustomException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleCustomException(CustomException e) {
        log.error("Runtime Exception thrown: {}", e);
        return new ErrorResponse(e.getI18n().getCode(), e.getDetails());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponse handleRequestBodyNotValidException(MethodArgumentNotValidException exception) {
        log.warn(exception.getMessage());
        return new ErrorResponse(ErrorExceptioni18n.INVALID_CHARACTERS.getCode());
    }
}
