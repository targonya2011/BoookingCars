package car;

import java.util.Objects;

public class Car {
    private String regNumber;
    private int productionYear;
    private double rentalPricePerDay;
    private boolean isElectric;
    private Brand brand;
    private boolean available;

    public Car(Brand brand, String regNumber, int productionYear, double rentalPricePerDay, boolean isElectric, boolean available) {
        this.regNumber = regNumber;
        this.productionYear = productionYear;
        this.rentalPricePerDay = rentalPricePerDay;
        this.isElectric = isElectric;
        this.brand = brand;
        this.available = available;
    }

    public String getRegNumber() {
        return this.regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public int getProductionYear() {
        return this.productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public double getRentalPricePerDay() {
        return this.rentalPricePerDay;
    }

    public void setRentalPricePerDay(double rentalPricePerDay) {
        this.rentalPricePerDay = rentalPricePerDay;
    }

    public boolean isElectric() {
        return this.isElectric;
    }

    public void setElectric(boolean electric) {
        this.isElectric = electric;
    }

    public Brand getBrand() {
        return this.brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Car car = (Car)o;
            return this.productionYear == car.productionYear && Double.compare(car.rentalPricePerDay, this.rentalPricePerDay) == 0 && this.isElectric == car.isElectric && this.available == car.available && Objects.equals(this.regNumber, car.regNumber) && this.brand == car.brand;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.regNumber, this.productionYear, this.rentalPricePerDay, this.isElectric, this.brand, this.available});
    }

    public String toString() {
        return "Car{regNumber='" + this.regNumber + "', productionYear=" + this.productionYear + ", rentalPricePerDay=" + this.rentalPricePerDay + ", isElectric=" + this.isElectric + ", brand=" + this.brand + "}";
    }
}

