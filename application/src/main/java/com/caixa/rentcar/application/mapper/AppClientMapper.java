package com.caixa.rentcar.application.mapper;

import com.caixa.rentcar.application.model.ApiClientDto;
import com.caixa.rentcar.application.model.ApiClientRecordDto;
import com.caixa.rentcar.application.model.ApiRentCarOrderClientInfoDto;
import com.caixa.rentcar.application.model.ApiResponseDto;
import com.caixa.rentcar.domain.model.DomainApiResponseModel;
import com.caixa.rentcar.domain.model.DomainClientModel;

import com.caixa.rentcar.domain.model.DomainRentCarOrderClientModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface AppClientMapper {
    List<DomainClientModel> toDomainClientList(List<ApiClientRecordDto> apiClientListDto);

    @Mapping(target="orderHistory",source="orderHistory")
    ApiClientDto toClientDto(DomainClientModel domainClientModel);
    ApiResponseDto toApiResponseDto(DomainApiResponseModel domainApiResponseModel);

    @Mapping(source="startDate", target = "startDate", dateFormat = "yyyy-MM-dd")
    @Mapping(source="endDate", target = "endDate", dateFormat = "yyyy-MM-dd")
    @Mapping(source="returnDate", target = "returnDate", dateFormat = "yyyy-MM-dd")
    ApiRentCarOrderClientInfoDto toApiRentCarOrderClientInfoDto(DomainRentCarOrderClientModel domainRentCarOrderClientModelList);

}
