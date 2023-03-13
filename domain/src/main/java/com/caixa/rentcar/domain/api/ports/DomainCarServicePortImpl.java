package com.caixa.rentcar.domain.api.ports;

import com.caixa.rentcar.domain.model.DomainApiResponseModel;
import com.caixa.rentcar.domain.model.DomainCarModel;
import com.caixa.rentcar.domain.shared.constants.DomainMessages;
import com.caixa.rentcar.domain.shared.exceptions.DomainNotFoundException;
import com.caixa.rentcar.domain.spi.ports.DomainCarRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class DomainCarServicePortImpl implements DomainCarServicePort {

    private final DomainCarRepositoryPort domainCarRepositoryPort;

    @Override
    public List<DomainCarModel> getCarInventory(){
        List<DomainCarModel> domainCarListModel = domainCarRepositoryPort.getCarInventory();
        if (!domainCarListModel.isEmpty()){
            return domainCarListModel;
        }else{
            throw new DomainNotFoundException(DomainMessages.FILE_EMPTY);
        }
    }

    @Override
    public DomainCarModel findCarInventoryByCarPlate(String carPlate){
        DomainCarModel domainCarModel = domainCarRepositoryPort.findCarInventoryByCarPlate(carPlate);
        if (domainCarModel!=null){
            return domainCarModel;
        }else{
            throw new DomainNotFoundException(DomainMessages.KEY_NOT_FOUND);
        }
    }

}
