package org.acme.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

public class Message extends PanacheEntity {

    private Long id;
    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
