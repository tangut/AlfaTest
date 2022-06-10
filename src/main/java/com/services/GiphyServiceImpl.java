package com.services;

import com.clients.GiphyClient;
import com.configs.GiphyConfig;
import com.dto.GiphyDto;
import com.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GiphyServiceImpl implements GiphyService {
    @Autowired
    private GiphyConfig config;

    private final GiphyClient giphyClient;

    public GiphyServiceImpl(GiphyClient giphyClient) {
        this.giphyClient = giphyClient;
    }

    @Override
    public Gif getGif(String tag) {
        GiphyDto dto = giphyClient.getGif(config.getApiKeyId(), tag, config.getRating());
        return dto.getData();
    }
}
