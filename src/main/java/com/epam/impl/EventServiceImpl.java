package com.epam.impl;

import com.epam.dto.EventDto;
import com.epam.model.Event;
import com.epam.repository.EventRepository;
import com.epam.service.EventService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    private static final String EVENT_NOT_FOUND = "Event not found";

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EventRepository repository;


    @Override
    public EventDto createEvent(EventDto eventDto) {
        Event create = repository.save(mapToEntity(eventDto));
        return mapToDto(create);
    }

    @Override
    public EventDto updateEvent(Long id, EventDto eventDto) {
        Event event = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(EVENT_NOT_FOUND));
        event.setTitle(eventDto.getTitle());
        event.setPlace(eventDto.getPlace());
        event.setSpeaker(eventDto.getSpeaker());
        event.setEventType(eventDto.getEventType());
        event.setDateTime(eventDto.getDateTime());

        Event update = repository.save(event);
        return mapToDto(update);
    }

    @Override
    public EventDto getEventById(Long id) {
        Event event = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(EVENT_NOT_FOUND));
        return mapToDto(event);
    }

    @Override
    public EventDto deleteEvent(Long id) {
        Event event = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(EVENT_NOT_FOUND));
        repository.delete(event);
        return mapToDto(event);
    }

    @Override
    public List<EventDto> getAllEvents() {
        return repository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EventDto> getAllEventsByTitle(String title) {
        return repository.findByTitle(title);
    }

    private Event mapToEntity(EventDto eventDto) {
        return modelMapper.map(eventDto, Event.class);
    }

    private EventDto mapToDto(Event event) {
        return modelMapper.map(event, EventDto.class);
    }
}
