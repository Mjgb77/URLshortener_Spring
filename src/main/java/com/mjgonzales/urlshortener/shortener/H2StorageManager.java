package com.mjgonzales.urlshortener.shortener;

import com.mjgonzales.urlshortener.entity.Url;
import com.mjgonzales.urlshortener.repository.UrlRepository;

import java.util.Optional;

public class H2StorageManager implements StorageManager {
    private final UrlRepository urlRepository;

    public H2StorageManager(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    public boolean hasURL(String url) {
        return urlRepository.findByUrl(url).isPresent();
    }

    @Override
    public Optional<Integer> getID(String url) {
        Optional<Url> res = urlRepository.findByUrl(url);
        return res.map(Url::getId);
    }

    @Override
    public int addURL(String url) {
        Url res = urlRepository.save(new Url(url));
        return res.getId();
    }

    @Override
    public boolean hasID(int id) {
        return urlRepository.existsById(id);
    }

    @Override
    public Optional<String> getFromID(int id) {
        Optional<Url> res = urlRepository.findById(id);
        return res.map(Url::getUrl);
    }
}
