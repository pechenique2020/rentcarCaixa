package com.caixa.rentcar.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DomainPriceItemsModel {
    private Long id;
    private int priceId;
    private int initDay;
    private int endDay;
    private int extraDay;
    private int recharge;
    private LocalDateTime createdOn;

}
