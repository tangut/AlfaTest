package com.services;

import com.clients.GiphyClient;
import com.configs.GiphyConfig;
import com.model.Gif;
import com.model.dto.GiphyDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GiphyServiceTest {
    private GiphyClient giphyClient = Mockito.mock(GiphyClient.class);

    private GiphyService giphyService;

    private final String apiKeyId = "DT7fjqD0qZKJn1Hprb5l1H9bGoWPQfK8";
    private final String url = "https://api.giphy.com/v1/gifs/random";
    private final String rating = "g";

    @BeforeEach
    public void init() {
        GiphyConfig giphyConfig = new GiphyConfig();
        giphyConfig.setApiKeyId(apiKeyId);
        giphyConfig.setUrl(url);
        giphyConfig.setRating(rating);
        giphyService = new GiphyServiceImpl(giphyClient, giphyConfig);
    }

    @Test
    public void testGif() {
        Assertions.assertNotNull(giphyClient);
        Assertions.assertNotNull(giphyService);
        Gif gif = new Gif();
        gif.setUrl("some url");
        gif.setRating("g");
        gif.setTitle("some title");
        GiphyDto dto = new GiphyDto();
        dto.setData(gif);
        Mockito.when(giphyClient.getGif(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(dto);
        Gif returnGif = giphyService.getGif("some tag");
        Assertions.assertEquals(gif, returnGif);
    }
}
