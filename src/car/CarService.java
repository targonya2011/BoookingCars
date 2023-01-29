package car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        List<Car> electricCars = new ArrayList<>();
        for (Car car: cars) {
            if (car.isElectric()) {
                electricCars.add(car);
            }
        }
        return electricCars;
    }
    public Car findCar(String regNumber) {
        for (Car car : seeCars()) {
            if (car.getRegNumber().equals(regNumber)) {
                return car;
            }
        }
        return null;
    }
    public List <Car> getAvailableCars() {
        List <Car> allCars = seeCars();
        if (allCars.isEmpty()) {
            System.out.println("We don't have any cars :(");
            return Collections.emptyList();
        }
        List <Car> availableCars = new ArrayList<>();
        for (Car car : allCars) {
            if (car.isAvailable()) {
                availableCars.add(car);
            }
        }
        if (availableCars.isEmpty()) {
            System.out.println("We don't have any electric cars :(");
            return Collections.emptyList();
        }
        return availableCars;
    }

    public List<Car> seeCars() {
        return this.carDataService.getCars();
    }
}