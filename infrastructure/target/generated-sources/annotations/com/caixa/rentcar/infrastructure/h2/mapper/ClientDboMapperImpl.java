package com.caixa.rentcar.infrastructure.h2.mapper;

import com.caixa.rentcar.domain.model.DomainClientModel;
import com.caixa.rentcar.domain.model.DomainClientModel.DomainClientModelBuilder;
import com.caixa.rentcar.infrastructure.h2.entity.ClientEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-13T09:38:18+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class ClientDboMapperImpl implements ClientDboMapper {

    @Override
    public ClientEntity toDbo(DomainClientModel domain) {
        if ( domain == null ) {
            return null;
        }

        ClientEntity clientEntity = new ClientEntity();

        clientEntity.setId( domain.getId() );
        clientEntity.setDni( domain.getDni() );
        clientEntity.setName( domain.getName() );
        clientEntity.setSurname( domain.getSurname() );
        clientEntity.setGender( domain.getGender() );
        clientEntity.setCreatedOn( domain.getCreatedOn() );

        return clientEntity;
    }

    @Override
    public DomainClientModel toDomain(ClientEntity entity) {
        if ( entity == null ) {
            return null;
        }

        DomainClientModelBuilder domainClientModel = DomainClientModel.builder();

        domainClientModel.id( entity.getId() );
        domainClientModel.dni( entity.getDni() );
        domainClientModel.name( entity.getName() );
        domainClientModel.surname( entity.getSurname() );
        domainClientModel.gender( entity.getGender() );
        domainClientModel.createdOn( entity.getCreatedOn() );

        return domainClientModel.build();
    }

    @Override
    public List<DomainClientModel> toDomainList(List<ClientEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DomainClientModel> list = new ArrayList<DomainClientModel>( entityList.size() );
        for ( ClientEntity clientEntity : entityList ) {
            list.add( toDomain( clientEntity ) );
        }

        return list;
    }

    @Override
    public List<ClientEntity> toDboList(List<DomainClientModel> domainList) {
        if ( domainList == null ) {
            return null;
        }

        List<ClientEntity> list = new ArrayList<ClientEntity>( domainList.size() );
        for ( DomainClientModel domainClientModel : domainList ) {
            list.add( toDbo( domainClientModel ) );
        }

        return list;
    }
}
