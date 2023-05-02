package example.BookingCars.com.example.BookingCars.car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarService {
    private CarDataService carDataService;
    public CarService(CarDataService carDataService) {
        this.carDataService = carDataService;
    }

    public List<Car> getAllAvailableElectricCars() {
        List<Car> cars = getAvailableCars();
        if (cars.size() == 0) {
            return Collections.emptyList();
        }
        return cars.stream().filter(c -> c.isElectric()).collect(Collectors.toList());
    }
    public Car findCar(String regNumber) {
        List<Car> collect = seeCars()
                .stream()
                .filter(c -> c.getRegNumber()
                        .equals(regNumber)).collect(Collectors.toList());
        return collect == null ? null : collect.get(0);
    }
    public List <Car> getAvailableCars() {
        List <Car> allCars = seeCars();
        if (allCars.isEmpty()) {
            System.out.println("We don't have any cars :(");
            return Collections.emptyList();
        }
        List<Car> collect = allCars.stream()
                .filter(Car::isAvailable)
                .collect(Collectors.toList());
        if (collect == null) {
            System.out.println("We don't have any electric cars :(");
            return Collections.emptyList();
        } else return collect;
    }

    public List<Car> seeCars() {
        return this.carDataService.getCars();
    }
}