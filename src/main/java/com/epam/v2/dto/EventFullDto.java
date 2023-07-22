package com.epam.v2.dto;

import com.epam.v1.model.EventType;
import com.epam.v2.model.Place;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventFullDto {
    private String title;
    private Place place;
    private String speaker;
    private EventType eventType;
    private LocalDateTime dateTime;
}
