package Test12;
import java.util.Scanner;

class Room {
    int roomNumber;
    String roomType;
    boolean isBooked;

    Room(int number, String type) {
        roomNumber = number;
        roomType = type;
        isBooked = false;
    }

    void displayRoomInfo() {
        System.out.println("Room No: " + roomNumber + ", Type: " + roomType + ", Booked: " + isBooked);
    }
}

public class HotelManagementSystem {
    static Room[] rooms = new Room[5]; // Only 5 rooms for simplicity
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initializeRooms();

        int choice;
        do {
            System.out.println("\n--- Hotel Management Menu ---");
            System.out.println("1. Display Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Checkout Room");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: displayRooms(); break;
                case 2: bookRoom(); break;
                case 3: checkoutRoom(); break;
                case 4: System.out.println("Thank you for using Hotel System!"); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }

    static void initializeRooms() {
        rooms[0] = new Room(101, "Single");
        rooms[1] = new Room(102, "Double");
        rooms[2] = new Room(103, "Deluxe");
        rooms[3] = new Room(104, "Single");
        rooms[4] = new Room(105, "Suite");
    }

    static void displayRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room room : rooms) {
            room.displayRoomInfo();
        }
    }

    static void bookRoom() {
        System.out.print("Enter room number to book: ");
        int number = sc.nextInt();

        for (Room room : rooms) {
            if (room.roomNumber == number) {
                if (!room.isBooked) {
                    room.isBooked = true;
                    System.out.println("Room " + number + " successfully booked.");
                } else {
                    System.out.println("Room already booked!");
                }
                return;
            }
        }
        System.out.println("Room not found!");
    }

    static void checkoutRoom() {
        System.out.print("Enter room number to checkout: ");
        int number = sc.nextInt();

        for (Room room : rooms) {
            if (room.roomNumber == number) {
                if (room.isBooked) {
                    room.isBooked = false;
                    System.out.println("Room " + number + " is now available.");
                } else {
                    System.out.println("Room was not booked.");
                }
                return;
            }
        }
        System.out.println("Room not found!");
    }
}

