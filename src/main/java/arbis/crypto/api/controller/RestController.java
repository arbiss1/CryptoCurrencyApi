package arbis.crypto.api.controller;

import arbis.crypto.api.domain.CryptoCurrencyRequest;
import arbis.crypto.api.domain.CryptoCurrencyResponse;
import arbis.crypto.api.service.serviceImpl.CryptoCurrencyConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    public static final Logger logger = LoggerFactory.getLogger(RestController.class);

    @Autowired
    CryptoCurrencyConverter cryptoCurrencyConverter;

    @PostMapping("/requestCrypto")
    public ResponseEntity<CryptoCurrencyResponse> requestCrypto(@Valid @RequestBody CryptoCurrencyRequest cryptoCurrencyRequest, BindingResult result) throws Exception{

        if(result.hasErrors()){
            throw new Exception("Validation error");
        }

        CryptoCurrencyResponse cryptoCurrencyResponse = cryptoCurrencyConverter.callAPI(cryptoCurrencyRequest.getSymbols());

        logger.info("Exchange rates from {} is: {}",cryptoCurrencyRequest.getSymbols(),cryptoCurrencyResponse.getRates().entrySet() + cryptoCurrencyResponse.getTarget());

        return new ResponseEntity<>(cryptoCurrencyResponse, HttpStatus.OK);
    }
}
