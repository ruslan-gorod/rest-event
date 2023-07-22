package com.epam.v1.service;

import java.util.List;

public interface EventService<T> {

    T createEvent(T event);

    T updateEvent(Long id, T event);

    T getEventById(Long id);

    T deleteEvent(Long id);

    List<T> getAllEvents();

    List<T> getAllEventsByTitle(String title);
}
