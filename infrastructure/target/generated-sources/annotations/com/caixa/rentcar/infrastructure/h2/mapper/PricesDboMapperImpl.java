package com.caixa.rentcar.infrastructure.h2.mapper;

import com.caixa.rentcar.domain.model.DomainPricesModel;
import com.caixa.rentcar.domain.model.DomainPricesModel.DomainPricesModelBuilder;
import com.caixa.rentcar.infrastructure.h2.entity.PricesEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-13T09:38:18+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class PricesDboMapperImpl implements PricesDboMapper {

    @Override
    public PricesEntity toDbo(DomainPricesModel domain) {
        if ( domain == null ) {
            return null;
        }

        PricesEntity pricesEntity = new PricesEntity();

        pricesEntity.setId( domain.getId() );
        pricesEntity.setPrice( domain.getPrice() );
        pricesEntity.setType( domain.getType() );
        pricesEntity.setPoints( domain.getPoints() );
        pricesEntity.setCreatedOn( domain.getCreatedOn() );

        return pricesEntity;
    }

    @Override
    public DomainPricesModel toDomain(PricesEntity entity) {
        if ( entity == null ) {
            return null;
        }

        DomainPricesModelBuilder domainPricesModel = DomainPricesModel.builder();

        domainPricesModel.id( entity.getId() );
        domainPricesModel.price( entity.getPrice() );
        domainPricesModel.type( entity.getType() );
        domainPricesModel.points( entity.getPoints() );
        domainPricesModel.createdOn( entity.getCreatedOn() );

        return domainPricesModel.build();
    }
}
