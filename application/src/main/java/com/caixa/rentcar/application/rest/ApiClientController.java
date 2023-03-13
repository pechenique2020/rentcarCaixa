package com.caixa.rentcar.application.rest;

import com.caixa.rentcar.application.api.ClientApi;
import com.caixa.rentcar.application.mapper.AppClientMapper;
import com.caixa.rentcar.application.model.ApiClientDto;
import com.caixa.rentcar.application.model.ApiClientRecordDto;
import com.caixa.rentcar.application.model.ApiResponseDto;
import com.caixa.rentcar.domain.api.ports.DomainClientServicePort;
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
@Api(tags = {"client"})
public class ApiClientController implements ClientApi {

    private final AppClientMapper clientMapper;
    private final DomainClientServicePort domainClientServicePort;

    @Override
    @Hidden
    @GetMapping(value="client/{client_dni}")
    public ResponseEntity<ApiClientDto> findClientByDni(@PathVariable String client_dni) {
        try {
            return ResponseEntity.ok(clientMapper.toClientDto(domainClientServicePort.findClientByDni(client_dni)));
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @Override
    @Hidden
    @PostMapping(value="client")
    public ResponseEntity<ApiResponseDto> createClient(@RequestBody List<ApiClientRecordDto> apiClientRecordListDto) {
        try {
            return ResponseEntity.ok(clientMapper.toApiResponseDto(domainClientServicePort.createClient(clientMapper.toDomainClientList(apiClientRecordListDto))));
        }catch(Exception e){
            return ResponseEntity.internalServerError().body(clientMapper.toApiResponseDto(new DomainApiResponseModel(DomainMessages.OPERATION_KO_CODE, DomainMessages.OPERATION_KO_TEXT, e.getMessage(),new ArrayList<>())));
        }
    }
}
