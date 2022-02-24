package entity;

import NOTentity.TransportCompany;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "vehicle")
public class Vehicle implements Comparable<Vehicle>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Pattern(regexp = "(^[A-Z].*)", message = "Vehicle name should start with capital letter!")
    @Size(min = 3, max = 15, message = "Enter a Vehicle name with length between 3 and 15 letters!")
    @Column(name = "brand")
    private String brand;

    @Pattern(regexp = "(^[A-Z0-9].*)", message = "Vehicle model should start with capital letter!")
    @Size(min = 3, max = 15, message = "Enter a Vehicle model with length between 3 and 15 letters!")
    @Column(name = "model")
    private String model;

    @Pattern(regexp = "([A-Z]{1,2}[0-9]{4}[A-Z]{2})", message = "Invalid form of registration plate!")
    @Column(name = "regPlate")
    private String regPlate;

    @Past(message = "Production date should be in the past!")
    @Column(name = "productionDate")
    private LocalDate productionDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "typeOfVehicle", nullable = false)
    private TypeOfVehicle typeOfVehicle;

    @OneToMany(mappedBy = "vehicle")
    private Set<Transportation> allTransportationsMade;

    @Min(value = 0)
    @Max(value = TransportCompany.maxPassengers)
    @Column(name = "maxNumOfPassengers")
    private int maxNumOfPassengers;

    @DecimalMin(value = "1700.00" ,inclusive = true)
    @Digits(integer=5, fraction=2)
    @Column(name = "empty_veh_weight")
    private BigDecimal vehicle_weight;

    public Vehicle() {}

    public Vehicle(String brand, String model, String regPlate, LocalDate productionDate, TypeOfVehicle typeOfVehicle, BigDecimal vehicle_weight) {
        this.brand = brand;
        this.model = model;
        this.regPlate = regPlate;
        this.productionDate = productionDate;
        this.allTransportationsMade = new TreeSet<Transportation>();
        this.typeOfVehicle = typeOfVehicle;
        this.maxNumOfPassengers = 0;
        this.vehicle_weight = vehicle_weight;
    }

    public Vehicle(String brand, String model, String regPlate, LocalDate productionDate, TypeOfVehicle typeOfVehicle, int maxNumOfPassengers, BigDecimal vehicle_weight) {
        this.brand = brand;
        this.model = model;
        this.regPlate = regPlate;
        this.productionDate = productionDate;
        this.allTransportationsMade = new TreeSet<Transportation>();
        this.typeOfVehicle = typeOfVehicle;
        this.maxNumOfPassengers = maxNumOfPassengers;
        this.vehicle_weight = vehicle_weight;
    }

    public void callCopyConstructor(Vehicle vehicle) {
        this.id = vehicle.getId();
        this.brand = vehicle.getBrand();
        this.model = vehicle.getModel();
        this.regPlate = vehicle.getRegPlate();
        this.productionDate = vehicle.getProductionDate();
        this.typeOfVehicle = vehicle.getTypeOfVehicle();
        this.allTransportationsMade = vehicle.getAllTransportationsMade();
        this.maxNumOfPassengers = vehicle.getMaxNumOfPassengers();
        this.vehicle_weight = vehicle.getVehicleWeight();
    }

    public long getId() { return id; }

    public String getBrand() { return brand; }

    public String getModel() { return model; }

    public String getRegPlate() { return regPlate; }

    public LocalDate getProductionDate() { return productionDate; }

    public TypeOfVehicle getTypeOfVehicle() { return typeOfVehicle; }

    public Set<Transportation> getAllTransportationsMade() { return allTransportationsMade; }

    public int getMaxNumOfPassengers() { return maxNumOfPassengers; }

    public BigDecimal getVehicleWeight() { return vehicle_weight; }

    public void setId(long id) { this.id = id; }

    public void setBrand(String brand) { this.brand = brand; }

    public void setModel(String model) { this.model = model; }

    public void setRegPlate(String regPlate) { this.regPlate = regPlate; }

    public void setProductionDate(LocalDate productionDate) { this.productionDate = productionDate; }

    public void setTypeOfVehicle(TypeOfVehicle typeOfVehicle) { this.typeOfVehicle = typeOfVehicle; }

    public void setMaxNumOfPassengers(int maxNumOfPassengers) { this.maxNumOfPassengers = maxNumOfPassengers; }

    public void setVehicleWeight(BigDecimal vehicle_weight) { this.vehicle_weight = vehicle_weight; }

    public void addNewTransportation(Transportation transportation) { this.allTransportationsMade.add(transportation); }

    @Override
    public int compareTo(Vehicle v) { return this.regPlate.compareTo(v.regPlate); }

    @Override
    public String toString() {
        return "Vehicle{" +
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
