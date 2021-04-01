package com.mjgonzales.urlshortener.controller;

import com.mjgonzales.urlshortener.repository.IdByUrlRepository;
import com.mjgonzales.urlshortener.repository.UrlByIdRepository;
import com.mjgonzales.urlshortener.shortener.H2StorageManager;
import com.mjgonzales.urlshortener.shortener.Shortener;
import com.mjgonzales.urlshortener.shortener.ShortenerEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private Shortener shortener;

    @Autowired
    public HomeController(UrlByIdRepository urlByIdRepository, IdByUrlRepository idByUrlRepository) {
        H2StorageManager storage = new H2StorageManager(urlByIdRepository, idByUrlRepository);
        ShortenerEncoder shortenerEncoder = new ShortenerEncoder(ALPHABET);
        this.shortener = new Shortener(storage, shortenerEncoder);
    }

    @PostMapping("/shorten")
    public String shortenURL(@RequestParam(value = "url") String url) {
        return "Your shortened URL is: " + shortener.toShortURL(url);
    }

    @GetMapping("/expand")
    public String expandURL(@RequestParam(value = "url") String url) {
        String originalURL = shortener.toOriginalURL(url);

        if (originalURL == null) return "You haven't shortened that url before";
        else return "Your original URL is: " + originalURL;
    }
}
