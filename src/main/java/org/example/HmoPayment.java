package org.example;

public class HmoPayment implements PaymentType {

    @Override
    public double getCost(double initialCost) {
        return initialCost * 0.60;//40% discount

    }

}
