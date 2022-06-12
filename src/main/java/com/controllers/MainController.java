package com.controllers;

import com.model.Gif;
import com.services.CurrencyService;
import com.services.GiphyService;
import com.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Главный контроллер, отвечающий за эндпоинт, возвращающий гифку в зависимости от курса валют.
 */
@Controller
@RequestMapping(value = "api/main")
public class MainController { // не лучшее название, однако для задания нужен лишь один эндпоинт
    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private GiphyService giphyService;

    /**
     * Эндпоинт, перенаправляющий пользователя на гифку, в зависимости от повышения/понижения курса заданной валюты к USD.
     */
    @GetMapping // Т.к в задании чётко не сказано, в каком виде нужно вернуть гифку, а фронт не требуется, эндпоинт просто перенаправляет пользователя на гифку по её ссылке.
    public ResponseEntity showGif() throws URISyntaxException {
        Double currentRate = currencyService.getCurrentCurrencyRate();
        Double yesterdayRate = currencyService.getHistoricalCurrencyRate(DateUtils.getYesterdayDateString());
        Gif gif;
        if (currentRate < yesterdayRate)
            gif =  giphyService.getGif("rich");
        else gif = giphyService.getGif("broke");
        URI uri = new URI(gif.getUrl());
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uri);
        return new ResponseEntity(headers, HttpStatus.SEE_OTHER);
    }
}
