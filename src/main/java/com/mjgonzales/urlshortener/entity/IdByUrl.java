package com.mjgonzales.urlshortener.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class IdByUrl {
    @Id
    private String url;
    private int id;

    public IdByUrl() {
    }

    public IdByUrl(String url, int id) {
        this.url = url;
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
