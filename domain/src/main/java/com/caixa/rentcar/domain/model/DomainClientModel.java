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
public class DomainClientModel {
    private Long id;
    private String dni;
    private String name;
    private String surname;
    private String gender;
    private int loyalty;
    private LocalDateTime createdOn;

    private List<DomainRentCarOrderClientModel> orderHistory;

}
