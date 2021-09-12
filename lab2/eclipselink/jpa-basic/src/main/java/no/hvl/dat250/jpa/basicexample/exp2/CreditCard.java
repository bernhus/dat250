package no.hvl.dat250.jpa.basicexample.exp2;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int number;
    private int limit;
    private int balance;

    @ManyToOne
    private Bank bank;

    @OneToOne
    private Pincode pincode;


}
