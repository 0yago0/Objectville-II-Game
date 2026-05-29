package Services;

import cells.Cell;

public abstract class Service extends Cell {
    private int radius;
    private String ServiceType;

    public  Service(int row, int column, int radius, String serviceType) {
        super(row, column);
        this.radius=radius;
        this.ServiceType=serviceType;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getServiceType() {
        return ServiceType;
    }

    public void setServiceType(String serviceType) {
        ServiceType = serviceType;
    }
}
