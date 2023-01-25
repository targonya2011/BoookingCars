package booking;

import java.time.LocalDateTime;
import java.util.UUID;

public class BookingService {
    BookingDAO bookingDAO;

    public BookingService(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    public void registerNewBooking(Booking booking) {
        if (booking == null) {
            throw new IllegalArgumentException("Is not available booking :(");
        } else {
            this.bookingDAO.saveBooking(booking);
        }
    }

    public String generateBookingRef() {
        UUID uuid = UUID.randomUUID();
        String bookingRef = uuid.toString();
        return bookingRef;
    }

    public LocalDateTime generateBookingDate() {
        LocalDateTime bookingDate = LocalDateTime.now();
        return bookingDate;
    }

    public Booking[] showAllBooking() {
        return this.bookingDAO.selectAllBookings();
    }
}
