package com.dailycodework.lakesidehotel.repository;

import com.dailycodework.lakesidehotel.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;



public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT DISTINCT r.eventType FROM Event r")
    List<String> findDistinctEventTypes();

    @Query(" SELECT r FROM Event r " +
            " WHERE r.eventType LIKE %:eventType% " +
            " AND r.id NOT IN (" +
            "  SELECT br.event.id FROM BookedEvent br " +
            "  WHERE ((br.checkInDate <= :checkOutDate) AND (br.checkOutDate >= :checkInDate))" +
            ")")

    List<Event> findAvailableEventsByDatesAndType(LocalDate checkInDate, LocalDate checkOutDate, String eventType);
}

