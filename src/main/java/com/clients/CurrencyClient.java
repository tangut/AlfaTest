package com.clients;

import com.model.dto.CurrencyDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * FEIGN Клиент для Open Exchange Api.
 */
@Component
@FeignClient(name = "currency-client", url = "${api.openexchange.url}")
public interface CurrencyClient {
    /**
     * Возвращает текущие курсы валют.
     *
     * @param id уникальный апи ключ пользователя.
     * @return {@link CurrencyDto}
     */
    @GetMapping("/latest.json")
    CurrencyDto getCurrentRate(@RequestParam("app_id") String id);

    /**
     * Возвращает курсы валют за определенную дату.
     *
     * @param date дата.
     * @param id уникальный апи ключ пользователя.
     * @return {@link CurrencyDto}
     */
    @GetMapping("/historical/{date}.json")
    CurrencyDto getHistoricalRate(@PathVariable("date") String date,
                                  @RequestParam("app_id") String id);
}
