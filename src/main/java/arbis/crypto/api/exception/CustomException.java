package arbis.crypto.api.exception;


import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    private final ErrorExceptioni18n i18n;
    private String details;

    public CustomException(ErrorExceptioni18n i18n) {
        super(i18n.name());
        this.i18n = i18n;
        this.details = i18n.getMsg();
    }
}
