package com.services;

import com.clients.CurrencyClient;
import com.configs.OpenExchangeConfig;
import com.dto.CurrencyDto;
import com.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    @Autowired
    private OpenExchangeConfig config;

    private final CurrencyClient currencyClient;

    public CurrencyServiceImpl(final CurrencyClient currencyClient) {
        this.currencyClient = currencyClient;
    }

    @Override
    public Double getCurrentCurrencyRate() {
        CurrencyDto dto = currencyClient.getCurrentRate(config.getApiKeyId());
        Double rate = dto.getRates().get(config.getCode());
        System.out.println("Current rate of " + config.getCode() + " to USD is " + rate);
        return rate;
    }

    @Override
    public Double getYesterdayCurrencyRate() {
        String yesterdayDate = DateUtils.getYesterdayDateString();
        CurrencyDto dto = currencyClient.getHistoricalRate(yesterdayDate, config.getApiKeyId());
        Double rate = dto.getRates().get(config.getCode());
        System.out.println("Yesterday rate of " + config.getCode() + " to USD is " + rate);
        return rate;
    }
}
