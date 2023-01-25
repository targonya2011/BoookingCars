package car;

public class CarService {
    private CarArrayDataAcessService carArrayDataAcessService = new CarArrayDataAcessService();

    public Car findCar(String regNumber) {
        Car car = null;

        for(int i = 0; i < this.seeCars().length; ++i) {
            if (this.seeCars()[i].getRegNumber().equals(regNumber)) {
                car = this.seeCars()[i];
            }
        }
        return car;
    }

    public CarService() {
    }

    public Car[] seeCars() {
        return this.carArrayDataAcessService.getCars();
    }
}