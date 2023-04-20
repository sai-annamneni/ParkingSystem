import java.util.ArrayList;
import java.util.Scanner;

public class ParkingSystem {

    static int totalSlots = 100;
    static int availableSlots = totalSlots;
    static ArrayList<String> parkedCars = new ArrayList<String>();
    static ArrayList<String> parkedBikes = new ArrayList<String>();
    static int availableSlotsBlock29 = 50;
    static int availableSlotsBlock34 = 50;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // display welcome message
        System.out.println("===================================");
        System.out.println("      Welcome to LPU Parking       ");
        System.out.println("===================================");
        // ask user to select block
        System.out.println("\nPlease select a block:");
        System.out.println("1. 29-Block");
        System.out.println("2. 34-Block");
        int blockChoice = sc.nextInt();

        // validate block choice
        while (blockChoice != 1 && blockChoice != 2) {
            System.out.println("Invalid choice. Please select 1 or 2.");
            blockChoice = sc.nextInt();
        }

        // show available parking slots for the selected block
        int availableSlotsBlock = blockChoice == 1 ? availableSlotsBlock29 : availableSlotsBlock34;
        System.out.println("\nAvailable slots in Block " + (blockChoice == 1 ? "29" : "34") + ": " + availableSlotsBlock);

        while (true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Park a car");
            System.out.println("2. Park a bike");
            System.out.println("3. Remove a vehicle");
            System.out.println("4. View parked vehicles");
            System.out.println("5. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    parkCar(blockChoice);
                    break;
                case 2:
                    parkBike(blockChoice);
                    break;
                case 3:
                    removeVehicle();
                    break;
                case 4:
                    viewParkedVehicles();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void parkCar(int blockChoice) {
        int availableSlotsBlock = blockChoice == 1 ? availableSlotsBlock29 : availableSlotsBlock34;

        if (availableSlotsBlock == 0) {
            System.out.println("Sorry, there are no available parking slots.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the license plate number of the car:");
        String licensePlate = sc.next();
        System.out.println("Enter the duration of parking in hours:");
        int duration = sc.nextInt();

        // Calculate cost based on a rate per hour
        double ratePerHour = 25; // example rate
        double cost = duration * ratePerHour;

        if (blockChoice == 1) {
            parkedCars.add("Block 29 - " + licensePlate);
            availableSlotsBlock29--;
        } else {
            parkedCars.add("Block 34 - " + licensePlate);
            availableSlotsBlock34--;
        }

        System.out.println("Car parked successfully. Available slots: " + (blockChoice == 1 ? availableSlotsBlock29 : availableSlotsBlock34));
        System.out.printf("Cost for parking: Rs.%.2f%n", cost); // display the cost with 2 decimal places
    }

    public static void parkBike(int blockChoice) {
        int availableSlotsBlock = blockChoice == 1 ? availableSlotsBlock29 : availableSlotsBlock34;

        if (availableSlotsBlock == 0) {
            System.out.println("Sorry, there are no available parking slots.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the license plate number of the bike:");
        String licensePlate = sc.next();
        System.out.println("Enter the duration of parking in hours:");
        int duration = sc.nextInt();

        // Calculate cost based on a rate per hour
        double ratePerHour = 15; // example rate
        double cost = duration * ratePerHour;

        if (blockChoice == 1) {
            parkedBikes.add("Block 29 - " + licensePlate);
            availableSlotsBlock29--;
        } else {
            parkedBikes.add("Block 34 - " + licensePlate);
            availableSlotsBlock34--;
        }

        System.out.println("Bike parked successfully. Available slots: " + (blockChoice == 1 ? availableSlotsBlock29 : availableSlotsBlock34));
        System.out.printf("Cost for parking: Rs.%.2f%n", cost); // display the cost with 2 decimal places
    }


    public static void removeVehicle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the license plate number of the vehicle to remove:");
        String licensePlate = sc.next();

        if (parkedCars.contains("Block 29 - " + licensePlate)) {
            parkedCars.remove("Block 29 - " + licensePlate);
            availableSlotsBlock29++;
            System.out.println("Car removed successfully. Available slots: " + availableSlotsBlock29);
        } else if (parkedCars.contains("Block 34 - " + licensePlate)) {
            parkedCars.remove("Block 34 - " + licensePlate);
            availableSlotsBlock34++;
            System.out.println("Car removed successfully. Available slots: " + availableSlotsBlock34);
        } else if (parkedBikes.contains("Block 29 - " + licensePlate)) {
            parkedBikes.remove("Block 29 - " + licensePlate);
            availableSlotsBlock29++;
            System.out.println("Bike removed successfully. Available slots: " + availableSlotsBlock29);
        } else if (parkedBikes.contains("Block 34 - " + licensePlate)) {
            parkedBikes.remove("Block 34 - " + licensePlate);
            availableSlotsBlock34++;
            System.out.println("Bike removed successfully. Available slots: " + availableSlotsBlock34);
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    public static void viewParkedVehicles() {
        System.out.println("Parked cars:");
        for (String car : parkedCars) {
            System.out.println(car);
        }

        System.out.println("Parked bikes:");
        for (String bike : parkedBikes) {
            System.out.println(bike);
        }
    }
}






































