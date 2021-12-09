package arbis.crypto.api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorExceptioni18n {
    THERES_NO_CURRENCY(150 ,Messages.NO_CURRENCY),
    INVALID_CHARACTERS(151 ,Messages.INVALID_ENTRY);
    private final int code;
    private final String msg;


    public static class Messages{
        public final static String NO_CURRENCY = "No such currency";
        public final static String INVALID_ENTRY = "Rate must be 3 characters";
    }
}


