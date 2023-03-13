package com.caixa.rentcar.application.rest;

import com.caixa.rentcar.application.api.CarApi;
import com.caixa.rentcar.application.mapper.AppCarMapper;
import com.caixa.rentcar.application.model.ApiCarInfoDto;
import com.caixa.rentcar.application.model.ApiResponseDto;
import com.caixa.rentcar.domain.api.ports.DomainCarServicePort;
import com.caixa.rentcar.domain.model.DomainApiResponseModel;
import com.caixa.rentcar.domain.shared.constants.DomainMessages;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@Api(tags = {"inventory"})
public class ApiCarController implements CarApi {

    private final AppCarMapper carMapper;
    private final DomainCarServicePort domainCarServicePort;

    @Override
    @Hidden
    @GetMapping(value=("car/inventory/list"))
    public ResponseEntity<List<ApiCarInfoDto>> getCarInventory() {
        try {
            return ResponseEntity.ok(carMapper.toCarInfoListDto(domainCarServicePort.getCarInventory()));
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @Hidden
    @GetMapping(value = "car/inventory")
    public ResponseEntity<ApiCarInfoDto> findCarInventoryByCarPlate(@RequestParam("car_plate") String carPlate) {
        try {
            return ResponseEntity.ok(carMapper.toCarDto(domainCarServicePort.findCarInventoryByCarPlate(carPlate)));
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
