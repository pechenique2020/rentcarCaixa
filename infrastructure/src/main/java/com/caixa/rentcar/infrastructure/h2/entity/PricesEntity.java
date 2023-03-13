package com.caixa.rentcar.infrastructure.h2.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "prices")
public class PricesEntity {

    @Id
    @SequenceGenerator(name= "PRICES_SEQUENCE", sequenceName = "PRICES_SEQUENCE_ID", initialValue=1, allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="PRICES_SEQUENCE")
    @Column(name = "id")
    private Long id;
    @Column(name = "price")
    private Double price;
    @Column(name = "type")
    private String type;
    @Column(name = "points")
    private int points;
    @Column(name = "created_on")
    @CreationTimestamp
    private LocalDateTime createdOn;

}