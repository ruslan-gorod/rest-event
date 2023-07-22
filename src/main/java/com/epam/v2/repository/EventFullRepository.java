package com.epam.v2.repository;

import com.epam.v2.dto.EventFullDto;
import com.epam.v2.model.EventFull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventFullRepository extends JpaRepository<EventFull, Long> {

    @Query("SELECT e FROM Event e WHERE e.title = ?1")
    List<EventFullDto> findByTitle(String title);
}
