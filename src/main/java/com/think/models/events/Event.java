package com.think.models.events;

import lombok.Data;

import java.util.List;

@Data
public class Event {

    private String type;
    private String subject;
    private String description;
    private String process;
    private String area;
    private List<User> users;
    private List<Comment> comments;

}
