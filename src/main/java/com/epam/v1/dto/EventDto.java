package com.epam.v1.dto;

import com.epam.v1.model.EventType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDto extends RepresentationModel<EventDto> {

    private Long id;
    private String title;
    private String place;
    private String speaker;
    private EventType eventType;
    private LocalDateTime dateTime;
}
