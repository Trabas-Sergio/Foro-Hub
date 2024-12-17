package com.alura.foro.hub.domain.topic;

import com.alura.foro.hub.topic.ListOfTopicsDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public interface ITopicRepository extends JpaRepository<Topic, Long> {
    List<Topic> findTop10ByOrderByCreationDateAsc();


    List<Topic> findByCourseAndCreationDateBetween(String course, LocalDateTime startDate, LocalDateTime endDate);
}
