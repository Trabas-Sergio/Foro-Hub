package com.alura.foro.hub.domain.topic;

import jakarta.validation.constraints.NotBlank;

public record TopicDTO(
        @NotBlank
        String title,
        @NotBlank
        String message,
        @NotBlank
        String author,
        @NotBlank
        String course
) {
}
