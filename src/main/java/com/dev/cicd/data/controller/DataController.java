package com.dev.cicd.data.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/**
 * Controller class for handling data-related requests.
 */
@RestController
public final class DataController {

    /**
     * Endpoint for performing a health check.
     *
     * @return A string indicating the health status.
     */
    @GetMapping("/")
    public String healthCheck() {
        return "HEALTH CHECK OK!";
    }

    /**
     * Endpoint for retrieving the application version.
     *
     * @return A string indicating the application version.
     */
    @GetMapping("/version")
    public String version() {
        return "The actual version is 1.0.0";
    }

    /**
     *  Randomly generated nations.
     *
     * @return A JSON array containing nation details.
     */
    @GetMapping("/nations")
    public JsonNode getRandomNations() {
        var objectMapper = new ObjectMapper();
        var faker = new Faker(new Locale("en-US"));
        var nations = objectMapper.createArrayNode();
        final int numberOfNations = 10;
        for (var i = 0; i < numberOfNations; i++) {
            var nation = faker.nation();
            nations.add(objectMapper.createObjectNode()
                    .put("nationality", nation.nationality())
                    .put("capitalCity", nation.capitalCity())
                    .put("flag", nation.flag())
                    .put("language", nation.language()));
        }
        return nations;
    }

    /**
     * Randomly generated currencies.
     *
     * @return A JSON array containing currency details.
     */
    @GetMapping("/currencies")
    public JsonNode getRandomCurrencies() {
        var objectMapper = new ObjectMapper();
        var faker = new Faker(new Locale("en-US"));
        var currencies = objectMapper.createArrayNode();
        final int numberOfCurrencies = 20;
        for (var i = 0; i < numberOfCurrencies; i++) {
            var currency = faker.currency();
            currencies.add(objectMapper.createObjectNode()
                    .put("name", currency.name())
                    .put("code", currency.code()));
        }
        return currencies;
    }
}
