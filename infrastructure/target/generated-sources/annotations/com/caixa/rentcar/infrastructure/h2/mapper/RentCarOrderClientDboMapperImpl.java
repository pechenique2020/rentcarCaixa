package com.caixa.rentcar.infrastructure.h2.mapper;

import com.caixa.rentcar.domain.model.DomainRentCarOrderClientModel;
import com.caixa.rentcar.domain.model.DomainRentCarOrderClientModel.DomainRentCarOrderClientModelBuilder;
import com.caixa.rentcar.infrastructure.h2.entity.RentCarOrderClientEntity;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
public class RentCarOrderClientDboMapperImpl implements RentCarOrderClientDboMapper {

    @Override
    public List<DomainRentCarOrderClientModel> toDomainList(List<RentCarOrderClientEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DomainRentCarOrderClientModel> list = new ArrayList<DomainRentCarOrderClientModel>( entityList.size() );
        for ( RentCarOrderClientEntity rentCarOrderClientEntity : entityList ) {
            list.add( rentCarOrderClientEntityToDomainRentCarOrderClientModel( rentCarOrderClientEntity ) );
        }

        return list;
    }

    protected DomainRentCarOrderClientModel rentCarOrderClientEntityToDomainRentCarOrderClientModel(RentCarOrderClientEntity rentCarOrderClientEntity) {
        if ( rentCarOrderClientEntity == null ) {
            return null;
        }

        DomainRentCarOrderClientModelBuilder domainRentCarOrderClientModel = DomainRentCarOrderClientModel.builder();

        domainRentCarOrderClientModel.id( rentCarOrderClientEntity.getId() );
        domainRentCarOrderClientModel.carPlate( rentCarOrderClientEntity.getCarPlate() );
        domainRentCarOrderClientModel.startDate( rentCarOrderClientEntity.getStartDate() );
        domainRentCarOrderClientModel.endDate( rentCarOrderClientEntity.getEndDate() );
        domainRentCarOrderClientModel.returnDate( rentCarOrderClientEntity.getReturnDate() );
        domainRentCarOrderClientModel.price( rentCarOrderClientEntity.getPrice() );
        domainRentCarOrderClientModel.status( rentCarOrderClientEntity.getStatus() );
        if ( rentCarOrderClientEntity.getCreatedOn() != null ) {
            domainRentCarOrderClientModel.createdOn( LocalDateTime.ofInstant( rentCarOrderClientEntity.getCreatedOn().toInstant(), ZoneId.of( "UTC" ) ) );
        }

        return domainRentCarOrderClientModel.build();
    }
}
