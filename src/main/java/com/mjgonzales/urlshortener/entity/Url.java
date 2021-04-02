package com.mjgonzales.urlshortener.entity;

import javax.persistence.*;

@Entity
@Table(indexes = {@Index(columnList = "url")})
public class Url {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(length = 1024)
    private String url;

    public Url() {
    }

    public Url(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
