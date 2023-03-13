package com.caixa.rentcar.domain.api.ports;

import com.caixa.rentcar.domain.model.DomainApiResponseModel;
import com.caixa.rentcar.domain.model.DomainCarModel;

import java.util.List;

public interface DomainCarServicePort {
    List<DomainCarModel> getCarInventory();

    DomainCarModel findCarInventoryByCarPlate(String carPlate);

}
