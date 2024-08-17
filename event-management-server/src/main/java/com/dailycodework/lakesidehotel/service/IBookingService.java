package com.dailycodework.lakesidehotel.service;

import com.dailycodework.lakesidehotel.model.BookedEvent;

import java.util.List;

/**
 * @author Simpson Alfred
 */

public interface IBookingService {
    void cancelBooking(Long bookingId);

    List<BookedEvent> getAllBookingsByEventId(Long eventId);

    String saveBooking(Long eventId, BookedEvent bookingRequest);

    BookedEvent findByBookingConfirmationCode(String confirmationCode);

    List<BookedEvent> getAllBookings();

    List<BookedEvent> getBookingsByUserEmail(String email);
}
