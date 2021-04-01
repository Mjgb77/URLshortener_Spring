package com.mjgonzales.urlshortener.repository;

import com.mjgonzales.urlshortener.entity.IdByUrl;
import org.springframework.data.repository.CrudRepository;

public interface IdByUrlRepository extends CrudRepository<IdByUrl, String> {
}
