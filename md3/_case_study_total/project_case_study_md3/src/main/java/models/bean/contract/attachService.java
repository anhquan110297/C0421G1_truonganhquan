package models.bean.contract;

public class attachService {
    private int attachServiceId;
    private double attachServiceCost;
    private String attachServiceName;
    private String attachServiceStatus;

    public attachService() {
    }

    public attachService(double attachServiceCost, String attachServiceName, String attachServiceStatus) {
        this.attachServiceCost = attachServiceCost;
        this.attachServiceName = attachServiceName;
        this.attachServiceStatus = attachServiceStatus;
    }

    public int getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(int attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public double getAttachServiceCost() {
        return attachServiceCost;
    }

    public void setAttachServiceCost(double attachServiceCost) {
        this.attachServiceCost = attachServiceCost;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public String getAttachServiceStatus() {
        return attachServiceStatus;
    }

    public void setAttachServiceStatus(String attachServiceStatus) {
        this.attachServiceStatus = attachServiceStatus;
    }
}
