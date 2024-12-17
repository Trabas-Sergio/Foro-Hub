package com.alura.foro.hub.domain.topic;

import java.time.LocalDateTime;

public record ResponseTopicDTO(
        Long id,
        String title,
        String message,
        LocalDateTime creationDate,
        Boolean status,
        String author,
        String course
) {
    public ResponseTopicDTO(Topic topic) {
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getCreationDate(), topic.getStatus(), topic.getAuthor(), topic.getCourse());
    }
}
