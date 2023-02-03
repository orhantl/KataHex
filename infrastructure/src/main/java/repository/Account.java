package repository;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class Account {


    private String id;
    private BigDecimal balance;

}
