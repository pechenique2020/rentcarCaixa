package com.caixa.rentcar.domain.spi.ports;


import com.caixa.rentcar.domain.model.DomainPricesModel;

import java.util.List;

public interface DomainPricesRepositoryPort {
    DomainPricesModel findPriceByType(String carType);
}
