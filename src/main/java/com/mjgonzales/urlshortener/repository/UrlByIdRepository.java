package com.mjgonzales.urlshortener.repository;

import com.mjgonzales.urlshortener.entity.UrlById;
import org.springframework.data.repository.CrudRepository;

public interface UrlByIdRepository extends CrudRepository<UrlById, Integer> {

}
