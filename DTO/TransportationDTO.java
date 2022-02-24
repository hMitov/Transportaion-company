package DTO;

import entity.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransportationDTO {
    private long id;

    private String departPoint;

    private String arrivalPoint;

    private LocalDateTime departTime;

    private LocalDateTime arrivalTime;

    private TypeOfLoad typeOfLoad;

    private BigDecimal weight_in_truck;

    private BigDecimal weight_in_trailer;

    private int numberOfPassengers;

    private BigDecimal price;

    private Status status;

    public TransportationDTO(long id, String departPoint, String arrivalPoint, LocalDateTime departTime, LocalDateTime arrivalTime, TypeOfLoad typeOfLoad, BigDecimal weight_in_truck, BigDecimal weight_in_trailer, int numberOfPassengers, BigDecimal price, Status status) {
        this.id = id;
        this.departPoint = departPoint;
        this.arrivalPoint = arrivalPoint;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
        this.typeOfLoad = typeOfLoad;
        this.weight_in_truck = weight_in_truck;
        this.weight_in_trailer = weight_in_trailer;
        this.numberOfPassengers = numberOfPassengers;
        this.price = price;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public BigDecimal getPrice() { return price; }

    public void setDepartTime(LocalDateTime departTime) {
        this.departTime = departTime;
    }



    @Override
    public String toString() {
        return "TransportationDTO{" +
                "id=" + id +
                ", departPoint='" + departPoint + '\'' +
                ", arrivalPoint='" + arrivalPoint + '\'' +
                ", departTime=" + departTime +
                ", arrivalTime=" + arrivalTime +
                ", typeOfLoad=" + typeOfLoad +
                ", weight_in_truck=" + weight_in_truck +
                ", weight_in_trailer=" + weight_in_trailer +
                ", numberOfPassengers=" + numberOfPassengers +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
}
