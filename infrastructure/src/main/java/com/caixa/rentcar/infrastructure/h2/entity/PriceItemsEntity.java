package com.caixa.rentcar.infrastructure.h2.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "price_items")
public class PriceItemsEntity {

    @Id
    @SequenceGenerator(name= "PRICEITEMS_SEQUENCE", sequenceName = "PRICEITEMS_SEQUENCE_ID", initialValue=1, allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="PRICEITEMS_SEQUENCE")
    @Column(name = "id")
    private Long id;
    @Column(name = "price_id")
    private int priceId;
    @Column(name = "init_day")
    private int initDay;
    @Column(name = "end_day")
    private int endDay;
    @Column(name = "extra_day")
    private int extraDay;
    @Column(name = "recharge")
    private int recharge;
    @Column(name = "created_on")
    @CreationTimestamp
    private LocalDateTime createdOn;

}