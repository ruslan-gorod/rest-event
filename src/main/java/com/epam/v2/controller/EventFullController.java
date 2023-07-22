package com.epam.v2.controller;

import com.epam.v2.dto.EventFullDto;
import com.epam.v2.service.EventFullServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v2/event")
@RequiredArgsConstructor
public class EventFullController {

    private EventFullServiceImpl service;

    @GetMapping("/list")
    public ResponseEntity<List<EventFullDto>> getAllEvents() {
        return new ResponseEntity<>(service.getAllEvents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventFullDto> getEventById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getEventById(id), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<EventFullDto> createEvent(@RequestBody EventFullDto EventFullDto) {
        return new ResponseEntity<>(service.createEvent(EventFullDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EventFullDto> removeEvent(@PathVariable Long id) {
        return new ResponseEntity<>(service.deleteEvent(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventFullDto> updateEvent(@RequestBody EventFullDto event, @PathVariable Long id) {
        return new ResponseEntity<>(service.updateEvent(id, event), HttpStatus.OK);
    }
}
