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
public class DomainCarModel {
    private Long id;
    private String plate;
    private String make;
    private String model;
    private String type;
    private int year;
    private LocalDateTime createdOn;

    private List<DomainRentCarOrderClientModel> order_history;

}
