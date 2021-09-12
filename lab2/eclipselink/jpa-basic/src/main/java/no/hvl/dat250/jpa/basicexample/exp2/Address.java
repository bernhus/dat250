package no.hvl.dat250.jpa.basicexample.exp2;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String street;
    private int number;

    @ManyToMany
    private ArrayList<Person> persons;


}
