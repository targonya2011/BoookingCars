package example.BookingCars.com.example.BookingCars.booking;

import java.time.LocalDateTime;

import example.BookingCars.com.example.BookingCars.car.Car;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import example.BookingCars.com.example.BookingCars.user.User;

import static jakarta.persistence.GenerationType.SEQUENCE;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "book_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;


    private String bookingId;

    @ManyToOne
    private User user;

    private LocalDateTime bookingTime;
    private boolean isCancelled = false;

    @ManyToOne
    private Car car;

    public Booking(String bookingId, User user, LocalDateTime bookingTime, boolean isCancelled, Car car) {
        this.bookingId = bookingId;
        this.user = user;
        this.bookingTime = bookingTime;
        this.isCancelled = isCancelled;
        this.car = car;
    }
}
