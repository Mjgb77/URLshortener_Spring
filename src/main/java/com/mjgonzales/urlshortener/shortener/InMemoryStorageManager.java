package com.mjgonzales.urlshortener.shortener;

import java.util.HashMap;
import java.util.Optional;
import java.util.Vector;

public class InMemoryStorageManager implements StorageManager {
    private HashMap<String, Integer> idByURL;
    private Vector<String> URLs;

    public InMemoryStorageManager() {
        idByURL = new HashMap<>();
        URLs = new Vector<>();
    }

    @Override
    public boolean hasURL(String url) {
        return idByURL.containsKey(url);
    }

    @Override
    public Optional<Integer> getID(String url) {
        return Optional.ofNullable(idByURL.get(url));
    }

    @Override
    public int addURL(String url) {
        int newID = URLs.size();
        URLs.add(url);
        idByURL.put(url, newID);
        return newID;
    }

    @Override
    public boolean hasID(int id) {
        return 0 <= id && id < URLs.size();
    }

    @Override
    public Optional<String> getFromID(int id) {
        return Optional.of(URLs.elementAt(id));
    }
}
