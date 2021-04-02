package com.mjgonzales.urlshortener.shortener;

import java.util.Optional;

public class Shortener {
    private StorageManager storage;
    private ShortenerEncoder shortenerEncoder;

    public Shortener(StorageManager storage, ShortenerEncoder shortenerEncoder) {
        this.storage = storage;
        this.shortenerEncoder = shortenerEncoder;
    }

    public String toShortURL(String originalURL) {
        int id = storage.getID(originalURL).orElseGet(() -> storage.addURL(originalURL));
        return shortenerEncoder.idToShortURL(id);
    }

    public Optional<String> toOriginalURL(String shortURL) {
        int id = shortenerEncoder.shortURLtoID(shortURL);
        return storage.getFromID(id);
    }

}
