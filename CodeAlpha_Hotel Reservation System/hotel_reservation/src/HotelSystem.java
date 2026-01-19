import java.io.*;
import java.util.*;

public class HotelSystem {

    static ArrayList<Room> rooms = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static final String FILE = "bookings.txt";

    public static void main(String[] args) {

        rooms.add(new Room(101, "Standard", 2000));
        rooms.add(new Room(102, "Deluxe", 3500));
        rooms.add(new Room(103, "Suite", 5000));

        while (true) {
            System.out.println("\n--- Hotel Reservation System ---");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. View Bookings");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> viewRooms();
                case 2 -> bookRoom();
                case 3 -> cancelRoom();
                case 4 -> viewBookings();
                case 5 -> {
                    System.out.println("Thank you for using Hotel System!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    static void viewRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room r : rooms) {
            if (r.isAvailable()) {
                System.out.println("Room " + r.getRoomNumber() +
                        " | " + r.getCategory() +
                        " | ₹" + r.getPrice());
            }
        }
    }

    static void bookRoom() {
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        System.out.print("Enter room number to book: ");
        int roomNo = sc.nextInt();

        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNo && r.isAvailable()) {
                System.out.println("Pay ₹" + r.getPrice() + " (Payment Successful)");
                r.book();
                saveBooking(new Reservation(name, roomNo, r.getPrice()));
                System.out.println("Room booked successfully!");
                return;
            }
        }
        System.out.println("Room not available.");
    }

    static void cancelRoom() {
        System.out.print("Enter room number to cancel: ");
        int roomNo = sc.nextInt();

        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNo && !r.isAvailable()) {
                r.cancel();
                System.out.println("Reservation cancelled.");
                return;
            }
        }
        System.out.println("Invalid room number.");
    }

    static void saveBooking(Reservation res) {
        try (FileWriter fw = new FileWriter(FILE, true)) {
            fw.write(res.toString() + "\n");
        } catch (IOException e) {
            System.out.println("Error saving booking.");
        }
    }

    static void viewBookings() {
        System.out.println("\nBooking Details:");
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("No bookings found.");
        }
    }
}
