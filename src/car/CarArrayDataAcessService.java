package car;

public class CarArrayDataAcessService implements CarDAO {
    private static final Car[] cars;

    public CarArrayDataAcessService() {
    }

    static {
        cars = new Car[]{new Car(Brand.AUDI, "5555KC1", 1992, 35.4, false, true), new Car(Brand.FORD, "3455BO1", 2022, 99.4, true, true), new Car(Brand.BMW, "5235TT6", 2009, 65.4, false, true), new Car(Brand.KIA, "2323KK9", 2014, 70.5, true, true)};
    }
    @Override
    public Car[] getCars() {
        return cars;
    }
}