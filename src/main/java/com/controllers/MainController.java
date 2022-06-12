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

@Controller
@RequestMapping(value = "/main")
public class MainController {
    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private GiphyService giphyService;

    @GetMapping
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
