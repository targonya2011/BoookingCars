package example.BookingCars;

import example.BookingCars.com.example.BookingCars.booking.Booking;
import example.BookingCars.com.example.BookingCars.booking.BookingDAO;
import example.BookingCars.com.example.BookingCars.booking.BookingService;
import example.BookingCars.com.example.BookingCars.car.Car;
import example.BookingCars.com.example.BookingCars.car.CarDataService;
import example.BookingCars.com.example.BookingCars.car.CarService;
import example.BookingCars.com.example.BookingCars.user.User;
import example.BookingCars.com.example.BookingCars.user.UserFakerDataAccessService;
import example.BookingCars.com.example.BookingCars.user.UserService;

import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        UserFakerDataAccessService userArrayDataAccessService = new UserFakerDataAccessService();
        UserService userService = new UserService(userArrayDataAccessService);
        CarDataService carDataService = new CarDataService();
        CarService carService = new CarService(carDataService);
        BookingDAO bookingDAO = new BookingDAO();
        BookingService bookingService = new BookingService(bookingDAO, carService);
        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            menu();
            choice = sc.next();
            switch (choice) {
                case "1" -> {
                    bookingCar(bookingService, carService, userService, bookingDAO);
                }
                case "2" -> {
                    showUsersWithCar(bookingService);
                }
                case "3" -> {
                    showAllBooking(bookingService);
                }
                case "4" -> {
                    showAvailableCars(carService);
                }
                case "5" -> {
                    showAvailableElectricCars(carService);
                }
                case "6" -> {
                    showAllUsers(userService);
                }
                case "7" -> {
                    System.out.println("program completed");
                }
                default -> {
                    System.out.println(choice + " is not a valid option :(");
                }
            }
        }
        while (!choice.equals("7"));
    }

    public static void menu() {
        System.out.println(
                "1 - Book Car\n" +
                        "2- View All User Booked Cars\n" +
                        "3 - View All Bookings\n" +
                        "4- View Available Cars\n" +
                        "5- View Available Electric Cars\n" +
                        "6- View all users\n" +
                        "7 - Exit\n");
    }

    public static void showAllUsers(UserService userService) {
        userService.seeUsers()
                .stream()
                .map(User::toString)
                .forEach(System.out::println);
        System.out.println();
    }

    public static void showAvailableCars(CarService carService) {
        carService.getAvailableCars().forEach(System.out::println);
        System.out.println();
    }

    public static void showAvailableElectricCars(CarService carService) {
        carService.getAllAvailableElectricCars().forEach(System.out::println);
        System.out.println();
    }

    public static void bookingCar(BookingService bookingService,
                                  CarService carService,
                                  UserService userService,
                                  BookingDAO bookingDAO) {
        showAvailableCars(carService);
        System.out.println("▶ Select a registration number: ");
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        Car car = carService.findCar(number);
        if (car == null) {
            System.out.println("▶ Select correct number");
        } else {
            showAllUsers(userService);
            System.out.println("▶ Select user id: ");
            UUID id = UUID.fromString(sc.nextLine());
            User user = userService.findUser(id);
            if (user == null) {
                System.out.println(" ▶ Select correct id");
            } else {
                String bookingId = bookingService.bookCar(user, car);
                bookingDAO.book(new Booking(bookingId,
                        user,
                        bookingService.generateBookingDate(),
                        true,
                        car));
                car.setAvailable(false);
                String confirmationMessage = """
                        🎉 Successfully booked car with reg number %s for user %s
                        Booking ref: %s
                        """.formatted(number, user, bookingId);
                System.out.println(confirmationMessage);
            }
        }
    }

    public static void showAllBooking(BookingService bookingService) {
        bookingService.showAllBookings().forEach(System.out::println);
        System.out.println();
    }

    public static void showUsersWithCar(BookingService bookingService) {
        try {
        if (bookingService.showAllBookings() == null) {
            System.out.println("We don't have any bookings :(");
        }
        else {
            System.out.println("▶ Select user id: ");
            Scanner sc = new Scanner(System.in);
            UUID id = UUID.fromString(sc.nextLine());
            if (bookingService.getUsersWithCar(id) == null) {
                System.out.println("User doesn't have any bookings");
            } else {
                System.out.println("User with" + id + "have:");
                bookingService.getUsersWithCar(id).forEach(System.out::println);
            }
        }
            } catch (Exception e){
            System.out.println("Incorrect id :(");
        }
    }
}

