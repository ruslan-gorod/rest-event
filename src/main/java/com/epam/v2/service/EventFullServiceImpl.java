package com.epam.v2.service;

import com.epam.v1.service.EventService;
import com.epam.v2.converter.EventConverter;
import com.epam.v2.dto.EventFullDto;
import com.epam.v2.model.EventFull;
import com.epam.v2.populator.EventPopulator;
import com.epam.v2.repository.EventFullRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventFullServiceImpl implements EventService<EventFullDto> {

    private static final String EVENT_NOT_FOUND = "Event not found";
    private final EventConverter converter = new EventConverter();
    private final EventPopulator populator = new EventPopulator();
    @Autowired
    private EventFullRepository repository;

    @Override
    public EventFullDto createEvent(EventFullDto dto) {
        EventFull event = repository.save(converter.convertToEntity(dto));
        return converter.convertToDto(event);
    }

    @Override
    public EventFullDto updateEvent(Long id, EventFullDto dto) {
        EventFull eventFull = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(EVENT_NOT_FOUND));
        populator.populateEventFull(eventFull, dto);
        return converter.convertToDto(eventFull);
    }

    @Override
    public EventFullDto getEventById(Long id) {
        EventFull eventFull = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(EVENT_NOT_FOUND));
        return converter.convertToDto(eventFull);
    }

    @Override
    public EventFullDto deleteEvent(Long id) {
        EventFull eventFull = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(EVENT_NOT_FOUND));
        repository.delete(eventFull);
        return converter.convertToDto(eventFull);
    }

    @Override
    public List<EventFullDto> getAllEvents() {
        return repository.findAll().stream()
                .map(converter::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EventFullDto> getAllEventsByTitle(String title) {
        return repository.findByTitle(title);
    }
}
