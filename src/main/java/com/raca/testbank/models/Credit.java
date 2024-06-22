package com.raca.testbank.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "credits")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Credit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer numberQuotes;
    private double balance;
    @OneToMany(mappedBy = "credit")
    private List<Quote> quotes;
    @ManyToOne
    @JsonIgnore
    private Bank bank;
    @ManyToOne
    @JsonIgnore
    private User user;

}
