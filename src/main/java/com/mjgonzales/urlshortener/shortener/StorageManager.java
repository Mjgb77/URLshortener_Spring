package com.mjgonzales.urlshortener.shortener;

interface StorageManager {

    boolean hasURL(String url);

    int getID(String url);

    int addURL(String url);

    boolean hasID(int id);

    String getFromID(int id);
}
