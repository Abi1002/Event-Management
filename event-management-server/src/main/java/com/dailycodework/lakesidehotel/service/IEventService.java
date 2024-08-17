package com.dailycodework.lakesidehotel.service;

import com.dailycodework.lakesidehotel.model.Event;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface IEventService {
    Event addNewEvent(MultipartFile photo, String eventType, BigDecimal eventPrice) throws SQLException, IOException;

    List<String> getAllEventTypes();

    List<Event> getAllEvents();

    byte[] getEventPhotoByEventId(Long eventId) throws SQLException;

    void deleteEvent(Long eventId);

    Event updateEvent(Long eventId, String eventType, BigDecimal eventPrice, byte[] photoBytes);

    Optional<Event> getEventById(Long eventId);

    List<Event> getAvailableEvents(LocalDate checkInDate, LocalDate checkOutDate, String eventType);
}
