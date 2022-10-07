package org.acme.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends PanacheEntity {

    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // name = nome da coluna que irá armazenar a chave estrangeira
    // na tabela Message (solução a partir da JPA 2)
    @JoinColumn(name = "user_id")
    private List<Message> messages;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Channel> channels;

    public User() {
        this.messages = new ArrayList<>();
        this.channels = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public void addMessage(Message message) {
        this.messages.add(message);
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

    public void addChannel(Channel channel) {
        this.channels.add(channel);
    }


}