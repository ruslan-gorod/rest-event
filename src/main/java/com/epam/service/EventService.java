package com.epam.service;

import com.epam.dto.EventDto;

import java.util.List;

public interface EventService {

    EventDto createEvent(EventDto event);

    EventDto updateEvent(Long id, EventDto event);

    EventDto getEventById(Long id);

    EventDto deleteEvent(Long id);

    List<EventDto> getAllEvents();
    List<EventDto> getAllEventsByTitle(String title);
}
