package arbis.crypto.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class CryptoCurrencyResponse {

    @JsonProperty("rates")
    private Map<String, Double> rates;
    @JsonProperty
    private String target;

}
