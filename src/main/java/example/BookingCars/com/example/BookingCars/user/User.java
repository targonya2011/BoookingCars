package example.BookingCars.com.example.BookingCars.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

import static jakarta.persistence.GenerationType.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class User {

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



    private String name;
    private int age;
    private String surname;
    private UUID uId;

    public User(String name, String surname, int age, UUID uId) {
        this.name = name;
        this.age = age;
        this.surname = surname;
        this.uId = uId;
    }
}