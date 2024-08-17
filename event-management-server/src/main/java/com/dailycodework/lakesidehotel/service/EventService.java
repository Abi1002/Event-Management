package com.dailycodework.lakesidehotel.service;

import com.dailycodework.lakesidehotel.exception.InternalServerException;
import com.dailycodework.lakesidehotel.exception.ResourceNotFoundException;
import com.dailycodework.lakesidehotel.model.Event;
import com.dailycodework.lakesidehotel.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class EventService implements IEventService {
    private final EventRepository eventRepository;
    @Override
    public Event addNewEvent(MultipartFile file, String eventType, BigDecimal eventPrice) throws SQLException, IOException {
        Event event = new Event();
        event.setEventType(eventType);
        event.setEventPrice(eventPrice);
        if (!file.isEmpty()){
            byte[] photoBytes = file.getBytes();
            Blob photoBlob = new SerialBlob(photoBytes);
            event.setPhoto(photoBlob);
        }
        return eventRepository.save(event);
    }

    @Override
    public List<String> getAllEventTypes() {
        return eventRepository.findDistinctEventTypes();
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public byte[] getEventPhotoByEventId(Long eventId) throws SQLException {
        Optional<Event> theEvent = eventRepository.findById(eventId);
        if(theEvent.isEmpty()){
            throw new ResourceNotFoundException("Sorry, Event not found!");
        }
        Blob photoBlob = theEvent.get().getPhoto();
        if(photoBlob != null){
            return photoBlob.getBytes(1, (int) photoBlob.length());
        }
        return null;
    }

    @Override
    public void deleteEvent(Long eventId) {
        Optional<Event> theEvent = eventRepository.findById(eventId);
        if(theEvent.isPresent()){
            eventRepository.deleteById(eventId);
        }
    }

    @Override
    public Event updateEvent(Long eventId, String eventType, BigDecimal eventPrice, byte[] photoBytes) {
        Event event = eventRepository.findById(eventId).get();
        if (eventType != null) event.setEventType(eventType);
        if (eventPrice != null) event.setEventPrice(eventPrice);
        if (photoBytes != null && photoBytes.length > 0) {
            try {
                event.setPhoto(new SerialBlob(photoBytes));
            } catch (SQLException ex) {
                throw new InternalServerException("Fail updating Event");
            }
        }
       return eventRepository.save(event);
    }

    @Override
    public Optional<Event> getEventById(Long eventId) {
        return Optional.of(eventRepository.findById(eventId).get());
    }

    @Override
    public List<Event> getAvailableEvents(LocalDate checkInDate, LocalDate checkOutDate, String eventType) {
        return eventRepository.findAvailableEventsByDatesAndType(checkInDate, checkOutDate, eventType);
    }
}
