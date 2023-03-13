package com.caixa.rentcar.infrastructure.h2.mapper;

import com.caixa.rentcar.domain.model.DomainRentCarOrderClientModel;
import com.caixa.rentcar.domain.model.DomainRentCarOrderClientModel.DomainRentCarOrderClientModelBuilder;
import com.caixa.rentcar.domain.model.DomainRentCarOrderModel;
import com.caixa.rentcar.domain.model.DomainRentCarOrderModel.DomainRentCarOrderModelBuilder;
import com.caixa.rentcar.infrastructure.h2.entity.RentCarOrderEntity;
import java.sql.Date;
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
public class RentCarOrderDboMapperImpl implements RentCarOrderDboMapper {

    @Override
    public RentCarOrderEntity toDbo(DomainRentCarOrderModel domain) {
        if ( domain == null ) {
            return null;
        }

        RentCarOrderEntity rentCarOrderEntity = new RentCarOrderEntity();

        rentCarOrderEntity.setId( domain.getId() );
        rentCarOrderEntity.setClientDni( domain.getClientDni() );
        rentCarOrderEntity.setCarPlate( domain.getCarPlate() );
        if ( domain.getStartDate() != null ) {
            rentCarOrderEntity.setStartDate( new Date( domain.getStartDate().getTime() ) );
        }
        if ( domain.getEndDate() != null ) {
            rentCarOrderEntity.setEndDate( new Date( domain.getEndDate().getTime() ) );
        }
        if ( domain.getReturnDate() != null ) {
            rentCarOrderEntity.setReturnDate( new Date( domain.getReturnDate().getTime() ) );
        }
        rentCarOrderEntity.setPrice( domain.getPrice() );
        rentCarOrderEntity.setStatus( domain.getStatus() );
        rentCarOrderEntity.setCreatedOn( domain.getCreatedOn() );

        return rentCarOrderEntity;
    }

    @Override
    public DomainRentCarOrderClientModel toDomainInfo(RentCarOrderEntity entity) {
        if ( entity == null ) {
            return null;
        }

        DomainRentCarOrderClientModelBuilder domainRentCarOrderClientModel = DomainRentCarOrderClientModel.builder();

        domainRentCarOrderClientModel.id( entity.getId() );
        domainRentCarOrderClientModel.carPlate( entity.getCarPlate() );
        domainRentCarOrderClientModel.startDate( entity.getStartDate() );
        domainRentCarOrderClientModel.endDate( entity.getEndDate() );
        domainRentCarOrderClientModel.returnDate( entity.getReturnDate() );
        domainRentCarOrderClientModel.price( entity.getPrice() );
        domainRentCarOrderClientModel.status( entity.getStatus() );
        domainRentCarOrderClientModel.createdOn( entity.getCreatedOn() );

        return domainRentCarOrderClientModel.build();
    }

    @Override
    public DomainRentCarOrderModel toDomain(RentCarOrderEntity entity) {
        if ( entity == null ) {
            return null;
        }

        DomainRentCarOrderModelBuilder domainRentCarOrderModel = DomainRentCarOrderModel.builder();

        domainRentCarOrderModel.id( entity.getId() );
        domainRentCarOrderModel.clientDni( entity.getClientDni() );
        domainRentCarOrderModel.carPlate( entity.getCarPlate() );
        domainRentCarOrderModel.startDate( entity.getStartDate() );
        domainRentCarOrderModel.endDate( entity.getEndDate() );
        domainRentCarOrderModel.returnDate( entity.getReturnDate() );
        domainRentCarOrderModel.price( entity.getPrice() );
        domainRentCarOrderModel.status( entity.getStatus() );
        domainRentCarOrderModel.createdOn( entity.getCreatedOn() );

        return domainRentCarOrderModel.build();
    }

    @Override
    public List<RentCarOrderEntity> toListDbo(List<DomainRentCarOrderModel> domain) {
        if ( domain == null ) {
            return null;
        }

        List<RentCarOrderEntity> list = new ArrayList<RentCarOrderEntity>( domain.size() );
        for ( DomainRentCarOrderModel domainRentCarOrderModel : domain ) {
            list.add( toDbo( domainRentCarOrderModel ) );
        }

        return list;
    }

    @Override
    public List<DomainRentCarOrderModel> toDomainList(List<RentCarOrderEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DomainRentCarOrderModel> list = new ArrayList<DomainRentCarOrderModel>( entityList.size() );
        for ( RentCarOrderEntity rentCarOrderEntity : entityList ) {
            list.add( toDomain( rentCarOrderEntity ) );
        }

        return list;
    }
}
