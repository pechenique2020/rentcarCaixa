package com.caixa.rentcar.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DomainPricesModel {
    private Long id;
    private Double price;
    private String type;
    private int points;
    private LocalDateTime createdOn;

}
