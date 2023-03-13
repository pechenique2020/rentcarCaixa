package com.caixa.rentcar.infrastructure.h2.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "clients")
public class ClientEntity {

    @Id
    @SequenceGenerator(name= "CLIENTS_SEQUENCE", sequenceName = "CLIENTS_SEQUENCE_ID", initialValue=1, allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="CLIENTS_SEQUENCE")
    @Column(name = "id")
    private Long id;
    @Column(name = "dni")
    private String dni;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "gender")
    private String gender;
    @Column(name = "created_on")
    @CreationTimestamp
    private LocalDateTime createdOn;
}