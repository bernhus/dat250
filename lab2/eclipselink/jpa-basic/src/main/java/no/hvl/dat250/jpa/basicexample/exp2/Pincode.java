package no.hvl.dat250.jpa.basicexample.exp2;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Pincode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String pincode;
    private int count;

}

