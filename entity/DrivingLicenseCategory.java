package entity;

import java.math.BigDecimal;

public enum DrivingLicenseCategory {
    C1(BigDecimal.valueOf(7500),BigDecimal.valueOf(750), 8), C1E(BigDecimal.valueOf(7500), BigDecimal.valueOf(4500), 8), C(BigDecimal.valueOf(12000), BigDecimal.valueOf(750), 8),
    CE(BigDecimal.valueOf(12000), BigDecimal.valueOf(10000), 8), D1(BigDecimal.valueOf(100000), BigDecimal.valueOf(750), 16), D1E(BigDecimal.valueOf(100000), BigDecimal.valueOf(6000), 16),
    D(BigDecimal.valueOf(100000), BigDecimal.valueOf(750), 100000), DE(BigDecimal.valueOf(100000), BigDecimal.valueOf(100000), 100000);
    private BigDecimal maxVehicleWeight;
    private BigDecimal maxTrailerWeight;
    private int passengers;

    private DrivingLicenseCategory(BigDecimal maxVehicleWeight, BigDecimal maxTrailerWeight, int passengers) {
        this.maxVehicleWeight = maxVehicleWeight;
        this.maxTrailerWeight = maxTrailerWeight;
        this.passengers = passengers;
    }

    public BigDecimal getMaxVehicleWeight() { return maxVehicleWeight; }

    public BigDecimal getMaxTrailerWeight() { return maxTrailerWeight; }

    public int getPassengers() { return passengers; }
}
