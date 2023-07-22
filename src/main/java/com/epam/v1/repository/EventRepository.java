package com.epam.v1.repository;

import com.epam.v1.dto.EventDto;
import com.epam.v1.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT e FROM Event e WHERE e.title = ?1")
    List<EventDto> findByTitle(String title);
}
