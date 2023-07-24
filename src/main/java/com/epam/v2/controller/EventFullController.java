package com.epam.v2.controller;

import com.epam.v2.dto.EventFullDto;
import com.epam.v2.service.EventFullServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private EventFullServiceImpl eventFullService;

    @GetMapping("/list")
    public ResponseEntity<List<EventFullDto>> getAllEvents() {
        return new ResponseEntity<>(eventFullService.getAllEvents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventFullDto> getEventById(@PathVariable Long id) {
        return new ResponseEntity<>(eventFullService.getEventById(id), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<EventFullDto> createEvent(@RequestBody EventFullDto EventFullDto) {
        return new ResponseEntity<>(eventFullService.createEvent(EventFullDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EventFullDto> removeEvent(@PathVariable Long id) {
        return new ResponseEntity<>(eventFullService.deleteEvent(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventFullDto> updateEvent(@RequestBody EventFullDto event, @PathVariable Long id) {
        return new ResponseEntity<>(eventFullService.updateEvent(id, event), HttpStatus.OK);
    }
}
