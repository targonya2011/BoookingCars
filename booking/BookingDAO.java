package booking;

public class BookingDAO {
    private static Booking[] bookings;
    private static int index = 0;
    private static int CAPACITY = 3;

    public BookingDAO() {
    }

    public void saveBooking(Booking booking) {
        if (index >= CAPACITY) {
            this.resize(CAPACITY + 1);
        }

        bookings[index] = booking;
        ++index;
    }

    public void resize(int bigIndex) {
        CAPACITY = bigIndex;
        Booking[] bigBookings = new Booking[CAPACITY];

        for(int i = 0; i < index; ++i) {
            bigBookings[i] = bookings[i];
        }

        bookings = bigBookings;
    }

    public Booking[] selectAllBookings() {
        return bookings;
    }

    static {
        bookings = new Booking[CAPACITY];
    }
}
