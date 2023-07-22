package com.epam.v2.populator;

import com.epam.v2.dto.EventFullDto;
import com.epam.v2.model.EventFull;

public class EventPopulator {
    public void populateEventFull(EventFull event, EventFullDto dto) {
        dto.setTitle(event.getTitle());
        dto.setSpeaker(event.getSpeaker());
        dto.setEventType(event.getEventType());
        dto.setDateTime(event.getDateTime());
        dto.setPlace(event.getEventPlace());
    }
}
