package arbis.crypto.api.domain;


import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class CryptoCurrencyRequest {

    @NotNull
    @Length(min = 3 , max = 3)
    private String symbols;

}
