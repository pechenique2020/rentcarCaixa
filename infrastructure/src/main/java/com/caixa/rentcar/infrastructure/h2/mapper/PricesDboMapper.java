package com.caixa.rentcar.infrastructure.h2.mapper;

import com.caixa.rentcar.domain.model.DomainCarModel;
import com.caixa.rentcar.domain.model.DomainPricesModel;
import com.caixa.rentcar.infrastructure.h2.entity.CarEntity;
import com.caixa.rentcar.infrastructure.h2.entity.PricesEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PricesDboMapper {

    PricesEntity toDbo(DomainPricesModel domain);
    @InheritInverseConfiguration
    DomainPricesModel toDomain(PricesEntity entity);

}