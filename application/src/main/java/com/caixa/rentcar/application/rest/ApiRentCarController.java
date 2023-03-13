package com.caixa.rentcar.application.rest;

import com.caixa.rentcar.application.api.RentcarApi;
import com.caixa.rentcar.application.mapper.AppRentCarMapper;
import com.caixa.rentcar.application.model.ApiRentCarOrderDetailDto;
import com.caixa.rentcar.application.model.ApiRentCarOrderDto;
import com.caixa.rentcar.application.model.ApiResponseDto;
import com.caixa.rentcar.domain.api.ports.DomainRentCarServicePort;
import com.caixa.rentcar.domain.model.DomainApiResponseModel;
import com.caixa.rentcar.domain.shared.constants.DomainMessages;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@Api(tags = {"rentcar"})
public class ApiRentCarController implements RentcarApi {

    private final AppRentCarMapper rentCarMapper;
    private final DomainRentCarServicePort domainRentCarServicePort;
    @Override
    @Hidden
    @GetMapping(value="rentcar/{rentcarId}")
    public ResponseEntity<ApiRentCarOrderDetailDto> findRentCarOrder(@PathVariable String rentcarId) {
        try {
            return ResponseEntity.ok(rentCarMapper.toRentCarOrderInfoDto(domainRentCarServicePort.findRentCarOrder(rentcarId)));
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @Hidden
    @PostMapping(value="rentcar")
    public ResponseEntity<ApiResponseDto> createRentCarOrder(@RequestBody List<ApiRentCarOrderDto> apiRentCarOrderListDto) {
        try {
           return ResponseEntity.ok(rentCarMapper.toApiResponseDto(domainRentCarServicePort.createRentCarOrder(rentCarMapper.toDomainCarList(apiRentCarOrderListDto))));
        }catch(Exception e){
            return ResponseEntity.internalServerError().body(rentCarMapper.toApiResponseDto(new DomainApiResponseModel(DomainMessages.OPERATION_KO_CODE, DomainMessages.OPERATION_KO_TEXT, e.getMessage(),new ArrayList<>())));
        }
    }

    @Override
    @Hidden
    @PostMapping(value = "rentcar/return")
    public ResponseEntity<ApiResponseDto> completeRentCarOrder(@RequestParam("car_plate") String carPlate, @RequestParam("return_date") String returnDate) {
        try {
           return ResponseEntity.ok(rentCarMapper.toApiResponseDto(domainRentCarServicePort.completeRentCarOrder(carPlate,returnDate)));
        }catch(Exception e){
            return ResponseEntity.internalServerError().body(rentCarMapper.toApiResponseDto(new DomainApiResponseModel(DomainMessages.OPERATION_KO_CODE, DomainMessages.OPERATION_KO_TEXT, e.getMessage(),new ArrayList<>())));
        }
    }

}
