package car;

import example.BookingCars.com.example.BookingCars.car.Car;
import example.BookingCars.com.example.BookingCars.car.CarDataService;
import example.BookingCars.com.example.BookingCars.car.CarService;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarServiceTest {
    private  final CarDataService carDataService = new CarDataService();
    private final CarService carService = new CarService(carDataService);
    private final List<Car> cars = carService.seeCars();

    @Test
    void findingCar() {
        String number = "5235TT6";
        assertEquals(cars.get(2), carService.findCar(number));
    }
    @Test
    void showAvalaibleCars() {
        assertEquals(cars, carService.getAvailableCars());
    }
    @Test
    void showElectricAvalaibleCars() {
        List<Car> collect =
                cars.stream().filter(Car::isElectric).collect(Collectors.toList());
        assertEquals(collect, carService.getAllAvailableElectricCars());
    }

}
