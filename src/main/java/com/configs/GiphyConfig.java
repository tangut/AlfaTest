package com.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GiphyConfig {
    @Value("$api.giphy.id")
    private String apiKeyId;

    @Value("$api.giphy.id")
    private String url;

    @Value("$api.giphy.rating")
    private String rating;

    public String getApiKeyId() {
        return apiKeyId;
    }

    public void setApiKeyId(String apiKeyId) {
        this.apiKeyId = apiKeyId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
