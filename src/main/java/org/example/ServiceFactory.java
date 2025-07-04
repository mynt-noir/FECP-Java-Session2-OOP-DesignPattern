package org.example;

public class ServiceFactory {
    public static PaymentType getService(String serviceType){
        return switch (serviceType.toLowerCase()) {
            case "x-ray" -> new CashPayment();
            case "surgery" -> new SeniorPayment();
            case "consultation" -> new ConsultationService();
            default -> null;
        };
    }
}
