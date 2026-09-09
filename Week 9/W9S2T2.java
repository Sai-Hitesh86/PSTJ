package week9_tasks;

import java.util.Scanner;

interface Payment {
    void pay(double amount);
}

class CreditCardPayment implements Payment {
    public void pay(double amount) {
    }
}

class UPIPayment implements Payment {
    public void pay(double amount) {
    }
}

class NetBankingPayment implements Payment {
    public void pay(double amount) {
    }
}

abstract class PaymentProcessor {
    abstract double processPayment(Payment payment, double amount);
}

class OnlinePaymentProcessor extends PaymentProcessor {

    public double processPayment(Payment payment, double amount) {
        if (payment instanceof CreditCardPayment) {
            return amount * 1.02;
        } else if (payment instanceof UPIPayment) {
            return amount * 1.01;
        } else if (payment instanceof NetBankingPayment) {
            return amount * 1.015;
        }

        return amount;
    }
}

public class W9S2T2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        PaymentProcessor processor = new OnlinePaymentProcessor();

        for (int i = 0; i < N; i++) {
            int paymentType = sc.nextInt();
            double amount = sc.nextDouble();

            Payment payment;
            String paymentName;

            if (paymentType == 1) {
                payment = new CreditCardPayment();
                paymentName = "CreditCard";
            } else if (paymentType == 2) {
                payment = new UPIPayment();
                paymentName = "UPI";
            } else {
                payment = new NetBankingPayment();
                paymentName = "NetBanking";
            }

            double finalAmount = processor.processPayment(payment, amount);

            System.out.printf("%s %.2f%n", paymentName, finalAmount);
        }

        sc.close();
    }
}
