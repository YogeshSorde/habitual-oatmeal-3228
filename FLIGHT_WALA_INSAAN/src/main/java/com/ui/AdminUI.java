package com.ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import com.dao.Flight;
import com.entity.Admin;
import com.service.AdminService;

public class AdminUI {
    private AdminService adminService;
    private Scanner scanner;

    public AdminUI(AdminService adminService) {
        this.adminService = adminService;
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("------- Admin Menu -------");
            System.out.println("1. Register New Admin");
            System.out.println("2. Login");
            System.out.println("3. Add New Flight");
            System.out.println("4. Update Flight Information");
            System.out.println("5. Remove Flight");
            System.out.println("6. Generate Reports");
            System.out.println("7. Logout");
            System.out.println("--------------------------");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    registerAdmin();
                    break;
                case 2:
                    loginAdmin();
                    break;
                case 3:
                    addNewFlight();
                    break;
                case 4:
                    updateFlightInformation();
                    break;
                case 5:
                    removeFlight();
                    break;
                case 6:
                    generateReports();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void registerAdmin() {
        System.out.println("------- Register New Admin -------");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        boolean success = adminService.registerAdmin(username, password);
        if (success) {
            System.out.println("Admin registration successful!");
        } else {
            System.out.println("Admin registration failed. The username may already be taken.");
        }
    }

    private void loginAdmin() {
        System.out.println("------- Admin Login -------");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Admin admin = adminService.loginAdmin(username, password);
        if (admin != null) {
            System.out.println("Welcome, " + admin.getUsername() + "!");
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }
    }

    private void addNewFlight() {
        System.out.println("------- Add New Flight -------");
        System.out.print("Enter flight number: ");
        String flightNumber = scanner.nextLine();
        System.out.print("Enter departure city: ");
        String departureCity = scanner.nextLine();
        System.out.print("Enter arrival city: ");
        String arrivalCity = scanner.nextLine();
        System.out.print("Enter departure time (yyyy-MM-dd HH:mm): ");
        String departureTimeStr = scanner.nextLine();
        System.out.print("Enter arrival time (yyyy-MM-dd HH:mm): ");
        String arrivalTimeStr = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime departureTime = LocalDateTime.parse(departureTimeStr, formatter);
            LocalDateTime arrivalTime = LocalDateTime.parse(arrivalTimeStr, formatter);

            Flight newFlight = new Flight(flightNumber, departureCity, arrivalCity, departureTime, arrivalTime, price);
            adminService.addFlight(newFlight);
            System.out.println("New flight added successfully!");
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter dates in the format yyyy-MM-dd HH:mm.");
        }
    }

    private void updateFlightInformation() {
        System.out.println("------- Update Flight Information -------");
        System.out.print("Enter flight number: ");
        String flightNumber = scanner.nextLine();

        Flight flight = findFlightByNumber(flightNumber);
        if (flight != null) {
            System.out.println("Flight found! Enter new information:");
            System.out.print("Enter departure city: ");
            String departureCity = scanner.nextLine();
            System.out.print("Enter arrival city: ");
            String arrivalCity = scanner.nextLine();
            System.out.print("Enter departure time (yyyy-MM-dd HH:mm): ");
            String departureTimeStr = scanner.nextLine();
            System.out.print("Enter arrival time (yyyy-MM-dd HH:mm): ");
            String arrivalTimeStr = scanner.nextLine();
            System.out.print("Enter price: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character

            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime departureTime = LocalDateTime.parse(departureTimeStr, formatter);
                LocalDateTime arrivalTime = LocalDateTime.parse(arrivalTimeStr, formatter);

                flight.setDepartureCity(departureCity);
                flight.setArrivalCity(arrivalCity);
                flight.setDepartureTime(departureTime);
                flight.setArrivalTime(arrivalTime);
                flight.setPrice(price);

                adminService.updateFlight(flight);
                System.out.println("Flight information updated successfully!");
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter dates in the format yyyy-MM-dd HH:mm.");
            }
        } else {
            System.out.println("Flight not found with the given flight number.");
        }
    }

    private void removeFlight() {
        System.out.println("------- Remove Flight -------");
        System.out.print("Enter flight number: ");
        String flightNumber = scanner.nextLine();

        Flight flight = findFlightByNumber(flightNumber);
        if (flight != null) {
            adminService.removeFlight(flight);
            System.out.println("Flight removed successfully!");
        } else {
            System.out.println("Flight not found with the given flight number.");
        }
    }

    private Flight findFlightByNumber(String flightNumber) {
        List<com.dao.Flight> flights = adminService.getAllFlights();
        for (com.dao.Flight flight : flights) {
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                return flight;
            }
        }
        return null;
    }

    private void generateReports() {
        // Implement logic to generate reports (e.g., number of bookings and revenue generated)
    }
}
