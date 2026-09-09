package week9_tasks;

import java.util.Scanner;

class Vehicle {
    protected String vehicleNumber;

    public Vehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
}
class Driver {
    private String name;
    private Vehicle vehicle;

    public Driver(String name, Vehicle vehicle) {
        this.name = name;
        this.vehicle = vehicle;
    }
}
class Rider {
    private String name;

    public Rider(String name) {
        this.name = name;
    }
}
abstract class Trip {
    protected double distance;

    public Trip(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();
}

class BikeTrip extends Trip {

    public BikeTrip(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return distance * 5;
    }
}

// Auto ride
class AutoTrip extends Trip {

    public AutoTrip(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return distance * 12;
    }
}

// Cab ride
class CabTrip extends Trip {

    public CabTrip(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return distance * 12;
    }
}

// Custom exception for invalid bookings
class InvalidBookingException extends Exception {

    public InvalidBookingException(String message) {
        super(message);
    }
}

// Main class
public class W9S1T2 {

    public static Trip createTrip(String rideType, double distance)
            throws InvalidBookingException {

        if (distance <= 0) {
            throw new InvalidBookingException("Invalid distance");
        }

        if (rideType.equalsIgnoreCase("Bike")) {
            return new BikeTrip(distance);
        } 
        else if (rideType.equalsIgnoreCase("Auto")) {
            return new AutoTrip(distance);
        } 
        else if (rideType.equalsIgnoreCase("Cab")) {
            return new CabTrip(distance);
        } 
        else {
            throw new InvalidBookingException("Invalid ride type");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {

            String rideType = sc.next();
            double distance = sc.nextDouble();

            try {
                Trip trip = createTrip(rideType, distance);

                System.out.println((int) trip.calculateFare());

            } catch (InvalidBookingException e) {
                System.out.println(e.getMessage());
            }
        }

        sc.close();
    }
}
