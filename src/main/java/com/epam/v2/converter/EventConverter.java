package com.epam.v2.converter;

import com.epam.v1.model.Event;
import com.epam.v2.dto.EventFullDto;
import com.epam.v2.model.EventFull;
import com.epam.v2.model.Place;

public class EventConverter {
    public EventFullDto convertToDto(EventFull event) {
        EventFullDto dto = new EventFullDto();
        dto.setTitle(event.getTitle());
        dto.setSpeaker(event.getSpeaker());
        dto.setEventType(event.getEventType());
        dto.setDateTime(event.getDateTime());
        dto.setPlace(event.getEventPlace());
        return dto;
    }

    public EventFull convertToEntity(EventFullDto dto) {
        EventFull event = new EventFull();
        event.setTitle(dto.getTitle());
        event.setSpeaker(dto.getSpeaker());
        event.setEventType(dto.getEventType());
        event.setDateTime(dto.getDateTime());
        event.setEventPlace(dto.getPlace());
        return event;
    }

    public EventFull convertEventToEventFull(Event event) {
        EventFull eventFull = new EventFull();
        eventFull.setTitle(event.getTitle());
        eventFull.setSpeaker(event.getSpeaker());
        eventFull.setEventType(event.getEventType());
        eventFull.setDateTime(event.getDateTime());
        eventFull.setEventPlace(getPlace(event));
        return eventFull;
    }

    public Event convertEventFullToEvent(EventFull eventFull) {
        Event event = new Event();
        event.setTitle(eventFull.getTitle());
        event.setSpeaker(eventFull.getSpeaker());
        event.setEventType(eventFull.getEventType());
        event.setDateTime(eventFull.getDateTime());
        event.setPlace(eventFull.getEventPlace().toString());
        return event;
    }

    private Place getPlace(Event event) {
        String[] placeData = event.getPlace().split(Place.COMMA_SEPARATOR);
        Place place = new Place();
        place.setZipCode(placeData[0]);
        place.setCity(placeData[1]);
        place.setStreet(placeData[2]);
        place.setBuilding(placeData[3]);
        return place;
    }
}
