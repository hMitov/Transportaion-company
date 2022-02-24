package entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transportation")
public class Transportation implements Comparable<Transportation> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Pattern(regexp = "(^[A-Z].*)", message = "Departure point should start with capital letter!")
    @Column(name = "departPoint")
    private String departPoint;

    @Pattern(regexp = "(^[A-Z].*)", message = "Arrival point should start with capital letter!")
    @Column(name = "arrivalPoint")
    private String arrivalPoint;

    @Future(message = "Departure dateTime should be in future!")
    @Column(name = "departTime")
    private LocalDateTime departTime;

    @Future(message = "Arrival dateTime should be in future!")
    @Column(name = "arrivalTime")
    private LocalDateTime arrivalTime;

    @OneToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Enumerated(EnumType.STRING)
    @Column(name = "typeOfLoad")
    private TypeOfLoad typeOfLoad;

    @DecimalMin(value = "0.00" ,inclusive = true)
    @DecimalMax(value = "15000.00" ,inclusive = true)
    @Digits(integer=5, fraction=2)
    @Column(name = "weight_in_truck")
    private BigDecimal weight_in_truck;

    @DecimalMin(value = "0.00" ,inclusive = true)
    @DecimalMax(value = "15000.00" ,inclusive = true)
    @Digits(integer=5, fraction=2)
    @Column(name = "weight_in_trailer")
    private BigDecimal weight_in_trailer;

    @Min(value = 0)
    @Max(value = 30)
    @Column(name = "numberOfPassengers")
    private int numberOfPassengers;

    @DecimalMin(value = "300.00" ,inclusive = true)
    @Digits(integer=5, fraction=2)
    @Column(name = "price")
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    public Transportation() {}

    public Transportation(String departPoint, String arrivalPoint, LocalDateTime departTime, LocalDateTime arrivalTime,
                          Client client, TypeOfLoad typeOfLoad, BigDecimal weight_in_truck, BigDecimal weight_in_trailer, BigDecimal price)  {
        this.departPoint = departPoint;
        this.arrivalPoint = arrivalPoint;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
        this.client = client;
        this.typeOfLoad = typeOfLoad;
        this.weight_in_truck = weight_in_truck;
        this.weight_in_trailer = weight_in_trailer;
        this.numberOfPassengers = 0;
        this.price = price;
    }

    public Transportation(String departPoint, String arrivalPoint, LocalDateTime departTime, LocalDateTime arrivalTime,
                          Client client, TypeOfLoad typeOfLoad, BigDecimal weight_in_truck, BigDecimal price)  {
        this.departPoint = departPoint;
        this.arrivalPoint = arrivalPoint;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
        this.client = client;
        this.typeOfLoad = typeOfLoad;
        this.weight_in_truck = weight_in_truck;
        this.weight_in_trailer = null;
        this.numberOfPassengers = 0;
        this.price = price;
    }

    public Transportation(String departPoint, String arrivalPoint, LocalDateTime departTime, LocalDateTime arrivalTime,
                          Client client, TypeOfLoad typeOfLoad, int numberOfPassengers, BigDecimal price)  {
        this.departPoint = departPoint;
        this.arrivalPoint = arrivalPoint;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
        this.client = client;
        this.typeOfLoad = typeOfLoad;
        this.weight_in_truck = null;
        this.weight_in_trailer = null;
        this.numberOfPassengers = numberOfPassengers;
        this.price = price;
    }

    public Transportation(String departPoint, String arrivalPoint, LocalDateTime departTime, LocalDateTime arrivalTime,
                          Client client, TypeOfLoad typeOfLoad, BigDecimal weight_in_truck, BigDecimal weight_in_trailer, int numberOfPassengers, BigDecimal price)
    {
        this.departPoint = departPoint;
        this.arrivalPoint = arrivalPoint;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
        this.client = client;
        this.typeOfLoad = typeOfLoad;
        this.weight_in_truck = weight_in_truck;
        this.weight_in_trailer = weight_in_trailer;
        this.numberOfPassengers = numberOfPassengers;
        this.price = price;
    }

    public void callCopyConstructor(Transportation transportation) {
        this.id = transportation.getId();
        this.departPoint = transportation.getDepartPoint();
        this.arrivalPoint = transportation.getArrivalPoint();
        this.departTime = transportation.getDepartTime();
        this.arrivalTime = transportation.getArrivalTime();
        this.vehicle = transportation.getVehicle();
        this.driver = transportation.getDriver();
        this.client = transportation.getClient();
        this.typeOfLoad = transportation.getTypeOfLoad();
        this.weight_in_truck = transportation.getWeight_in_truck();
        this.weight_in_trailer = transportation.getWeight_in_trailer();
        this.numberOfPassengers = transportation.getNumberOfPassengers();
        this.price = transportation.getPrice();
        this.status = transportation.getStatus();
    }

    public long getId() { return id; }

    public String getDepartPoint() { return departPoint; }

    public String getArrivalPoint() { return arrivalPoint; }

    public LocalDateTime getDepartTime() { return departTime; }

    public LocalDateTime getArrivalTime() { return arrivalTime; }

    public Vehicle getVehicle() { return vehicle; }

    public Client getClient() { return client; }

    public TypeOfLoad getTypeOfLoad() { return typeOfLoad; }

    public BigDecimal getWeight_in_truck() { return weight_in_truck; }

    public BigDecimal getWeight_in_trailer() { return weight_in_trailer; }

    public BigDecimal getPrice() { return price; }

    public int getNumberOfPassengers() { return numberOfPassengers; }

    public Driver getDriver() { return driver; }

    public Status getStatus() { return status; }

    public void setId(long id) { this.id = id; }

    public void setDepartPoint(String departPoint) { this.departPoint = departPoint; }

    public void setArrivalPoint(String arrivalPoint) { this.arrivalPoint = arrivalPoint; }

    public void setDepartTime(LocalDateTime departTime) { this.departTime = departTime; }

    public void setArrivalTime(LocalDateTime arrivalTime) { this.arrivalTime = arrivalTime; }

    public void setClient(Client client) { this.client = client; }

    public void setTypeOfLoad(TypeOfLoad typeOfLoad) { this.typeOfLoad = typeOfLoad; }

    public void setWeight_in_truck(BigDecimal weight_in_truck) { this.weight_in_truck = weight_in_truck; }

    public void setWeight_in_trailer(BigDecimal weight_in_trailer) { this.weight_in_trailer = weight_in_trailer; }

    public void setPrice(BigDecimal price) { this.price = price; }

    public void setNumberOfPassengers(int numberOfPassengers) { this.numberOfPassengers = numberOfPassengers; }

    public void setStatus(Status status) { this.status = status; }

    public void changeStatusToFinished() {
        this.client.lowerOwedMoney(price);
        this.client.increasePaidMoney(price);
        this.status = Status.FINISHED;
    }

    public void setVehicle() {
        this.vehicle = null;
    }

    public void setDriver() {
        this.driver = null;
    }

    public void setVehicle(Vehicle v) throws VehicleChoiceException {
        if(this.numberOfPassengers != 0 ) {
            if(this.numberOfPassengers <= v.getMaxNumOfPassengers()) {
                this.vehicle = v;
                return;
            }
            else
                throw new VehicleChoiceException("This vehicle IS NOT appropriate for demands of this transportation!");
        }
        if(this.weight_in_truck != null) {
            this.vehicle = v;
            return;
        }
        else {
            throw new VehicleChoiceException("This vehicle IS NOT appropriate for demands of this transportation!");
        }
    }

    public void addDriverToTransportation(Driver driver) throws DriveLicenseNotAppropriateException {
        if(this.numberOfPassengers == 0) {
            if(this.weight_in_trailer != null) {
                if (driver.getDrivingLicenseCategory().getMaxVehicleWeight().compareTo(this.weight_in_truck.add(this.vehicle.getVehicleWeight())) > 0
                        && driver.getDrivingLicenseCategory().getMaxTrailerWeight().compareTo(this.weight_in_trailer) > 0) {
                    this.driver = driver;
                    return;
                }
                else {
                    throw new DriveLicenseNotAppropriateException("This driver IS NOT ABLE to drive this vehicle, please choose another");
                }
            } else {
                if (driver.getDrivingLicenseCategory().getMaxVehicleWeight().compareTo(this.weight_in_truck.add(this.vehicle.getVehicleWeight())) > 0) {
                    this.driver = driver;
                    return;
                }
                else {
                    throw new DriveLicenseNotAppropriateException("This driver IS NOT ABLE to drive this vehicle, please choose another");
                }
            }
        }
        else {
            if(this.weight_in_trailer != null) {
                if (driver.getDrivingLicenseCategory().getPassengers() >= this.numberOfPassengers
                        && driver.getDrivingLicenseCategory().getMaxTrailerWeight().compareTo(this.weight_in_trailer) > 0) {
                    this.driver = driver;
                    return;
                }
                else {
                    throw new DriveLicenseNotAppropriateException("This driver IS NOT ABLE to drive this vehicle, please choose another");
                }
            } else {
                if (driver.getDrivingLicenseCategory().getPassengers() >= this.numberOfPassengers) {
                    this.driver = driver;
                    return;
                }
                else {
                    throw new DriveLicenseNotAppropriateException("This driver IS NOT ABLE to drive this vehicle, please choose another");
                }
            }
        }
    }

    @Override
    public int compareTo(Transportation t) {
        if(this.getDepartTime().compareTo(t.getDepartTime()) == 0) {
            if(this.getVehicle().compareTo(t.getVehicle()) == 0)
                return 0;
        }
        return this.getDepartTime().compareTo(t.getDepartTime());
    }

    @Override
    public String toString() {
        return "Transportation{" +
                "id=" + id + "\n" +
                ", departPoint='" + departPoint + '\'' +"\n" +
                ", arrivalPoint='" + arrivalPoint + '\'' + "\n" +
                ", departTime=" + departTime + "\n" +
                ", arrivalTime=" + arrivalTime + "\n" +
                ", vehicle=" + vehicle + "\n" +
                ", driver=" + driver + "\n" +
                ", client=" + client + "\n" +
                ", typeOfLoad=" + typeOfLoad + "\n" +
                ", weight_in_truck=" + weight_in_truck + "\n" +
                ", weight_in_trailer=" + weight_in_trailer + "\n" +
                ", numberOfPassengers=" + numberOfPassengers + "\n" +
                ", price=" + price + "\n" +
                ", status=" + status + "\n" +
                '}' + "\n" + "-------------------------------------------------------" + "\n\n";
    }
}
