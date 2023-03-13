package com.caixa.rentcar.infrastructure.h2.mapper;

import com.caixa.rentcar.domain.model.DomainClientBonusModel;
import com.caixa.rentcar.domain.model.DomainClientModel;
import com.caixa.rentcar.infrastructure.h2.entity.ClientBonusEntity;
import com.caixa.rentcar.infrastructure.h2.entity.ClientEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientBonusDboMapper {

    ClientBonusEntity toDbo(DomainClientBonusModel domain);

}