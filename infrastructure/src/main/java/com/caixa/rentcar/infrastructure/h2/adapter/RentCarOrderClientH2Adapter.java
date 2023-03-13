package com.caixa.rentcar.infrastructure.h2.adapter;

import com.caixa.rentcar.domain.model.DomainRentCarOrderClientModel;
import com.caixa.rentcar.domain.spi.ports.DomainRentCarOrderClientRepositoryPort;
import com.caixa.rentcar.infrastructure.h2.mapper.RentCarOrderClientDboMapper;
import com.caixa.rentcar.infrastructure.h2.repository.InfraRentCarOrderClientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
@Slf4j
public class RentCarOrderClientH2Adapter implements DomainRentCarOrderClientRepositoryPort {
    
    InfraRentCarOrderClientRepository rentCarOrderClientRepository;

    RentCarOrderClientDboMapper rentCarOrderClientMapper;

    @Override
    public List<DomainRentCarOrderClientModel> findRentCarOrderByClientDni(String clientDni) {
        log.debug("findRentCarOrderByClientId()");
        return rentCarOrderClientMapper.toDomainList(rentCarOrderClientRepository.findRentCarOrderByClientDni(clientDni));
    }

}
