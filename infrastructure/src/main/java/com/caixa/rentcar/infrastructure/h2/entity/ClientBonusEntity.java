package com.caixa.rentcar.infrastructure.h2.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "client_bonus")
public class ClientBonusEntity {

    @Id
    @SequenceGenerator(name= "CLIENT_BONUS_SEQUENCE", sequenceName = "CLIENT_BONUS_SEQUENCE_ID", initialValue=1, allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="CLIENT_BONUS_SEQUENCE")
    @Column(name = "id")
    private Long id;
    @Column(name = "dni")
    private String dni;
    @Column(name = "car_plate")
    private String carPlate;
    @Column(name = "rentcar_id")
    private Long rentcarId;
    @Column(name = "points")
    private int points;
    @Column(name = "created_on")
    @CreationTimestamp
    private LocalDateTime createdOn;
}