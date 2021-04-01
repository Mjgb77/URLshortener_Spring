package com.mjgonzales.urlshortener.shortener;

public class Shortener {
    private StorageManager storage;
    private ShortenerEncoder shortenerEncoder;

    public Shortener(StorageManager storage, ShortenerEncoder shortenerEncoder) {
        this.storage = storage;
        this.shortenerEncoder = shortenerEncoder;
    }

    public String toShortURL(String originalURL) {
        int id = storage.hasURL(originalURL) ?
                storage.getID(originalURL) : storage.addURL(originalURL);
        return shortenerEncoder.idToShortURL(id);
    }

    public String toOriginalURL(String shortURL) {
        int id = shortenerEncoder.shortURLtoID(shortURL);
        return storage.hasID(id) ? storage.getFromID(id) : null;
    }

}
