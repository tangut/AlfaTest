package com.services;

/**
 * Сервис, отвечающий за взаимодействие с open exchange api.
 */
public interface CurrencyService {
    /**
     * Возвращает сегодняшний курс валюты, заданной в конфиге, к USD.
     *
     * @return текущий курс валюты к USD.
     */
    Double getCurrentCurrencyRate();

    /**
     * Возвращает курс валюты, заданной в конфиге, к USD за определенную дату.
     *
     * @param date дата за которую мы хотим видеть курс.
     * @return курс валюты к USD.
     */
    Double getHistoricalCurrencyRate(String date);
}
