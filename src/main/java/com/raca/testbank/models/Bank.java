package com.raca.testbank.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "banks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bank implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true,length = 100)
    private String name;

    @ManyToMany
    private List<User> users;
    @OneToMany(mappedBy = "bank")
    private List<Credit> credits;


}
