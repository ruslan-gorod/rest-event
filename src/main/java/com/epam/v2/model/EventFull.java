package com.epam.v2.model;

import com.epam.v1.model.EventType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "events")
public class EventFull {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "speaker")
    private String speaker;

    @Enumerated(EnumType.STRING)
    @Column(name = "eventType")
    private EventType eventType;

    @Column(name = "date")
    private LocalDateTime dateTime;

    @OneToOne
    @JoinColumn(name = "event_id")
    private Place eventPlace;
}
