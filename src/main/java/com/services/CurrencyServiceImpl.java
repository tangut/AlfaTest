package com.services;

import com.clients.CurrencyClient;
import com.configs.OpenExchangeConfig;
import com.model.dto.CurrencyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private final OpenExchangeConfig config;

    private final CurrencyClient currencyClient;

    public CurrencyServiceImpl(final CurrencyClient currencyClient,
                               final OpenExchangeConfig config) {
        this.currencyClient = currencyClient;
        this.config = config;
    }

    @Override
    public Double getCurrentCurrencyRate() {
        CurrencyDto dto = currencyClient.getCurrentRate(config.getApiKeyId());
        Double rate = dto.getRates().get(config.getCode());
        System.out.println("Current rate of " + config.getCode() + " to USD is " + rate);
        return rate;
    }

    @Override
    public Double getHistoricalCurrencyRate(String date) {
        CurrencyDto dto = currencyClient.getHistoricalRate(date, config.getApiKeyId());
        Double rate = dto.getRates().get(config.getCode());
        System.out.println("Rate from date " + date + " of " + config.getCode() + " to USD is " + rate);
        return rate;
    }
}
