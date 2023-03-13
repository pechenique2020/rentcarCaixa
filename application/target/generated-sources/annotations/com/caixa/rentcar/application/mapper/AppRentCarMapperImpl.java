package com.caixa.rentcar.application.mapper;

import com.caixa.rentcar.application.model.ApiRentCarOrderDetailDto;
import com.caixa.rentcar.application.model.ApiRentCarOrderDto;
import com.caixa.rentcar.application.model.ApiRentCarOrderResponseDto;
import com.caixa.rentcar.application.model.ApiResponseDto;
import com.caixa.rentcar.domain.model.DomainApiResponseModel;
import com.caixa.rentcar.domain.model.DomainRentCarOrderClientModel;
import com.caixa.rentcar.domain.model.DomainRentCarOrderModel;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-13T09:38:17+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class AppRentCarMapperImpl implements AppRentCarMapper {

    @Override
    public DomainRentCarOrderModel toDomainRentCarOrder(ApiRentCarOrderDto apiRentCarOrderDto) {
        if ( apiRentCarOrderDto == null ) {
            return null;
        }

        DomainRentCarOrderModel.DomainRentCarOrderModelBuilder domainRentCarOrderModel = DomainRentCarOrderModel.builder();

        domainRentCarOrderModel.id( apiRentCarOrderDto.getId() );
        domainRentCarOrderModel.clientDni( apiRentCarOrderDto.getClientDni() );
        domainRentCarOrderModel.carPlate( apiRentCarOrderDto.getCarPlate() );
        if ( apiRentCarOrderDto.getStartDate() != null ) {
            domainRentCarOrderModel.startDate( Date.from( apiRentCarOrderDto.getStartDate().atStartOfDay( ZoneOffset.UTC ).toInstant() ) );
        }
        if ( apiRentCarOrderDto.getEndDate() != null ) {
            domainRentCarOrderModel.endDate( Date.from( apiRentCarOrderDto.getEndDate().atStartOfDay( ZoneOffset.UTC ).toInstant() ) );
        }

        return domainRentCarOrderModel.build();
    }

    @Override
    public ApiRentCarOrderDto toRentCarOrderDto(DomainRentCarOrderModel domainRentCarOrderModel) {
        if ( domainRentCarOrderModel == null ) {
            return null;
        }

        ApiRentCarOrderDto apiRentCarOrderDto = new ApiRentCarOrderDto();

        apiRentCarOrderDto.setId( domainRentCarOrderModel.getId() );
        apiRentCarOrderDto.setClientDni( domainRentCarOrderModel.getClientDni() );
        apiRentCarOrderDto.setCarPlate( domainRentCarOrderModel.getCarPlate() );
        if ( domainRentCarOrderModel.getStartDate() != null ) {
            apiRentCarOrderDto.setStartDate( LocalDateTime.ofInstant( domainRentCarOrderModel.getStartDate().toInstant(), ZoneOffset.UTC ).toLocalDate() );
        }
        if ( domainRentCarOrderModel.getEndDate() != null ) {
            apiRentCarOrderDto.setEndDate( LocalDateTime.ofInstant( domainRentCarOrderModel.getEndDate().toInstant(), ZoneOffset.UTC ).toLocalDate() );
        }

        return apiRentCarOrderDto;
    }

    @Override
    public DomainRentCarOrderClientModel toDomainRentCarOrderInfo(ApiRentCarOrderDetailDto apiRentCarOrderInfoDto) {
        if ( apiRentCarOrderInfoDto == null ) {
            return null;
        }

        DomainRentCarOrderClientModel.DomainRentCarOrderClientModelBuilder domainRentCarOrderClientModel = DomainRentCarOrderClientModel.builder();

        domainRentCarOrderClientModel.id( apiRentCarOrderInfoDto.getId() );
        domainRentCarOrderClientModel.carPlate( apiRentCarOrderInfoDto.getCarPlate() );
        domainRentCarOrderClientModel.carDetail( apiRentCarOrderInfoDto.getCarDetail() );
        try {
            if ( apiRentCarOrderInfoDto.getStartDate() != null ) {
                domainRentCarOrderClientModel.startDate( new SimpleDateFormat().parse( apiRentCarOrderInfoDto.getStartDate() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        try {
            if ( apiRentCarOrderInfoDto.getEndDate() != null ) {
                domainRentCarOrderClientModel.endDate( new SimpleDateFormat().parse( apiRentCarOrderInfoDto.getEndDate() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        try {
            if ( apiRentCarOrderInfoDto.getReturnDate() != null ) {
                domainRentCarOrderClientModel.returnDate( new SimpleDateFormat().parse( apiRentCarOrderInfoDto.getReturnDate() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }

        return domainRentCarOrderClientModel.build();
    }

    @Override
    public ApiRentCarOrderDetailDto toRentCarOrderInfoDto(DomainRentCarOrderClientModel domainRentCarOrderInfoModel) {
        if ( domainRentCarOrderInfoModel == null ) {
            return null;
        }

        ApiRentCarOrderDetailDto apiRentCarOrderDetailDto = new ApiRentCarOrderDetailDto();

        if ( domainRentCarOrderInfoModel.getStartDate() != null ) {
            apiRentCarOrderDetailDto.setStartDate( new SimpleDateFormat( "yyyy-MM-dd" ).format( domainRentCarOrderInfoModel.getStartDate() ) );
        }
        if ( domainRentCarOrderInfoModel.getEndDate() != null ) {
            apiRentCarOrderDetailDto.setEndDate( new SimpleDateFormat( "yyyy-MM-dd" ).format( domainRentCarOrderInfoModel.getEndDate() ) );
        }
        if ( domainRentCarOrderInfoModel.getReturnDate() != null ) {
            apiRentCarOrderDetailDto.setReturnDate( new SimpleDateFormat( "yyyy-MM-dd" ).format( domainRentCarOrderInfoModel.getReturnDate() ) );
        }
        apiRentCarOrderDetailDto.setId( domainRentCarOrderInfoModel.getId() );
        apiRentCarOrderDetailDto.setCarPlate( domainRentCarOrderInfoModel.getCarPlate() );
        apiRentCarOrderDetailDto.setCarDetail( domainRentCarOrderInfoModel.getCarDetail() );

        return apiRentCarOrderDetailDto;
    }

    @Override
    public ApiResponseDto toApiResponseDto(DomainApiResponseModel domainApiResponseModel) {
        if ( domainApiResponseModel == null ) {
            return null;
        }

        ApiResponseDto apiResponseDto = new ApiResponseDto();

        apiResponseDto.setOrders( domainRentCarOrderModelListToApiRentCarOrderResponseDtoList( domainApiResponseModel.getOrders() ) );
        apiResponseDto.setCode( (long) domainApiResponseModel.getCode() );
        apiResponseDto.setType( domainApiResponseModel.getType() );
        apiResponseDto.setMessage( domainApiResponseModel.getMessage() );

        return apiResponseDto;
    }

    @Override
    public List<DomainRentCarOrderModel> toDomainCarList(List<ApiRentCarOrderDto> apiRentCarOrderListDto) {
        if ( apiRentCarOrderListDto == null ) {
            return null;
        }

        List<DomainRentCarOrderModel> list = new ArrayList<DomainRentCarOrderModel>( apiRentCarOrderListDto.size() );
        for ( ApiRentCarOrderDto apiRentCarOrderDto : apiRentCarOrderListDto ) {
            list.add( toDomainRentCarOrder( apiRentCarOrderDto ) );
        }

        return list;
    }

    @Override
    public ApiRentCarOrderResponseDto toApiRentCarOrderResponseDto(DomainRentCarOrderModel domainRentCarOrderModel) {
        if ( domainRentCarOrderModel == null ) {
            return null;
        }

        ApiRentCarOrderResponseDto apiRentCarOrderResponseDto = new ApiRentCarOrderResponseDto();

        if ( domainRentCarOrderModel.getStartDate() != null ) {
            apiRentCarOrderResponseDto.setStartDate( new SimpleDateFormat( "yyyy-MM-dd" ).format( domainRentCarOrderModel.getStartDate() ) );
        }
        if ( domainRentCarOrderModel.getEndDate() != null ) {
            apiRentCarOrderResponseDto.setEndDate( new SimpleDateFormat( "yyyy-MM-dd" ).format( domainRentCarOrderModel.getEndDate() ) );
        }
        if ( domainRentCarOrderModel.getReturnDate() != null ) {
            apiRentCarOrderResponseDto.setReturnDate( new SimpleDateFormat( "yyyy-MM-dd" ).format( domainRentCarOrderModel.getReturnDate() ) );
        }
        apiRentCarOrderResponseDto.setId( domainRentCarOrderModel.getId() );
        apiRentCarOrderResponseDto.setClientDni( domainRentCarOrderModel.getClientDni() );
        apiRentCarOrderResponseDto.setCarPlate( domainRentCarOrderModel.getCarPlate() );
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
            list1.add( toApiRentCarOrderResponseDto( domainRentCarOrderModel ) );
        }

        return list1;
    }
}
