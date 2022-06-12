package com.services;

import com.clients.CurrencyClient;
import com.configs.OpenExchangeConfig;
import com.model.dto.CurrencyDto;
import com.utils.DateUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@SpringBootTest
public class CurrencyServiceTest {

    private CurrencyClient currencyClient = Mockito.mock(CurrencyClient.class);
    private CurrencyService currencyService;

    private final String currency = "RUB";
    private final String apiKeyId = "8734fc1547214c408a6bda0649df1670";

    private Map<String, Double> rates = new HashMap<>();
    private Map<String, Double> emptyRates = new HashMap<>();

    private final Double rate = new Random().nextDouble();

    @BeforeEach
    public void init() {
        OpenExchangeConfig config = new OpenExchangeConfig();
        config.setCode(currency);
        config.setApiKeyId(apiKeyId);
        currencyService = new CurrencyServiceImpl(currencyClient, config);
        rates.put("RUB", rate);
        emptyRates.put("RUB", 0.0);
    }

   @Test
    public void testGetCurrentCurrencyRate() {
       Assertions.assertNotNull(currencyClient);
       Assertions.assertNotNull(currencyService);
       CurrencyDto currencyDto = new CurrencyDto();
       currencyDto.setRates(rates);
       Mockito.when(currencyClient.getCurrentRate(Mockito.any())).thenReturn(currencyDto);
       Double returnRate = currencyService.getCurrentCurrencyRate();
       Assertions.assertEquals(returnRate, rate);
    }

    @Test
    public void testGetHistoricalCurrencyRate() {
        Assertions.assertNotNull(currencyClient);
        Assertions.assertNotNull(currencyService);
        CurrencyDto currencyDto = new CurrencyDto();
        CurrencyDto emptyCurrency = new CurrencyDto();
        currencyDto.setRates(rates);
        emptyCurrency.setRates(emptyRates);
        String yesterdayDate = DateUtils.getYesterdayDateString();
        Mockito.when(currencyClient.getHistoricalRate(Mockito.eq(yesterdayDate), Mockito.any())).thenReturn(currencyDto);
        Mockito.when(currencyClient.getHistoricalRate(Mockito.eq("Some date"), Mockito.any())).thenReturn(emptyCurrency);
        Double returnRate = currencyService.getHistoricalCurrencyRate(yesterdayDate);
        Assertions.assertEquals(returnRate, rate);
        Double emptyRate = currencyService.getHistoricalCurrencyRate("Some date");
        Assertions.assertEquals(emptyRate, 0.0);
    }
}
