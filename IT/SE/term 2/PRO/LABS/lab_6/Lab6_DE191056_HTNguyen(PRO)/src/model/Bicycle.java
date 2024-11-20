package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Bicycle {


    //attribute
    private String bicycleId;
    private double speed;
    private double distance;
    private boolean isElectric;
    private Date procDate;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Bicycle(String bicycleId, double speed, double distance, boolean isElectric, String productionDate) throws ParseException {
        this.bicycleId = bicycleId;
        this.speed = speed;
        this.distance = distance;
        this.isElectric = isElectric;
        this.procDate = setProductionDate(productionDate);
    }

    public String getBicycleId() {
        return bicycleId;
    }

    public void setBicycleId(String bicycleId) {
        this.bicycleId = bicycleId;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    public Date getProductionDate() {
        return procDate;
    }

    public Date setProductionDate(String productionDate) throws ParseException {
        return sdf.parse(productionDate);
    }

    public String needToRecharge() {
        String res;
        if (this.isElectric && this.distance > 60) res = "Need to recharge batteries";
        else res = "Don't need to recharge";
        return res;
    }


    @Override
    public String toString() {
        String type = isElectric ? "E-Bicycle" : "Bicycle";
        return String.format("%-10s | %-5s | %-5.1f | %-10.1f | %-26s | %-5s",
                type,
                this.bicycleId,
                this.speed,
                this.distance,
                this.needToRecharge(),
                sdf.format(this.procDate)
        );
    }


}
