package com.raca.testbank.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "quotes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Quote implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer number;
    private double value;
    @ManyToOne
    @JsonIgnore
    private Credit credit;

}
