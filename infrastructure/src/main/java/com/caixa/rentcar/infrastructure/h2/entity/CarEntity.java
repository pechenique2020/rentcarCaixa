package com.caixa.rentcar.infrastructure.h2.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "cars")
public class CarEntity {

    @Id
    @SequenceGenerator(name= "CARS_SEQUENCE", sequenceName = "CARS_SEQUENCE_ID", initialValue=1, allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="CARS_SEQUENCE")
    @Column(name = "id")
    private Long id;
    @Column(name = "plate")
    private String plate;
    @Column(name = "make")
    private String make;
    @Column(name = "model")
    private String model;
    @Column(name = "type")
    private String type;
    @Column(name = "year")
    private int year;
    @Column(name = "created_on")
    @CreationTimestamp
    private LocalDateTime createdOn;

}