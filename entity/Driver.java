package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "driver")
public class Driver extends Employee {

    @Enumerated(EnumType.STRING)
    @Column(name = "drive_license_category", nullable = false)
    private DrivingLicenseCategory drivingLicenseCategory;

    @OneToMany(mappedBy = "driver")
    private Set<Transportation> allTransportationsMade;


    public Driver() {}

    public Driver(String name, String egn, BigDecimal salary, EmployeePosition employeePosition, LocalDate contractDate, DrivingLicenseCategory drivingLicenseCategory) {
        super(name, egn, salary, employeePosition, contractDate);
        this.drivingLicenseCategory = drivingLicenseCategory;
        this.allTransportationsMade = new TreeSet<Transportation>();
    }

    public void callCopyConstructor(Driver driver) {
        this.id = driver.getId();
        this.name = driver.getName();
        this.egn = driver.getEgn();
        this.salary = driver.getSalary();
        this.employeePosition = driver.getEmployeePosition();
        this.contractDate = driver.getContractDate();
        this.drivingLicenseCategory = driver.getDrivingLicenseCategory();
        this.allTransportationsMade = driver.getAllTransportationsMade();
    }

    @Override
    public long getId() { return id; }

    @Override
    public String getName() { return name; }

    @Override
    public BigDecimal getSalary() { return salary; }

    @Override
    public String getEgn() { return egn; }

    @Override
    public EmployeePosition getEmployeePosition() { return employeePosition; }

    @Override
    public LocalDate getContractDate() { return contractDate; }

    public DrivingLicenseCategory getDrivingLicenseCategory() { return drivingLicenseCategory; }

    public Set<Transportation> getAllTransportationsMade() { return allTransportationsMade; }

    @Override
    public void setId(long id) { this.id = id; }

    @Override
    public void setName(String name) { this.name = name; }

    @Override
    public void setSalary(BigDecimal salary) { this.salary = salary; }

    @Override
    public void setContractDate(LocalDate contractDate) { this.contractDate = contractDate; }

    public void setDrivingLicenseCategory(DrivingLicenseCategory drivingLicenseCategory) { this.drivingLicenseCategory = drivingLicenseCategory; }

    @Override
    public void setEgn(String egn) { this.egn = egn; }

    @Override
    public void setEmployeePosition(EmployeePosition employeePosition) { this.employeePosition = employeePosition; }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", egn='" + egn + '\'' +
                ", employeePosition=" + employeePosition +
                ", contractDate=" + contractDate +
                ", drivingLicenseCategory=" + drivingLicenseCategory +
                ", salary=" + salary +
                '}';
    }
}
