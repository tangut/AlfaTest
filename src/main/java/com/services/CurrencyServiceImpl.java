package com.services;

import com.clients.CurrencyClient;
import com.dto.CurrencyDto;
import com.utils.DateUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;



@Service
public class CurrencyServiceImpl implements CurrencyService {
    @Value("$api.openexchange.id")
    private String apiKeyId;

    private final CurrencyClient currencyClient;


    public CurrencyServiceImpl(final CurrencyClient currencyClient) {
        this.currencyClient = currencyClient;
    }

    @Override
    public Double getCurrentCurrencyRate(String code) {
        CurrencyDto dto = currencyClient.getCurrentRate(apiKeyId);
        Double rate = dto.getRates().get(code);
        System.out.println("Current rate of " + code + " is " + rate);
        return rate;
    }

    @Override
    public Double getYesterdayCurrencyRate(String code) {
        String yesterdayDate = DateUtils.getYesterdayDateString();
        CurrencyDto dto = currencyClient.getHistoricalRate(yesterdayDate, apiKeyId);
        Double rate = dto.getRates().get(code);
        System.out.println("Yesterday rate of " + code + " is " + rate);
        return rate;
    }

    private boolean compareCurrentAndYesterdayRates(Double currentRate, Double yesterdayRate) {
        if (currentRate > yesterdayRate)
            return true;
        else return false;
    }
}
