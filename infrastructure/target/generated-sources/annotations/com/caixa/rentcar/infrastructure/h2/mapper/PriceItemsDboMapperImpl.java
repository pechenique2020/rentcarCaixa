package com.caixa.rentcar.infrastructure.h2.mapper;

import com.caixa.rentcar.domain.model.DomainPriceItemsModel;
import com.caixa.rentcar.domain.model.DomainPriceItemsModel.DomainPriceItemsModelBuilder;
import com.caixa.rentcar.infrastructure.h2.entity.PriceItemsEntity;
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
public class PriceItemsDboMapperImpl implements PriceItemsDboMapper {

    @Override
    public List<DomainPriceItemsModel> toDomainList(List<PriceItemsEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DomainPriceItemsModel> list = new ArrayList<DomainPriceItemsModel>( entityList.size() );
        for ( PriceItemsEntity priceItemsEntity : entityList ) {
            list.add( priceItemsEntityToDomainPriceItemsModel( priceItemsEntity ) );
        }

        return list;
    }

    protected DomainPriceItemsModel priceItemsEntityToDomainPriceItemsModel(PriceItemsEntity priceItemsEntity) {
        if ( priceItemsEntity == null ) {
            return null;
        }

        DomainPriceItemsModelBuilder domainPriceItemsModel = DomainPriceItemsModel.builder();

        domainPriceItemsModel.id( priceItemsEntity.getId() );
        domainPriceItemsModel.priceId( priceItemsEntity.getPriceId() );
        domainPriceItemsModel.initDay( priceItemsEntity.getInitDay() );
        domainPriceItemsModel.endDay( priceItemsEntity.getEndDay() );
        domainPriceItemsModel.extraDay( priceItemsEntity.getExtraDay() );
        domainPriceItemsModel.recharge( priceItemsEntity.getRecharge() );
        domainPriceItemsModel.createdOn( priceItemsEntity.getCreatedOn() );

        return domainPriceItemsModel.build();
    }
}
