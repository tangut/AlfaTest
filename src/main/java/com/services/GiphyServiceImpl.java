package com.services;

import com.clients.GiphyClient;
import com.configs.GiphyConfig;
import com.model.dto.GiphyDto;
import com.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GiphyServiceImpl implements GiphyService {
    @Autowired
    private final GiphyConfig config;

    private final GiphyClient giphyClient;

    public GiphyServiceImpl(final GiphyClient giphyClient,
                            final GiphyConfig config) {
        this.giphyClient = giphyClient;
        this.config = config;
    }

    @Override
    public Gif getGif(String tag) {
        GiphyDto dto = giphyClient.getGif(config.getApiKeyId(), tag, config.getRating());
        return dto.getData();
    }
}
