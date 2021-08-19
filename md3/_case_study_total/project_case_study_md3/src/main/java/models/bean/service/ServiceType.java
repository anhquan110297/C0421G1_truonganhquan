package models.bean.service;

public class ServiceType {
    private int ServiceType;
    private String ServiceTypeName;

    public ServiceType() {
    }

    public ServiceType(int serviceType, String serviceTypeName) {
        ServiceType = serviceType;
        ServiceTypeName = serviceTypeName;
    }

    public int getServiceType() {
        return ServiceType;
    }

    public void setServiceType(int serviceType) {
        ServiceType = serviceType;
    }

    public String getServiceTypeName() {
        return ServiceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        ServiceTypeName = serviceTypeName;
    }
}
