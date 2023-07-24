package com.epam.v1.controller;

import com.epam.v1.dto.EventDto;
import com.epam.v1.impl.EventServiceImpl;
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
@RequestMapping("api/v1/event")
@Deprecated
public class EventServiceController {

    @Autowired
    private EventServiceImpl service;

    @GetMapping("/list")
    public ResponseEntity<List<EventDto>> getAllEvents() {
        return new ResponseEntity<>(service.getAllEvents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDto> getEventById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getEventById(id), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<EventDto> createEvent(@RequestBody EventDto eventDto) {
        return new ResponseEntity<>(service.createEvent(eventDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EventDto> removeEvent(@PathVariable Long id) {
        return new ResponseEntity<>(service.deleteEvent(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventDto> updateEvent(@RequestBody EventDto event, @PathVariable Long id) {
        return new ResponseEntity<>(service.updateEvent(id, event), HttpStatus.OK);
    }
}
