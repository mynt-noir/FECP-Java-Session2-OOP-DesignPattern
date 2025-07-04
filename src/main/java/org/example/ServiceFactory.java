package org.example;

public class ServiceFactory {
    public static HospitalService getService(String serviceType){
        return switch (serviceType.toLowerCase()) {
            case "x-ray" -> new XrayService();
            case "surgery" -> new SurgeryService();
            case "consultation" -> new ConsultationService();
            default -> null;
        };
    }
}
