package com.caixa.rentcar.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DomainApiResponseModel {
    private int code;
    private String type;
    private String message;
    private List<DomainRentCarOrderModel> orders = new ArrayList<>();

}
