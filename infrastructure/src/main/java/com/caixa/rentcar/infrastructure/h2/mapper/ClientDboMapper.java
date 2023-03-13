package com.caixa.rentcar.infrastructure.h2.mapper;

import com.caixa.rentcar.domain.model.DomainClientModel;
import com.caixa.rentcar.infrastructure.h2.entity.ClientEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientDboMapper {

    ClientEntity toDbo(DomainClientModel domain);
    @InheritInverseConfiguration
    DomainClientModel toDomain(ClientEntity entity);
    @InheritInverseConfiguration
    List<DomainClientModel> toDomainList(List<ClientEntity> entityList);
    List<ClientEntity> toDboList(List<DomainClientModel> domainList);
}