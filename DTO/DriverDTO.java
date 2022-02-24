package DTO;

import entity.DrivingLicenseCategory;
import entity.EmployeePosition;
import entity.Transportation;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public class DriverDTO {
    private long id;
    private String name;
    private String egn;
    private BigDecimal salary;
    private EmployeePosition employeePosition;
    private LocalDate contractDate;
    private DrivingLicenseCategory drivingLicenseCategory;

    public DriverDTO(long id, String name, String egn, BigDecimal salary, EmployeePosition employeePosition, LocalDate contractDate, DrivingLicenseCategory drivingLicenseCategory) {
        this.id = id;
        this.name = name;
        this.egn = egn;
        this.salary = salary;
        this.employeePosition = employeePosition;
        this.contractDate = contractDate;
        this.drivingLicenseCategory = drivingLicenseCategory;
    }

    public long getId() { return id; }

    public String getEgn() {
        return egn;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "DriverDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", egn='" + egn + '\'' +
                ", salary=" + salary +
                ", employeePosition=" + employeePosition +
                ", contractDate=" + contractDate +
                ", drivingLicenseCategory=" + drivingLicenseCategory +
                '}';
    }
}
