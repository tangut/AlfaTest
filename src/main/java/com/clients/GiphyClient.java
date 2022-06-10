package com.clients;

import com.dto.GiphyDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "giphy-client", url = "${api.giphy.url}")
@Component
public interface GiphyClient {
    @GetMapping()
    GiphyDto getGif(@RequestParam("api_key") String id,
                    @RequestParam("tag") String tag,
                    @RequestParam("rating") String rating);
}
