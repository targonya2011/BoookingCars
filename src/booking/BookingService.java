package booking;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class BookingService {
    BookingDAO bookingDAO = new BookingDAO();

    public BookingService(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }
    public BookingService() {
    }
    public List<Booking> showAllBookings() {
        List<Booking> allBooking = getAllBooking();
        if (allBooking.isEmpty()) {
            System.out.println("We don't have any bookings");
            return Collections.emptyList();
        }
        return allBooking;
    }
    public void book() {

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

    public List <Booking> getAllBooking() {
        return this.bookingDAO.selectAllBookings();
    }
}
