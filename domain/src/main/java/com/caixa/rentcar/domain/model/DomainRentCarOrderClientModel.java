package com.caixa.rentcar.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DomainRentCarOrderClientModel {
    private Long id;
    private String carPlate;
    private String carDetail;
    private Date startDate;
    private Date endDate;
    private Date returnDate;
    private Double price;
    private String status;
    private LocalDateTime createdOn;

}
