package com.mjgonzales.urlshortener.shortener;

import java.util.Optional;

interface StorageManager {

    boolean hasURL(String url);

    Optional<Integer> getID(String url);

    int addURL(String url);

    boolean hasID(int id);

    Optional<String> getFromID(int id);
}
