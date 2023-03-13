package com.caixa.rentcar.infrastructure.h2.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class RentCarOrderClientEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "car_plate")
    private String carPlate;
    //@Column(name = "car_detail")
    //private String carDetail;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "return_date")
    private Date returnDate;
    @Column(name = "price")
    private double price;
    @Column(name = "status")
    private String status;
    @Column(name = "created_on")
    private Date createdOn;

}
