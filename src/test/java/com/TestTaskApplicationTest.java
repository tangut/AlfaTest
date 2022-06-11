package com;

import com.controllers.MainController;
import com.services.CurrencyService;
import com.services.GiphyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestTaskApplicationTest {

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private GiphyService giphyService;

    @Autowired
    private MainController mainController;

    @Test
    public void testContextLoad() {
        Assertions.assertNotNull(currencyService);
        Assertions.assertNotNull(giphyService);
        Assertions.assertNotNull(mainController);
    }
}
