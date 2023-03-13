package com.caixa.rentcar.application.mapper;

import com.caixa.rentcar.application.model.ApiRentCarOrderDetailDto;
import com.caixa.rentcar.application.model.ApiRentCarOrderDto;
import com.caixa.rentcar.application.model.ApiRentCarOrderResponseDto;
import com.caixa.rentcar.application.model.ApiResponseDto;
import com.caixa.rentcar.domain.model.DomainApiResponseModel;
import com.caixa.rentcar.domain.model.DomainRentCarOrderClientModel;
import com.caixa.rentcar.domain.model.DomainRentCarOrderModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.List;

@Mapper
public interface AppRentCarMapper {
    DomainRentCarOrderModel toDomainRentCarOrder(ApiRentCarOrderDto apiRentCarOrderDto);
    ApiRentCarOrderDto toRentCarOrderDto(DomainRentCarOrderModel domainRentCarOrderModel);
    DomainRentCarOrderClientModel toDomainRentCarOrderInfo(ApiRentCarOrderDetailDto apiRentCarOrderInfoDto);

    @Mapping(source="startDate", target = "startDate", dateFormat = "yyyy-MM-dd")
    @Mapping(source="endDate", target = "endDate", dateFormat = "yyyy-MM-dd")
    @Mapping(source="returnDate", target = "returnDate", dateFormat = "yyyy-MM-dd")
    ApiRentCarOrderDetailDto toRentCarOrderInfoDto(DomainRentCarOrderClientModel domainRentCarOrderInfoModel);

    @Mapping(target="orders",source="orders")
    ApiResponseDto toApiResponseDto(DomainApiResponseModel domainApiResponseModel);
    List<DomainRentCarOrderModel> toDomainCarList(List<ApiRentCarOrderDto> apiRentCarOrderListDto);

    @Mapping(source="startDate", target = "startDate", dateFormat = "yyyy-MM-dd")
    @Mapping(source="endDate", target = "endDate", dateFormat = "yyyy-MM-dd")
    @Mapping(source="returnDate", target = "returnDate", dateFormat = "yyyy-MM-dd")
    ApiRentCarOrderResponseDto toApiRentCarOrderResponseDto(DomainRentCarOrderModel domainRentCarOrderModel);
}
