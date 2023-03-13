package com.caixa.rentcar.domain.spi.ports;


import com.caixa.rentcar.domain.model.DomainPriceItemsModel;

import java.util.List;

public interface DomainPriceItemsRepositoryPort {
    List<DomainPriceItemsModel> findPriceItemsByType(String carType);
}
