package com.caixa.rentcar.infrastructure.h2.mapper;

import com.caixa.rentcar.domain.model.DomainCarModel;
import com.caixa.rentcar.domain.model.DomainCarModel.DomainCarModelBuilder;
import com.caixa.rentcar.infrastructure.h2.entity.CarEntity;
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
public class CarDboMapperImpl implements CarDboMapper {

    @Override
    public CarEntity toDbo(DomainCarModel domain) {
        if ( domain == null ) {
            return null;
        }

        CarEntity carEntity = new CarEntity();

        carEntity.setId( domain.getId() );
        carEntity.setPlate( domain.getPlate() );
        carEntity.setMake( domain.getMake() );
        carEntity.setModel( domain.getModel() );
        carEntity.setType( domain.getType() );
        carEntity.setYear( domain.getYear() );
        carEntity.setCreatedOn( domain.getCreatedOn() );

        return carEntity;
    }

    @Override
    public DomainCarModel toDomain(CarEntity entity) {
        if ( entity == null ) {
            return null;
        }

        DomainCarModelBuilder domainCarModel = DomainCarModel.builder();

        domainCarModel.id( entity.getId() );
        domainCarModel.plate( entity.getPlate() );
        domainCarModel.make( entity.getMake() );
        domainCarModel.model( entity.getModel() );
        domainCarModel.type( entity.getType() );
        domainCarModel.year( entity.getYear() );
        domainCarModel.createdOn( entity.getCreatedOn() );

        return domainCarModel.build();
    }

    @Override
    public List<DomainCarModel> toDomainList(List<CarEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DomainCarModel> list = new ArrayList<DomainCarModel>( entityList.size() );
        for ( CarEntity carEntity : entityList ) {
            list.add( toDomain( carEntity ) );
        }

        return list;
    }

    @Override
    public List<CarEntity> toDtoList(List<DomainCarModel> domainList) {
        if ( domainList == null ) {
            return null;
        }

        List<CarEntity> list = new ArrayList<CarEntity>( domainList.size() );
        for ( DomainCarModel domainCarModel : domainList ) {
            list.add( toDbo( domainCarModel ) );
        }

        return list;
    }
}
