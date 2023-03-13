package com.caixa.rentcar.infrastructure.h2.mapper;

import com.caixa.rentcar.domain.model.DomainRentCarOrderClientModel;
import com.caixa.rentcar.domain.model.DomainRentCarOrderModel;
import com.caixa.rentcar.infrastructure.h2.entity.RentCarOrderClientEntity;
import com.caixa.rentcar.infrastructure.h2.entity.RentCarOrderEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RentCarOrderClientDboMapper {

    @InheritInverseConfiguration
    List<DomainRentCarOrderClientModel> toDomainList(List<RentCarOrderClientEntity> entityList);

}