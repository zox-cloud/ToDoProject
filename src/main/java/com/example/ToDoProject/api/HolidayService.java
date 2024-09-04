package com.example.ToDoProject.api;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class HolidayService {
    private final WebClient webClient = WebClient.create("https://date.nager.at/Api");

    public Mono<String> getHolidays(String countryCode, int year) {
        return webClient.get()
                .uri("/v2/PublicHolidays/{year}/{countryCode}", year, countryCode)
                .retrieve()
                .bodyToMono(String.class);
    }
}