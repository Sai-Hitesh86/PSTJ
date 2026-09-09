package week9_tasks;

import java.util.Scanner;

class RentalVehicle {
    protected String vehicleNumber;
    protected double rentPerDay;

    public RentalVehicle(String vehicleNumber, double rentPerDay) {
        this.vehicleNumber = vehicleNumber;
        this.rentPerDay = rentPerDay;
    }

    public double calculateRent(int days) {
        return rentPerDay * days;
    }
}

class Car extends RentalVehicle {

    public Car(String vehicleNumber, double rentPerDay) {
        super(vehicleNumber, rentPerDay);
    }

    @Override
    public double calculateRent(int days) {
        return rentPerDay * days;
    }
}

class Bike extends RentalVehicle {

    public Bike(String vehicleNumber, double rentPerDay) {
        super(vehicleNumber, rentPerDay);
    }

    @Override
    public double calculateRent(int days) {
        return rentPerDay * days * 0.90;
    }
}

class Truck extends RentalVehicle {

    public Truck(String vehicleNumber, double rentPerDay) {
        super(vehicleNumber, rentPerDay);
    }

    @Override
    public double calculateRent(int days) {
        return rentPerDay * days * 1.20;
    }
}

public class W9S2T1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int vehicleType = sc.nextInt();
            String vehicleNumber = sc.next();
            double rentPerDay = sc.nextDouble();
            int days = sc.nextInt();

            RentalVehicle vehicle;

            if (vehicleType == 1) {
                vehicle = new Car(vehicleNumber, rentPerDay);
            } else if (vehicleType == 2) {
                vehicle = new Bike(vehicleNumber, rentPerDay);
            } else {
                vehicle = new Truck(vehicleNumber, rentPerDay);
            }

            double totalRent = vehicle.calculateRent(days);

            System.out.printf("%s %.2f%n", vehicleNumber, totalRent);
        }

        sc.close();
    }
}
