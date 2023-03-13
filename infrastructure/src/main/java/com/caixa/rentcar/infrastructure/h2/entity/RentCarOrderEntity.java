package com.caixa.rentcar.infrastructure.h2.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "rentcar_orders")
public class RentCarOrderEntity {

    @Id
    @SequenceGenerator(name= "RENTCAR_ORDER_SEQUENCE", sequenceName = "RENTCAR_ORDER_SEQUENCE_ID", initialValue=1, allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="RENTCAR_ORDER_SEQUENCE")
    @Column(name = "id")
    private Long id;
    @Column(name = "client_dni")
    private String clientDni;
    @Column(name = "car_plate")
    private String carPlate;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "return_date")
    private Date returnDate;
    @Column(name = "price")
    private Double price;
    @Column(name = "status")
    private String status;
    @Column(name = "created_on")
    @CreationTimestamp
    private LocalDateTime createdOn;
}