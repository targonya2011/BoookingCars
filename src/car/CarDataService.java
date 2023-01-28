package car;

import java.util.Arrays;
import java.util.List;

public class CarDataService implements CarDAO {
    private static final List<Car> cars;

    public CarDataService() {
    }

    static {
        cars = Arrays.asList(new Car(Brand.AUDI, "5555KC1", 1992, 35.4, false, true),
            new Car(Brand.FORD, "3455BO1", 2022, 99.4, true, true),
            new Car(Brand.BMW, "5235TT6", 2009, 65.4, false, true),
            new Car(Brand.KIA, "2323KK9", 2014, 70.5, true, true));
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }
}