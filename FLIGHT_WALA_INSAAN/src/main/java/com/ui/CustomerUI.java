package com.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.entity.Customer;
import com.service.CustomerService;

public class CustomerUI {
    private CustomerService customerService;

    public CustomerUI(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Search Flights");
            System.out.println("4. Book Flight");
            System.out.println("5. View Bookings");
            System.out.println("6. Cancel Booking");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    registerCustomer(scanner);
                    break;
                case 2:
                    loginCustomer(scanner);
                    break;
                case 3:
                    searchFlights(scanner);
                    break;
                case 4:
                    bookFlight(scanner);
                    break;
                case 5:
                    viewBookings(scanner);
                    break;
                case 6:
                    cancelBooking(scanner);
                    break;
                case 0:
                    System.out.println("Exiting Customer Menu...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private void registerCustomer(Scanner scanner) {
        System.out.println("\n--- Customer Registration ---");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        boolean isRegistered = customerService.registerCustomer(username, password);
        if (isRegistered) {
            System.out.println("Registration successful! You can now log in.");
        } else {
            System.out.println("Username already exists. Please choose a different username.");
        }
    }

    private void loginCustomer(Scanner scanner) {
        System.out.println("\n--- Customer Login ---");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Customer customer = customerService.loginCustomer(username, password);
        if (customer != null) {
            System.out.println("Welcome, " + customer.getUsername() + "!");
            // Perform additional operations as per the logged-in customer
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }

    private void searchFlights(Scanner scanner) {
        System.out.println("\n--- Flight Search ---");
        // Implement logic to search for flights based on user input
        // For example:
        System.out.print("Enter departure city: ");
        String departure = scanner.nextLine();
        System.out.print("Enter arrival city: ");
        String arrival = scanner.nextLine();
        System.out.print("Enter date (yyyy-MM-dd): ");
        String dateString = scanner.nextLine();
        LocalDate date = LocalDate.parse(dateString);
        System.out.print("Enter passenger count: ");
        int passengerCount = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        List<Flight> flights = customerService.searchFlights(departure, arrival, date, passengerCount);
        // Display the search results
        // For example:
        System.out.println("Search results:");
        for (Flight flight : flights) {
            System.out.println("Flight ID: " + flight.getId());
            System.out.println("Departure: " + flight.getDeparture());
            System.out.println("Arrival: " + flight.getArrival());
            System.out.println("Date: " + flight.getDate());
            System.out.println("Price: " + flight.getPrice());
            System.out.println("Available Seats: " + flight.getAvailableSeats());
            System.out.println("-----------------------");
        }
    }

    private void bookFlight(Scanner scanner) {
        System.out.println("\n--- Flight Booking ---");
        // Implement logic to book a flight based on user input
        // For example:
        System.out.print("Enter flight ID: ");
        long flightId = scanner.nextLong();
        System.out.print("Enter passenger count: ");
        int passengerCount = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String customer = ""; // Get the logged-in customer from previous login step
        Flight flight = customerService.getFlightById(flightId);
        if (flight == null) {
            System.out.println("Invalid flight ID. Please try again.");
            return;
        }

        if (flight.getAvailableSeats() >= passengerCount) {
            // Create a new booking for the customer
            Booking booking = new Booking();
            booking.setCustomer(customer);
            booking.setFlight(flight);
            booking.setPassengerCount(passengerCount);
            customerService.bookFlight(booking);

            System.out.println("Flight booking successful! Booking ID: " + booking.getId());
        } else {
            System.out.println("Not enough available seats for the selected flight.");
        }
    }

    private void viewBookings(Scanner scanner) {
        System.out.println("\n--- View Bookings ---");
        Customer customer = ...; // Get the logged-in customer from previous login step
        List<Booking> bookings = customerService.getCustomerBookings(customer.getId());

        if (bookings.isEmpty()) {
            System.out.println("You have no bookings yet.");
        } else {
            System.out.println("Your bookings:");
            for (Booking booking : bookings) {
                System.out.println("Booking ID: " + booking.getId());
                System.out.println("Flight: " + booking.getFlight().getDeparture() + " to " + booking.getFlight().getArrival());
                System.out.println("Date: " + booking.getFlight().getDate());
                System.out.println("Passenger Count: " + booking.getPassengerCount());
                System.out.println("-----------------------");
            }
        }
    }

    private void cancelBooking(Scanner scanner) {
        System.out.println("\n--- Cancel Booking ---");
        System.out.print("Enter booking ID to cancel: ");
        long bookingId = scanner.nextLong();
        scanner.nextLine(); // Consume the newline character

        Booking booking = customerService.getBookingById(bookingId);
        if (booking == null) {
            System.out.println("Invalid booking ID. Please try again.");
            return;
        }

        // Perform the cancellation logic
        // For example:
        customerService.cancelBooking(booking);
        System.out.println("Booking with ID " + booking.getId() + " has been canceled.");
    }
}
