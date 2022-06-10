package com.controllers;

import com.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;
import java.net.URISyntaxException;

@Controller
@RequestMapping(value = "/main")
public class MainController {
    @Autowired
    private CurrencyService currencyService;

    @GetMapping
    public ResponseEntity showGif(@RequestParam("code") String code) throws URISyntaxException {
        URI uri = new URI(currencyService.checkRatesAndGetGiphyLink(code));
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uri);
        return new ResponseEntity(headers, HttpStatus.SEE_OTHER);
    }
}
