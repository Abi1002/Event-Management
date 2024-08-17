package com.dailycodework.lakesidehotel.repository;

import com.dailycodework.lakesidehotel.model.BookedEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;



public interface BookingRepository extends JpaRepository<BookedEvent, Long> {

    List<BookedEvent> findByEventId(Long eventId);

 Optional<BookedEvent> findByBookingConfirmationCode(String confirmationCode);

    List<BookedEvent> findByGuestEmail(String email);
}
