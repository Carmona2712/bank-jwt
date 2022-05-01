package com.epinerez.testbank.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="users")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,length = 12)
    private String identification;
    @Column(nullable = true,length = 50)
    private String names;
    @Column(nullable = true,length = 50)
    private String lastnames;
    @Column(nullable = true,unique = false,length = 80)
    private String email;
    @Column(nullable = true,unique = false,length = 20)
    private String telephone;
    @Column(nullable = false)
    private Integer status;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @Column(unique = true,nullable = false,length = 40)
    private String username;
    @JsonIgnore
    @Column(nullable = false,length = 200)
    private String password;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Role> roles;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "users")
    private List<Bank> banks;

    @PrePersist
    public void prePersist(){
        this.createAt = Calendar.getInstance().getTime();
    }

}
