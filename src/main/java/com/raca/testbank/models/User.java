package com.raca.testbank.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
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
    private LocalDateTime createAt;
    @Column(unique = true,nullable = false,length = 40)
    private String username;
    @Column(nullable = false)
    private String password;


    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Role> roles;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "users")
    private List<Bank> banks;

    public User(Integer id) {
        this.id = id;
    }

    @PrePersist
    public void prePersist(){
        this.createAt = LocalDateTime.now();
    }

    public String getPassword() {
        return password;
    }




}
