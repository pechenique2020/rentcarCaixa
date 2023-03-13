package com.caixa.rentcar.domain.spi.ports;

import com.caixa.rentcar.domain.model.DomainCarModel;

import java.util.List;

public interface DomainCarRepositoryPort {
    List<DomainCarModel> getCarInventory();

    DomainCarModel findCarInventoryByCarPlate(String carPlate);

    List<DomainCarModel> findCarInventoryByCarPlateList(List<String> carPlateList);

    List<DomainCarModel> findUnavailableCarByPlateList(List<String> carPlateList);

}
