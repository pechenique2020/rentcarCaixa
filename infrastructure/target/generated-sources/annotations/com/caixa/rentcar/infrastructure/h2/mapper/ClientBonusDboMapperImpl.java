package com.caixa.rentcar.infrastructure.h2.mapper;

import com.caixa.rentcar.domain.model.DomainClientBonusModel;
import com.caixa.rentcar.infrastructure.h2.entity.ClientBonusEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-13T09:38:18+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class ClientBonusDboMapperImpl implements ClientBonusDboMapper {

    @Override
    public ClientBonusEntity toDbo(DomainClientBonusModel domain) {
        if ( domain == null ) {
            return null;
        }

        ClientBonusEntity clientBonusEntity = new ClientBonusEntity();

        clientBonusEntity.setId( domain.getId() );
        clientBonusEntity.setDni( domain.getDni() );
        clientBonusEntity.setCarPlate( domain.getCarPlate() );
        clientBonusEntity.setRentcarId( domain.getRentcarId() );
        clientBonusEntity.setPoints( domain.getPoints() );

        return clientBonusEntity;
    }
}
