package com.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenExchangeConfig {
    @Value("${api.openexchange.id}")
    private String apiKeyId;

    @Value("${api.openexchange.url}")
    private String url;

    @Value("${api.currency.code}")
    private String code;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
