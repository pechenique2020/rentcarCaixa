package com.caixa.rentcar.application.mapper;

import com.caixa.rentcar.application.model.ApiCarInfoDto;
import com.caixa.rentcar.application.model.ApiRentCarOrderResponseDto;
import com.caixa.rentcar.application.model.ApiResponseDto;
import com.caixa.rentcar.domain.model.DomainApiResponseModel;
import com.caixa.rentcar.domain.model.DomainCarModel;
import com.caixa.rentcar.domain.model.DomainRentCarOrderModel;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-13T09:38:17+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class AppCarMapperImpl implements AppCarMapper {

    @Override
    public DomainCarModel toDomainCarInfo(ApiCarInfoDto apiCarInfoDto) {
        if ( apiCarInfoDto == null ) {
            return null;
        }

        DomainCarModel.DomainCarModelBuilder domainCarModel = DomainCarModel.builder();

        domainCarModel.id( apiCarInfoDto.getId() );
        domainCarModel.plate( apiCarInfoDto.getPlate() );
        domainCarModel.make( apiCarInfoDto.getMake() );
        domainCarModel.model( apiCarInfoDto.getModel() );
        if ( apiCarInfoDto.getType() != null ) {
            domainCarModel.type( apiCarInfoDto.getType().name() );
        }
        if ( apiCarInfoDto.getYear() != null ) {
            domainCarModel.year( apiCarInfoDto.getYear().intValue() );
        }
        if ( apiCarInfoDto.getCreatedOn() != null ) {
            domainCarModel.createdOn( LocalDateTime.parse( apiCarInfoDto.getCreatedOn() ) );
        }

        return domainCarModel.build();
    }

    @Override
    public ApiCarInfoDto toCarDto(DomainCarModel domainCarInfoModel) {
        if ( domainCarInfoModel == null ) {
            return null;
        }

        ApiCarInfoDto apiCarInfoDto = new ApiCarInfoDto();

        apiCarInfoDto.setId( domainCarInfoModel.getId() );
        apiCarInfoDto.setPlate( domainCarInfoModel.getPlate() );
        apiCarInfoDto.setMake( domainCarInfoModel.getMake() );
        apiCarInfoDto.setModel( domainCarInfoModel.getModel() );
        if ( domainCarInfoModel.getType() != null ) {
            apiCarInfoDto.setType( Enum.valueOf( ApiCarInfoDto.TypeEnum.class, domainCarInfoModel.getType() ) );
        }
        apiCarInfoDto.setYear( (long) domainCarInfoModel.getYear() );
        if ( domainCarInfoModel.getCreatedOn() != null ) {
            apiCarInfoDto.setCreatedOn( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( domainCarInfoModel.getCreatedOn() ) );
        }

        return apiCarInfoDto;
    }

    @Override
    public List<ApiCarInfoDto> toCarInfoListDto(List<DomainCarModel> domainCarInfoListModel) {
        if ( domainCarInfoListModel == null ) {
            return null;
        }

        List<ApiCarInfoDto> list = new ArrayList<ApiCarInfoDto>( domainCarInfoListModel.size() );
        for ( DomainCarModel domainCarModel : domainCarInfoListModel ) {
            list.add( toCarDto( domainCarModel ) );
        }

        return list;
    }

    @Override
    public ApiResponseDto toApiResponseDto(DomainApiResponseModel domainApiResponseModel) {
        if ( domainApiResponseModel == null ) {
            return null;
        }

        ApiResponseDto apiResponseDto = new ApiResponseDto();

        apiResponseDto.setCode( (long) domainApiResponseModel.getCode() );
        apiResponseDto.setType( domainApiResponseModel.getType() );
        apiResponseDto.setMessage( domainApiResponseModel.getMessage() );
        apiResponseDto.setOrders( domainRentCarOrderModelListToApiRentCarOrderResponseDtoList( domainApiResponseModel.getOrders() ) );

        return apiResponseDto;
    }

    protected ApiRentCarOrderResponseDto domainRentCarOrderModelToApiRentCarOrderResponseDto(DomainRentCarOrderModel domainRentCarOrderModel) {
        if ( domainRentCarOrderModel == null ) {
            return null;
        }

        ApiRentCarOrderResponseDto apiRentCarOrderResponseDto = new ApiRentCarOrderResponseDto();

        apiRentCarOrderResponseDto.setId( domainRentCarOrderModel.getId() );
        apiRentCarOrderResponseDto.setClientDni( domainRentCarOrderModel.getClientDni() );
        apiRentCarOrderResponseDto.setCarPlate( domainRentCarOrderModel.getCarPlate() );
        if ( domainRentCarOrderModel.getStartDate() != null ) {
            apiRentCarOrderResponseDto.setStartDate( new SimpleDateFormat().format( domainRentCarOrderModel.getStartDate() ) );
        }
        if ( domainRentCarOrderModel.getEndDate() != null ) {
            apiRentCarOrderResponseDto.setEndDate( new SimpleDateFormat().format( domainRentCarOrderModel.getEndDate() ) );
        }
        if ( domainRentCarOrderModel.getReturnDate() != null ) {
            apiRentCarOrderResponseDto.setReturnDate( new SimpleDateFormat().format( domainRentCarOrderModel.getReturnDate() ) );
        }
        if ( domainRentCarOrderModel.getPrice() != null ) {
            apiRentCarOrderResponseDto.setPrice( BigDecimal.valueOf( domainRentCarOrderModel.getPrice() ) );
        }
        apiRentCarOrderResponseDto.setStatus( domainRentCarOrderModel.getStatus() );
        if ( domainRentCarOrderModel.getCreatedOn() != null ) {
            apiRentCarOrderResponseDto.setCreatedOn( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( domainRentCarOrderModel.getCreatedOn() ) );
        }

        return apiRentCarOrderResponseDto;
    }

    protected List<ApiRentCarOrderResponseDto> domainRentCarOrderModelListToApiRentCarOrderResponseDtoList(List<DomainRentCarOrderModel> list) {
        if ( list == null ) {
            return null;
        }

        List<ApiRentCarOrderResponseDto> list1 = new ArrayList<ApiRentCarOrderResponseDto>( list.size() );
        for ( DomainRentCarOrderModel domainRentCarOrderModel : list ) {
            list1.add( domainRentCarOrderModelToApiRentCarOrderResponseDto( domainRentCarOrderModel ) );
        }

        return list1;
    }
}
