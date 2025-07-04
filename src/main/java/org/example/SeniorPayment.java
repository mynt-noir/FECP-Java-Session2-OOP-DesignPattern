package org.example;

public class SeniorPayment implements PaymentType {

    @Override
    public double getCost(double initialCost) {
        return initialCost * 0.80;//20% discount
    }

}
