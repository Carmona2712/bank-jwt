package com.raca.testbank.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "payments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime date;
    @ManyToOne
    private User user;
    @ManyToOne
    private Credit credit;
    @OneToOne
    private Quote quote;
    private double value;

}
