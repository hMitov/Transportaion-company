package DTO;

import entity.EmployeePosition;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CoordinatorDTO {
    private long id;

    private String name;

    private String egn;

    private BigDecimal salary;

    private EmployeePosition employeePosition;

    private LocalDate contractDate;

    private String agentPassword;

    public CoordinatorDTO(long id, String name, String egn, BigDecimal salary, EmployeePosition employeePosition, LocalDate contractDate, String agentPassword) {
        this.id = id;
        this.name = name;
        this.egn = egn;
        this.salary = salary;
        this.employeePosition = employeePosition;
        this.contractDate = contractDate;
        this.agentPassword = agentPassword;
    }

    public String getEgn() {
        return egn;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "CoordinatorDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", egn='" + egn + '\'' +
                ", salary=" + salary +
                ", employeePosition=" + employeePosition +
                ", contractDate=" + contractDate +
                ", agentPassword='" + agentPassword + '\'' +
                '}';
    }
}
