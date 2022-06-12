package com.services;

import com.model.Gif;

/**
 * Сервис, отвечающий за взаимодействие с giphy api.
 */
public interface GiphyService {
    /**
     * Возвращает случайную gif в зависимости от тэга.
     *
     * @param tag тэг для поиска случайной gif.
     * @return gif.
     */
    Gif getGif(String tag);
}
