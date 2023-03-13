package com.caixa.rentcar.application.mapper;

import com.caixa.rentcar.application.model.ApiCarInfoDto;
import com.caixa.rentcar.application.model.ApiResponseDto;
import com.caixa.rentcar.domain.model.DomainApiResponseModel;
import com.caixa.rentcar.domain.model.DomainCarModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface AppCarMapper {
    DomainCarModel toDomainCarInfo(ApiCarInfoDto apiCarInfoDto);
    ApiCarInfoDto toCarDto(DomainCarModel domainCarInfoModel);
    List<ApiCarInfoDto> toCarInfoListDto(List<DomainCarModel> domainCarInfoListModel);
    ApiResponseDto toApiResponseDto(DomainApiResponseModel domainApiResponseModel);
}
