package com.caixa.rentcar.infrastructure.h2.mapper;

import com.caixa.rentcar.domain.model.DomainPriceItemsModel;
import com.caixa.rentcar.infrastructure.h2.entity.PriceItemsEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PriceItemsDboMapper {

    @InheritInverseConfiguration
    List<DomainPriceItemsModel> toDomainList(List<PriceItemsEntity> entityList);

}