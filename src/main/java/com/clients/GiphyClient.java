package com.clients;

import com.model.dto.GiphyDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * FEIGN Клиент для Giphy API.
 */
@FeignClient(name = "giphy-client", url = "${api.giphy.url}")
@Component
public interface GiphyClient {
    /**
     * Возвращает случайную gif с заданным тегом и рейтингом.
     *
     * @param id уникальный апи ключ пользователя.
     * @param tag тэг.
     * @param rating рейтинг.
     * @return {@link GiphyDto}
     */
    @GetMapping()
    GiphyDto getGif(@RequestParam("api_key") String id,
                    @RequestParam("tag") String tag,
                    @RequestParam("rating") String rating);
}
