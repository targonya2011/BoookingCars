package booking;


import example.BookingCars.com.example.BookingCars.booking.Booking;
import example.BookingCars.com.example.BookingCars.booking.BookingDAO;
import example.BookingCars.com.example.BookingCars.booking.BookingService;
import example.BookingCars.com.example.BookingCars.car.CarDataService;
import example.BookingCars.com.example.BookingCars.car.CarService;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookingServiceTest {

    private final CarDataService carDataService = new CarDataService();
    private final CarService carService = new CarService(carDataService);
    private final BookingDAO bookingDAO = new BookingDAO();
    private final BookingService bookingService = new BookingService(bookingDAO, carService);

    @Test
    void showActiveBookings() {
        List<Booking> collect = bookingService.getAllBooking()
                .stream().filter(Booking::isCancelled).collect(Collectors.toList());
        assertEquals(collect, bookingService.getAllBooking());
    }



}
