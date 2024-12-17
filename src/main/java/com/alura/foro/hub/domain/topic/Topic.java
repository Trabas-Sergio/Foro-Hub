package com.alura.foro.hub.domain.topic;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity(name = "Topic")
@Table(name = "topics")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private LocalDateTime creationDate;
    private Boolean status;
    private String author;
    private String course;

    public Topic(TopicDTO topicDTO) {
        this.title = topicDTO.title();
        this.message = topicDTO.message();
        this.creationDate = LocalDateTime.now();
        this.status = true;
        this.author = topicDTO.author();
        this.course = topicDTO.course();
    }

    public void update(UpdateTopicDTO updateTopic) {
        this.title = updateTopic.title();
        this.message = updateTopic.message();
        this.author = updateTopic.author();
        this.course = updateTopic.course();
    }
}
