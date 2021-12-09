package arbis.crypto.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private int errorCode;
    private String details;

    public ErrorResponse(int errorCode) {
        this.errorCode = errorCode;
    }
}
