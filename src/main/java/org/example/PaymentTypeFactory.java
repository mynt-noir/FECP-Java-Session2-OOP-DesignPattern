package org.example;

public class PaymentTypeFactory {
    public static PaymentType getService(String serviceType){
        return switch (serviceType.toLowerCase()) {
            case "cash" -> new CashPayment();
            case "senior" -> new SeniorPayment();
            case "hmo" -> new HmoPayment();
            default -> null;
        };
    }
}
