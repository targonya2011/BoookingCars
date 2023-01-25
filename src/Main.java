import booking.Booking;
import booking.BookingDAO;
import booking.BookingService;
import car.Car;
import car.CarService;
import user.User;
import user.UserArrayDataAccessService;
import user.UserService;

import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        startingProgram();

    }
    public static void menu() {
        System.out.println(
                        "1 - Book Car\n" +
                        "2️- View All User Booked Cars\n" +
                        "3 - View All Bookings\n" +
                        "4️- View Available Cars\n" +
                        "5️- View Available Electric Cars\n" +
                        "6️- View all users\n" +
                        "7 - Exit\n");
    }
    public static void showAllUsers() {
        UserArrayDataAccessService userArrayDataAccessService = new UserArrayDataAccessService();
        UserService userService = new UserService(userArrayDataAccessService);
        for(User user : userService.seeUsers()) {
            System.out.println(user.toString());
        }
        System.out.println();
    }
    public static void showAvailableCars() {
        CarService carService = new CarService();
        for (Car car : carService.seeCars()) {
            if (car.isAvailable()) {
                System.out.println(car);
            }
        }
        System.out.println();
    }
    public static void showAvailableElectricCars() {
        CarService carService = new CarService();
        for (Car car : carService.seeCars()) {
            if (car.isElectric() && car.isAvailable()) {
                System.out.println(car);
            }
        }
        System.out.println();
    }
    public static void bookingCar() {
        BookingDAO bookingDAO = new BookingDAO();
        BookingService bookingService = new BookingService(bookingDAO);
        UserArrayDataAccessService userArrayDataAccessService = new UserArrayDataAccessService();
        UserService userService = new UserService(userArrayDataAccessService);
        CarService carService = new CarService();

        showAvailableCars();
        Scanner sc = new Scanner(System.in);

        System.out.println("▶ Select a registration number: ");
        String number = sc.nextLine();
        Car car = carService.findCar(number);
        showAllUsers();

        System.out.println("▶ Select user id: ");
        UUID id = UUID.fromString(sc.nextLine());
        User user = userService.findUser(id);
        System.out.println();

        Booking booking = new Booking(bookingService.generateBookingRef(),
                user,
                bookingService.generateBookingDate(),
                true);
        car.setAvailable(false);
        booking.setCancelled(true);
        bookingService.registerNewBooking(booking);

        System.out.println(booking);
        System.out.println();
    }
    public static void showAllBooking() {
        BookingDAO bookingDAO = new BookingDAO();
        BookingService bookingService = new BookingService(bookingDAO);
        for (int i = 0; i < bookingService.showAllBooking().length; i++) {
            if (bookingService.showAllBooking()[i] != null) {
                System.out.println(bookingService.showAllBooking()[i]);
            } else {
                System.out.println("We don't have any bookings");
                System.out.println();
                break;
            }
        }
    }
    public static void showAllUsersWithCar() {
        BookingDAO bookingDAO = new BookingDAO();
        BookingService bookingService = new BookingService(bookingDAO);
        for (int i = 0; i < bookingService.showAllBooking().length; i++) {
            if (bookingService.showAllBooking()[i] != null) {
                System.out.println(bookingService.showAllBooking()[i].getUser().getName() + " " +
                        bookingService.showAllBooking()[i].getUser().getSurname());
            } else {
                System.out.println("We don't have any users with bookings");
                System.out.println();
                break;
            }
        }
        System.out.println();
    }
    public static void startingProgram() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            menu();
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    bookingCar();
                }
                case 2 -> {
                    showAllUsersWithCar();
                }
                case 3 -> {
                    showAllBooking();
                }
                case 4 -> {
                    showAvailableCars();
                }
                case 5 -> {
                    showAvailableElectricCars();
                }
                case 6 -> {
                    showAllUsers();
                }
                case 7 -> {
                    System.out.println("program completed");
                }
                default -> {
                    System.out.println(choice + " is not a valid option :(");
                }
            }
        }
        while (choice != 7);
    }
}

