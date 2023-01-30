package booking;

import car.Car;
import car.CarService;
import user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookingService {
    private final BookingDAO bookingDAO;
    private final CarService carService;

    public BookingService(BookingDAO bookingDAO, CarService carService) {
        this.bookingDAO = bookingDAO;
        this.carService = carService;
    }
    public List<Booking> showAllBookings() {
        List<Booking> allBooking = getAllBooking();
        if (allBooking.isEmpty()) {
            System.out.println("We don't have any bookings");
            return Collections.emptyList();
        }
        return allBooking;
    }

    public String bookCar(User user, Car car) {
        List <Car> availableCars = carService.getAvailableCars();
        if (availableCars.isEmpty()) {
            throw new IllegalStateException("No car available for renting");
        }
       return generateBookingRef();
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
    public List<Booking> getUsersWithCar(UUID id) {
        return getAllBooking()
                .stream()
                .filter(b -> b.getUser().getId().equals(id))
                .collect(Collectors.toList());
    }


}
