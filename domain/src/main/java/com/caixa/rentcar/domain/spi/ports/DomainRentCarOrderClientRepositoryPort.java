package com.caixa.rentcar.domain.spi.ports;

import com.caixa.rentcar.domain.model.DomainRentCarOrderClientModel;
import com.caixa.rentcar.domain.model.DomainRentCarOrderModel;

import java.util.List;

public interface DomainRentCarOrderClientRepositoryPort {
    List<DomainRentCarOrderClientModel> findRentCarOrderByClientDni(String clientDni);
}
