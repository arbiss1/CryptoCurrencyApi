package arbis.crypto.api.service;


import arbis.crypto.api.domain.CryptoCurrencyResponse;

public interface CryptoCurrencyConverterImpl {
    CryptoCurrencyResponse callAPI(String symbols);
}
