package com.mjgonzales.urlshortener.repository;

import com.mjgonzales.urlshortener.entity.Url;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UrlRepository extends CrudRepository<Url, Integer> {
    @Query("select u from Url u where u.url = ?1")
    Optional<Url> findByUrl(String originalUrl);
}
