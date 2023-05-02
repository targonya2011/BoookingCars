package example.BookingCars.com.example.BookingCars.booking;

import java.util.ArrayList;
import java.util.List;

public class BookingDAO {
    private static List <Booking> bookings = new ArrayList<>();

    public BookingDAO() {
    }

    public void book (Booking booking) {
        bookings.add(booking);
    }

    public List <Booking> selectAllBookings() {
        return bookings;
    }
}
