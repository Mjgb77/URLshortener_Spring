package com.mjgonzales.urlshortener.shortener;

import com.mjgonzales.urlshortener.entity.IdByUrl;
import com.mjgonzales.urlshortener.entity.UrlById;
import com.mjgonzales.urlshortener.repository.IdByUrlRepository;
import com.mjgonzales.urlshortener.repository.UrlByIdRepository;

import java.util.Optional;

public class H2StorageManager implements StorageManager {
    private final UrlByIdRepository urlByIdRepository;
    private final IdByUrlRepository idByUrlRepository;

    public H2StorageManager(UrlByIdRepository urlByIdRepository, IdByUrlRepository idByUrlRepository) {
        this.urlByIdRepository = urlByIdRepository;
        this.idByUrlRepository = idByUrlRepository;
    }

    @Override
    public boolean hasURL(String url) {
        return idByUrlRepository.existsById(url);
    }

    @Override
    public int getID(String url) {
        Optional<IdByUrl> res = idByUrlRepository.findById(url);
        return res.map(IdByUrl::getId).orElse(-1);
    }

    @Override
    public int addURL(String url) {
        UrlById res = urlByIdRepository.save(new UrlById(url));
        idByUrlRepository.save(new IdByUrl(res.getUrl(), res.getId()));
        return res.getId();
    }

    @Override
    public boolean hasID(int id) {
        return urlByIdRepository.existsById(id);
    }

    @Override
    public String getFromID(int id) {
        Optional<UrlById> res = urlByIdRepository.findById(id);
        return res.map(UrlById::getUrl).orElse(null);
    }
}
