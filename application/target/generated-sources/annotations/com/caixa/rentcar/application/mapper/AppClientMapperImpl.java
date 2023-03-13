package com.caixa.rentcar.application.mapper;

import com.caixa.rentcar.application.model.ApiClientDto;
import com.caixa.rentcar.application.model.ApiClientRecordDto;
import com.caixa.rentcar.application.model.ApiRentCarOrderClientInfoDto;
import com.caixa.rentcar.application.model.ApiRentCarOrderResponseDto;
import com.caixa.rentcar.application.model.ApiResponseDto;
import com.caixa.rentcar.domain.model.DomainApiResponseModel;
import com.caixa.rentcar.domain.model.DomainClientModel;
import com.caixa.rentcar.domain.model.DomainRentCarOrderClientModel;
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
public class AppClientMapperImpl implements AppClientMapper {

    @Override
    public List<DomainClientModel> toDomainClientList(List<ApiClientRecordDto> apiClientListDto) {
        if ( apiClientListDto == null ) {
            return null;
        }

        List<DomainClientModel> list = new ArrayList<DomainClientModel>( apiClientListDto.size() );
        for ( ApiClientRecordDto apiClientRecordDto : apiClientListDto ) {
            list.add( apiClientRecordDtoToDomainClientModel( apiClientRecordDto ) );
        }

        return list;
    }

    @Override
    public ApiClientDto toClientDto(DomainClientModel domainClientModel) {
        if ( domainClientModel == null ) {
            return null;
        }

        ApiClientDto apiClientDto = new ApiClientDto();

        apiClientDto.setOrderHistory( domainRentCarOrderClientModelListToApiRentCarOrderClientInfoDtoList( domainClientModel.getOrderHistory() ) );
        apiClientDto.setId( domainClientModel.getId() );
        apiClientDto.setDni( domainClientModel.getDni() );
        apiClientDto.setName( domainClientModel.getName() );
        apiClientDto.setSurname( domainClientModel.getSurname() );
        if ( domainClientModel.getGender() != null ) {
            apiClientDto.setGender( Enum.valueOf( ApiClientDto.GenderEnum.class, domainClientModel.getGender() ) );
        }
        apiClientDto.setLoyalty( (long) domainClientModel.getLoyalty() );
        if ( domainClientModel.getCreatedOn() != null ) {
            apiClientDto.setCreatedOn( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( domainClientModel.getCreatedOn() ) );
        }

        return apiClientDto;
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

    @Override
    public ApiRentCarOrderClientInfoDto toApiRentCarOrderClientInfoDto(DomainRentCarOrderClientModel domainRentCarOrderClientModelList) {
        if ( domainRentCarOrderClientModelList == null ) {
            return null;
        }

        ApiRentCarOrderClientInfoDto apiRentCarOrderClientInfoDto = new ApiRentCarOrderClientInfoDto();

        if ( domainRentCarOrderClientModelList.getStartDate() != null ) {
            apiRentCarOrderClientInfoDto.setStartDate( new SimpleDateFormat( "yyyy-MM-dd" ).format( domainRentCarOrderClientModelList.getStartDate() ) );
        }
        if ( domainRentCarOrderClientModelList.getEndDate() != null ) {
            apiRentCarOrderClientInfoDto.setEndDate( new SimpleDateFormat( "yyyy-MM-dd" ).format( domainRentCarOrderClientModelList.getEndDate() ) );
        }
        if ( domainRentCarOrderClientModelList.getReturnDate() != null ) {
            apiRentCarOrderClientInfoDto.setReturnDate( new SimpleDateFormat( "yyyy-MM-dd" ).format( domainRentCarOrderClientModelList.getReturnDate() ) );
        }
        apiRentCarOrderClientInfoDto.setId( domainRentCarOrderClientModelList.getId() );
        apiRentCarOrderClientInfoDto.setCarPlate( domainRentCarOrderClientModelList.getCarPlate() );
        if ( domainRentCarOrderClientModelList.getPrice() != null ) {
            apiRentCarOrderClientInfoDto.setPrice( BigDecimal.valueOf( domainRentCarOrderClientModelList.getPrice() ) );
        }
        apiRentCarOrderClientInfoDto.setStatus( domainRentCarOrderClientModelList.getStatus() );
        if ( domainRentCarOrderClientModelList.getCreatedOn() != null ) {
            apiRentCarOrderClientInfoDto.setCreatedOn( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( domainRentCarOrderClientModelList.getCreatedOn() ) );
        }

        return apiRentCarOrderClientInfoDto;
    }

    protected DomainClientModel apiClientRecordDtoToDomainClientModel(ApiClientRecordDto apiClientRecordDto) {
        if ( apiClientRecordDto == null ) {
            return null;
        }

        DomainClientModel.DomainClientModelBuilder domainClientModel = DomainClientModel.builder();

        domainClientModel.id( apiClientRecordDto.getId() );
        domainClientModel.dni( apiClientRecordDto.getDni() );
        domainClientModel.name( apiClientRecordDto.getName() );
        domainClientModel.surname( apiClientRecordDto.getSurname() );
        if ( apiClientRecordDto.getGender() != null ) {
            domainClientModel.gender( apiClientRecordDto.getGender().name() );
        }
        if ( apiClientRecordDto.getCreatedOn() != null ) {
            domainClientModel.createdOn( LocalDateTime.parse( apiClientRecordDto.getCreatedOn() ) );
        }

        return domainClientModel.build();
    }

    protected List<ApiRentCarOrderClientInfoDto> domainRentCarOrderClientModelListToApiRentCarOrderClientInfoDtoList(List<DomainRentCarOrderClientModel> list) {
        if ( list == null ) {
            return null;
        }

        List<ApiRentCarOrderClientInfoDto> list1 = new ArrayList<ApiRentCarOrderClientInfoDto>( list.size() );
        for ( DomainRentCarOrderClientModel domainRentCarOrderClientModel : list ) {
            list1.add( toApiRentCarOrderClientInfoDto( domainRentCarOrderClientModel ) );
        }

        return list1;
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
