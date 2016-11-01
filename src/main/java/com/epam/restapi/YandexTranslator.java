package com.epam.restapi;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by OLEG on 29.07.2016.
 */

@PropertySource("classpath:app.properties")
public class YandexTranslator {

    private final Logger log = Logger.getLogger(YandexTranslator.class);

    @Value("${base.url}")
    private String baseUrl;

    @Value("${api.key}")
    private String apiKey;

    private RestTemplate restTemplate;

    @Autowired
    public YandexTranslator(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public TranslationResult translate(String lang, String text) {

        log.info("Thread=[" + Thread.currentThread().getId() + "] Calling YandexTranslator API with params lang=[" + lang + "], text=[" + text + "] ... ");

        UriComponents uriComponents = UriComponentsBuilder.fromUriString(baseUrl).
                queryParam("key", apiKey).
                queryParam("lang", lang).
                queryParam("text", text).build();

        ResponseEntity<TranslationResult> response = restTemplate.
                getForEntity(uriComponents.toUri(), TranslationResult.class);

        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response.getBody();
    }


}
