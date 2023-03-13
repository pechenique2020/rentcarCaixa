package com.caixa.rentcar.infrastructure.h2.mapper;

import com.caixa.rentcar.domain.model.DomainCarModel;
import com.caixa.rentcar.infrastructure.h2.entity.CarEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarDboMapper {

    CarEntity toDbo(DomainCarModel domain);
    @InheritInverseConfiguration
    DomainCarModel toDomain(CarEntity entity);

    @InheritInverseConfiguration
    List<DomainCarModel> toDomainList(List<CarEntity> entityList);

    List<CarEntity> toDtoList(List<DomainCarModel> domainList);
}