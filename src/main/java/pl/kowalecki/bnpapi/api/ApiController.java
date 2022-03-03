package pl.kowalecki.bnpapi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.kowalecki.bnpapi.model.Currency;

import java.math.BigDecimal;

@RestController
public class ApiController {

    @Autowired
    private RestTemplate restTemplate;

    private final String URL = "http://api.nbp.pl/api/exchangerates/rates/c/usd/";

    public BigDecimal getCurrency(String date){
        Currency currency = restTemplate.getForObject(URL + date + "/?format=json", Currency.class);
        return currency.getRates().get(0).getBid();
    }

}
