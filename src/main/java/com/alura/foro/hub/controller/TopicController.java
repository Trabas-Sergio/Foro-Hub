package com.alura.foro.hub.controller;

import com.alura.foro.hub.domain.topic.*;
import com.alura.foro.hub.topic.ListOfTopicsDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private ITopicRepository topicRepository;

    @PostMapping
    public ResponseEntity<ResponseTopicDTO> register(@RequestBody @Valid TopicDTO topicDTO, UriComponentsBuilder uriComponentsBuilder) {
        Topic topic = topicRepository.save(new Topic(topicDTO));
        ResponseTopicDTO responseTopicDTO = new ResponseTopicDTO(
                topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getCreationDate(),
                topic.getStatus(),
                topic.getAuthor(),
                topic.getCourse());

        URI url = uriComponentsBuilder.path("/topic/{id}").buildAndExpand(topic.getId()).toUri();

        return ResponseEntity.created(url).body(responseTopicDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseTopicDTO> getTopic(@PathVariable Long id) {
        Topic topic = topicRepository.getReferenceById(id);
        ResponseTopicDTO responseTopic = new ResponseTopicDTO(topic);
        return ResponseEntity.ok(responseTopic);
    }

    @GetMapping
    public ResponseEntity<Page<ListOfTopicsDTO>> listTopics(@PageableDefault(size = 5) Pageable pageable) {
        return ResponseEntity.ok(topicRepository.findAll(pageable).map(ListOfTopicsDTO::new));
    }

    @GetMapping("/result10")
    public ResponseEntity<List<ListOfTopicsDTO>> getTop10ByCreationDate() {
        var top10 = topicRepository.findTop10ByOrderByCreationDateAsc().stream().map(ListOfTopicsDTO::new).toList();
        return ResponseEntity.ok(top10);
    }

    @GetMapping("/{course}/{year}")
    public ResponseEntity<List<ListOfTopicsDTO>> findByCourseAndYear(@PathVariable String course, @PathVariable String  year) {
        System.out.println(course);
        LocalDateTime startDate = LocalDateTime.of(Integer.parseInt(year), Month.JANUARY, 1, 0, 0, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(Integer.parseInt(year), Month.DECEMBER, 31, 23, 59, 59, 999999999);
        List<ListOfTopicsDTO> topicByCourseAndYear = topicRepository.findByCourseAndCreationDateBetween(course, startDate, endDate).stream().map(ListOfTopicsDTO::new).toList();
        return ResponseEntity.ok(topicByCourseAndYear);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity updateTopic(@PathVariable Long id, @RequestBody @Valid UpdateTopicDTO updateTopic) {
        Optional<Topic> searchTopic = topicRepository.findById(id);
        if (searchTopic.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Topic topic = searchTopic.get();

        return ResponseEntity.ok(new ResponseTopicDTO(topic));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteTopic(@PathVariable Long id) {
        Optional<Topic> searchTopic = topicRepository.findById(id);
        if (searchTopic.isPresent()) {
            topicRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
