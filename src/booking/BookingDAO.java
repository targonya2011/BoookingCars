package booking;

import java.util.ArrayList;
import java.util.List;

public class BookingDAO {
    private static List <Booking> bookings = new ArrayList<>();

    public BookingDAO() {
    }

    public List <Booking> selectAllBookings() {
        return bookings;
    }
}
