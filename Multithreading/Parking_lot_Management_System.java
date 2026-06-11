// ParkingLot Class
class ParkingLot {
    private int availableSlots = 3;

    // Synchronized method to ensure only one car parks at a time
    public synchronized void parkCar(String carName) {

        if (availableSlots > 0) {
            System.out.println(carName + " Parked");

            availableSlots--;

            System.out.println("Available Slots: " + availableSlots);
        } else {
            System.out.println("No Parking Available for " + carName);
        }
    }
}

// CarThread Class
class CarThread extends Thread {
    private ParkingLot parkingLot;
    private String carName;

    public CarThread(ParkingLot parkingLot, String carName) {
        this.parkingLot = parkingLot;
        this.carName = carName;
    }

    @Override
    public void run() {
        parkingLot.parkCar(carName);
    }
}

// Main Class
public class ParkingSystem {
    public static void main(String[] args) {

        // Create shared ParkingLot object
        ParkingLot parkingLot = new ParkingLot();

        // Create 6 car threads
        CarThread car1 = new CarThread(parkingLot, "Car 1");
        CarThread car2 = new CarThread(parkingLot, "Car 2");
        CarThread car3 = new CarThread(parkingLot, "Car 3");
        CarThread car4 = new CarThread(parkingLot, "Car 4");
        CarThread car5 = new CarThread(parkingLot, "Car 5");
        CarThread car6 = new CarThread(parkingLot, "Car 6");

        // Start all car threads
        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();
        car6.start();
    }
}/*
A shopping mall has:

Available Parking Slots = 3

Multiple cars arrive simultaneously.

Each car is represented by a separate thread.

Requirements
Create a shared ParkingLot class.
Initially:
slots = 3
When a car arrives:
If a slot is available:
Park the car
Reduce available slots
Print:
Car 1 Parked
Available Slots: 2
Otherwise:
No Parking Available for Car 4
Use synchronization to prevent incorrect slot allocation.
Create at least 6 car threads.

Instructions - 
Create Class ParkingLot

    availableSlots ← 3

    synchronized Method parkCar(carName)

        IF availableSlots > 0

            Print carName + " Parked"

            availableSlots ← availableSlots - 1

            Print "Available Slots: " + availableSlots

        ELSE

            Print "No Parking Available for " + carName

        END IF


Create Class CarThread

    ParkingLot parkingLot
    carName

    Method run()

        parkingLot.parkCar(carName)


Main Method

    Create ParkingLot object

    Create Car1 thread till Car6 thread
    Start Car1 till  Car6


*/
