package entity;

import DTO.ClientDTO;
import org.junit.jupiter.api.Test;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "client")
public class Client implements Comparable<Client> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Pattern(regexp = "(^[A-Z].*)", message = "Client name should start with capital letter!")
    @Size(min = 3, max = 35, message = "Enter a clientName with length between 3 and 35 letters!")
    @Column(name = "name")
    private String name;

    @NotEmpty
    @Size(min = 5, max = 100, message = "Enter a clientAddress with length between 5 and 40 symbols!")
    @Column(name = "address")
    private String address;

    @PastOrPresent(message = "Contract date cannot be in the future!")
    @Column(name = "contractDate")
    private LocalDate contractDate;

    @DecimalMin(value = "0.00" ,inclusive = true)
    @Digits(integer=10, fraction=2)
    @Column(name = "owedMoney")
    private BigDecimal owedMoney;

    @DecimalMin(value = "0.00" ,inclusive = true)
    @Digits(integer=10, fraction=2)
    @Column(name = "allPaidMoney")
    private BigDecimal allPaidMoney;

    public Client() {}

    public Client(String name, String address, LocalDate contractDate) {
        this.name = name;
        this.address = address;
        this.contractDate = contractDate;
        this.owedMoney = BigDecimal.valueOf(0);
        this.allPaidMoney = BigDecimal.valueOf(0);
    }

    public void callCopyConstructor(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.address = client.getAddress();
        this.contractDate = client.getContractDate();
        this.owedMoney = client.getOwedMoney();
        this.allPaidMoney = client.getOwedMoney();
    }

    public long getId() { return id; }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getContractDate() {
        return contractDate;
    }

    public BigDecimal getOwedMoney() { return owedMoney; }

    public BigDecimal getAllPaidMoney() { return allPaidMoney; }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContractDate(LocalDate contractDate) {
        this.contractDate = contractDate;
    }

    public void setOwedMoney(BigDecimal owedMoney) {
        if (this.owedMoney != null)
            this.owedMoney = this.owedMoney.add(owedMoney);
        else
            this.owedMoney = owedMoney;
    }

    public void setAllPaidMoney(BigDecimal allPaidMoney) {
        if (this.allPaidMoney != null)
            this.allPaidMoney = this.allPaidMoney.add(allPaidMoney);
        else
            this.allPaidMoney = allPaidMoney;
    }

    @Override
    public int compareTo(Client c) { return this.address.compareTo(c.address); }

    public void lowerOwedMoney(BigDecimal value) {
        if(this.owedMoney.subtract(value).equals(BigDecimal.valueOf(0)))
            this.owedMoney = null;
        else
            this.owedMoney = this.owedMoney.subtract(value);
    }

    public void increasePaidMoney(BigDecimal value) {
        this.allPaidMoney = this.allPaidMoney.add(value);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contractDate=" + contractDate +
                ", owedMoney=" + owedMoney +
                ", allPaidMoney=" + allPaidMoney +
                '}';
    }
}

