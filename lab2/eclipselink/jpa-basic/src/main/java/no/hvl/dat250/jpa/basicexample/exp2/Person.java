package no.hvl.dat250.jpa.basicexample.exp2;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany
    private ArrayList<CreditCard> creditCards;

    @ManyToMany
    private ArrayList<Address> addresses;
}
