package com.alura.foro.hub.topic;

import com.alura.foro.hub.domain.topic.Topic;

import java.time.LocalDateTime;

public record ListOfTopicsDTO(
        String title,
        String message,
        LocalDateTime creationDate,
        Boolean status,
        String author,
        String course
) {
    public ListOfTopicsDTO(Topic t) {
        this(t.getTitle(), t.getMessage(), t.getCreationDate(), t.getStatus(), t.getAuthor(), t.getCourse());
    }
}
