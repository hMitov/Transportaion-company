package entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@MappedSuperclass
public abstract class Employee implements Comparable<Employee> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Pattern(regexp = "((([A-Z][a-z]+(\\s)[A-Z][a-z]+)))", message = "Enter a both First and Last names!")
    @Column(name = "name", nullable = false)
    protected String name;

    @Pattern(regexp = "([0-9]{10})", message = "EGN must be from digits only and with length 10!")
    @Column(name = "egn", nullable = false, unique = true)
    protected String egn;

    @Column(name = "salary", nullable = true)
    protected BigDecimal salary;

    @Enumerated(EnumType.STRING)
    @Column(name = "position")
    protected EmployeePosition employeePosition;

    @PastOrPresent(message = "Contract date cannot be in the future!")
    @Column(name = "contractDate")
    protected LocalDate contractDate;

    public Employee() {};

    public Employee(String name, String egn, BigDecimal salary, EmployeePosition employeePosition, LocalDate contractDate) {
        this.name = name;
        this.egn = egn;
        this.salary = salary;
        this.employeePosition = employeePosition;
        this.contractDate = contractDate;
    };

    public abstract long getId();

    public abstract void setId(long id);

    public abstract String getName();

    public abstract void setName(String name);

    public abstract String getEgn();

    public abstract void setEgn(String egn);

    public abstract BigDecimal getSalary();

    public abstract void setSalary(BigDecimal salary);

    public abstract EmployeePosition getEmployeePosition();

    public abstract void setEmployeePosition(EmployeePosition employeePosition);

    public abstract LocalDate getContractDate();

    public abstract void setContractDate(LocalDate contractDate);

    @Override
    public int compareTo(Employee em) { return this.egn.compareTo(em.egn); }
}

