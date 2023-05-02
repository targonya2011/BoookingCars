package example.BookingCars.com.example.BookingCars.car;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Car {

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

    @Enumerated(EnumType.STRING)
    private Brand brand;
    private String regNumber;
    private int productionYear;
    private double rentalPricePerDay;
    private boolean isElectric;
    private boolean available;


    public Car(Brand brand, String regNumber, int productionYear, double rentalPricePerDay, boolean isElectric, boolean available) {
        this.brand = brand;
        this.regNumber = regNumber;
        this.productionYear = productionYear;
        this.rentalPricePerDay = rentalPricePerDay;
        this.isElectric = isElectric;
        this.available = available;
    }
}

