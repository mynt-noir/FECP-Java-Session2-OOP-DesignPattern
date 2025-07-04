package org.example;

public class CashPayment implements PaymentType {

    @Override
    public double getCost(double initialCost) {
        return initialCost;//no changes
    }
}
