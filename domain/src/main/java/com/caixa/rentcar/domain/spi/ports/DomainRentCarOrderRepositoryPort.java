package com.caixa.rentcar.domain.spi.ports;

import com.caixa.rentcar.domain.model.DomainRentCarOrderClientModel;
import com.caixa.rentcar.domain.model.DomainRentCarOrderModel;

import java.util.List;

public interface DomainRentCarOrderRepositoryPort {
    DomainRentCarOrderClientModel findRentCarOrder(String rentcarId);
    DomainRentCarOrderModel findRentCarOrderByRentcarOder(String carPlate);
    List<DomainRentCarOrderModel> createRentCarOrder(List<DomainRentCarOrderModel> domainRentCarOrderListModel);
    void completeRentCarOrder(DomainRentCarOrderModel domainRentCarOrderModel);

}
