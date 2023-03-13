package com.caixa.rentcar.infrastructure.h2.mapper;

import com.caixa.rentcar.domain.model.DomainRentCarOrderClientModel;
import com.caixa.rentcar.domain.model.DomainRentCarOrderModel;
import com.caixa.rentcar.infrastructure.h2.entity.RentCarOrderEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RentCarOrderDboMapper {

    RentCarOrderEntity toDbo(DomainRentCarOrderModel domain);
    @InheritInverseConfiguration
    DomainRentCarOrderClientModel toDomainInfo(RentCarOrderEntity entity);

    @InheritInverseConfiguration
    DomainRentCarOrderModel toDomain(RentCarOrderEntity entity);
    @InheritInverseConfiguration
    List<RentCarOrderEntity> toListDbo(List<DomainRentCarOrderModel> domain);

    List<DomainRentCarOrderModel> toDomainList(List<RentCarOrderEntity> entityList);

}