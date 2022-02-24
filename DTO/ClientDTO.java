package DTO;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ClientDTO {

    private long id;

    private String name;

    private String address;

    private LocalDate contractDate;

    private BigDecimal owedMoney;

    private BigDecimal allPaidMoney;

    public ClientDTO(long id, String name, String address, LocalDate contractDate, BigDecimal owedMoney, BigDecimal allPaidMoney) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contractDate = contractDate;
        this.owedMoney = owedMoney;
        this.allPaidMoney = allPaidMoney;
    }

    public long getId() { return id; }

    public String getName() { return name; }

    public String getAddress() { return address; }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contractDate=" + contractDate +
                ", owedMoney=" + owedMoney +
                ", allPaidMoney=" + allPaidMoney +
                '}';
    }
}
