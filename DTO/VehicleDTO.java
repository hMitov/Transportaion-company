package DTO;

import entity.TypeOfVehicle;

import java.math.BigDecimal;
import java.time.LocalDate;

public class VehicleDTO {
    private long id;

    private String brand;

    private String model;

    private String regPlate;

    private LocalDate productionDate;

    private TypeOfVehicle typeOfVehicle;

    private int maxNumOfPassengers;

    private BigDecimal vehicle_weight;

    public VehicleDTO(long id, String brand, String model, String regPlate, LocalDate productionDate, TypeOfVehicle typeOfVehicle, int maxNumOfPassengers, BigDecimal vehicle_weight) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.regPlate = regPlate;
        this.productionDate = productionDate;
        this.typeOfVehicle = typeOfVehicle;
        this.maxNumOfPassengers = maxNumOfPassengers;
        this.vehicle_weight = vehicle_weight;
    }

    public String getBrand() {
        return brand;
    }

    public String getRegPlate() {
        return regPlate;
    }

    @Override
    public String toString() {
        return "VehicleDTO{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", regPlate='" + regPlate + '\'' +
                ", productionDate=" + productionDate +
                ", typeOfVehicle=" + typeOfVehicle +
                ", maxNumOfPassengers=" + maxNumOfPassengers +
                ", vehicle_weight=" + vehicle_weight +
                '}';
    }
}
