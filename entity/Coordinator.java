package entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "coordinator")
public class Coordinator extends Employee {

    @Pattern(regexp = "((9{2}[0-9]{4})|0{2}[0-9]{4})", message = "Agent password should start either with 00 or 99 and be with length 6!")
    @Column(name = "agentPassword")
    private String agentPassword;

    public Coordinator() { }

    public Coordinator(String name, String egn, BigDecimal salary, EmployeePosition employeePosition, LocalDate contractDate, String agentPassword) {
        super(name, egn, salary, employeePosition, contractDate);
        this.agentPassword = agentPassword;
    }

    public void callCopyConstructor(Coordinator coordinator) {
        this.id = coordinator.getId();
        this.name = coordinator.getName();
        this.egn = coordinator.getEgn();
        this.salary = coordinator.getSalary();
        this.employeePosition = coordinator.getEmployeePosition();
        this.contractDate = coordinator.getContractDate();
        this.agentPassword = coordinator.getAgentPassword();
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getSalary() {
        return salary;
    }

    @Override
    public EmployeePosition getEmployeePosition() { return employeePosition; }

    @Override
    public LocalDate getContractDate() {
        return contractDate;
    }

    @Override
    public String getEgn() { return egn; }

    public String getAgentPassword() { return agentPassword; }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setContractDate(LocalDate contractDate) { this.contractDate = contractDate; }

    @Override
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public void setEgn(String egn) { this.egn = egn; }

    @Override
    public void setEmployeePosition(EmployeePosition employeePosition) { this.employeePosition = employeePosition; }

    public void setAgentPassword(String agentPassword) { this.agentPassword = agentPassword; }

    @Override
    public String toString() {
        return "Coordinator{" +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", egn='" + egn + '\'' +
                ", salary=" + salary +
                ", employeePosition=" + employeePosition +
                ", contractDate=" + contractDate +
                ", agentPassword='" + agentPassword +
                '}';
    }
}
