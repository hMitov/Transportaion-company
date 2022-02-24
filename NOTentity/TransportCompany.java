package NOTentity;
import entity.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.EnumSet;
import java.util.Set;
import java.util.TreeSet;


public class TransportCompany {

    private long id;

    private String name;

    private LocalDate foundationDate;

    private Set<Vehicle> vehicles;

    private EnumSet<TypeOfVehicle> typesOfVehicles = EnumSet.of(TypeOfVehicle.VAN, TypeOfVehicle.BUS, TypeOfVehicle.TRUCK);;

    private Set<Driver> drivers;

    private Set<Coordinator> coordinators;

    private Set<Client> clients;

    private Set<Transportation> transportations;

    public static final int maxPassengers = 30;

    public TransportCompany() {}

    public TransportCompany(String name, LocalDate foundationDate) {
        this.name = name;
        this.foundationDate = foundationDate;
        this.vehicles = new TreeSet<Vehicle>();
        this.drivers = new TreeSet<Driver>();
        this.coordinators = new TreeSet<Coordinator>();
        this.transportations = new TreeSet<Transportation>();
        this.clients = new TreeSet<Client>();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public EnumSet<TypeOfVehicle> getTypesOfVehicles() {
        return typesOfVehicles;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public Set<Coordinator> getCoordinators() { return coordinators; }

    public Set<Client> getClients() {
        return clients;
    }

    public Set<Transportation> getTransportations() { return transportations; }

    public void setId(long id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setFoundationDate(LocalDate foundationDate) {
        this.foundationDate = foundationDate;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void setTypesOfVehicles(EnumSet<TypeOfVehicle> typesOfVehicles) {
        this.typesOfVehicles = typesOfVehicles;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

    public void setCoordinators(Set<Coordinator> coordinators) { this.coordinators = coordinators; }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public void addVehicle(Vehicle vehicle) throws Exception {
        boolean flag = false;
        for(Vehicle vehicle1 : this.vehicles) {
            if (vehicle1.getRegPlate().equals(vehicle.getRegPlate()))
                flag = true;
        }
        if(!flag)
            this.vehicles.add(vehicle);
        else
            throw new Exception("This vehicle already exists int the system!");        }

    public void removeVehicle(Vehicle vehicle) {
        this.vehicles.forEach(vehicle1 -> {
            if(vehicle1.getRegPlate().equals(vehicle.getRegPlate()))
                this.vehicles.remove(vehicle1);
        });
    }

    public void addVehiclesSet(Set<Vehicle> vehicles) {
        this.vehicles.forEach(vehicle -> this.vehicles.add(vehicle));
    }

    public void addDriver(Driver driver) throws Exception {
        boolean flag = false;
        for(Driver driver1 : this.drivers) {
            if (driver1.getEgn().equals(driver.getEgn()))
                flag = true;
        }
        if(!flag)
            this.drivers.add(driver);
        else
            throw new Exception("This driver already exists int the system!");
    }

    public void removeDriver(Driver driver) {
        this.drivers.forEach(driver1 -> {
            if(driver1.getEgn().equals(driver.getEgn()))
                this.drivers.remove(driver1);
        });
    }

    public void addDriversSet(Set<Driver> drivers) {
        this.drivers.forEach(driver -> this.drivers.add(driver));
    }

    public void addCoordinator(Coordinator coordinator) throws Exception{
        boolean flag = false;
        for(Coordinator coordinator1 : this.coordinators) {
            if (coordinator1.getEgn().equals(coordinator.getEgn()))
                flag = true;
        }
        if(!flag)
            this.coordinators.add(coordinator);
        else
            throw new Exception("This coordinator already exists int the system!");
    }

    public void removeCoordinator(Coordinator coordinator) {
        this.coordinators.forEach(coordinator1 -> {
            if(coordinator1.getEgn().equals(coordinator.getEgn()))
                this.coordinators.remove(coordinator1);
        });
    }

    public void addCoordinatorsSet(Set<Coordinator> coordinators) {
        this.coordinators.forEach(coordinator -> this.coordinators.add(coordinator));
    }

    public void addClient(Client client) throws Exception {
        boolean flag = false;
        for(Client client1 : this.clients) {
            if (client1.getAddress().equals(client.getAddress()))
                flag = true;
        }
        if(!flag)
            this.clients.add(client);
        else
            throw new Exception("This client already exists int the system!");    }

    public void removeClient(Client client) {
        this.clients.forEach(client1 -> {
            if(client1.getAddress().equals(client.getAddress()))
                this.clients.remove(client1);
        });
    }

    public void addClientsSet(Set<Client> clients) {
        this.clients.forEach(client -> this.clients.add(client));
    }

    public void addTransportation(Transportation transportation) throws Exception {
        boolean flag = false;
        for(Transportation transportation1 : this.transportations) {
            if (transportation1.getDepartTime().equals(transportation.getDepartTime()))
                if(transportation1.getVehicle().equals(transportation.getVehicle()))
                    flag = true;
        }
        if(!flag)
            this.transportations.add(transportation);
        else
            throw new Exception("This transportation already exists int the system!");
    }

    public void removeTransportation(Transportation transportation) {
        this.transportations.forEach(transportation1 -> {
            if(transportation1.getDepartTime().equals(transportation.getDepartTime()))
                if(transportation1.getVehicle().equals(transportation.getVehicle()))
                    this.transportations.remove(transportation1);
        });
    }

    public void addTransportationsSet(Set<Transportation> transportations) {
        this.transportations.forEach(transportation -> this.transportations.add(transportation));
    }
}
