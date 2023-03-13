package com.caixa.rentcar.infrastructure.h2.adapter;

import com.caixa.rentcar.domain.model.DomainCarModel;
import com.caixa.rentcar.domain.model.DomainPricesModel;
import com.caixa.rentcar.domain.spi.ports.DomainPricesRepositoryPort;
import com.caixa.rentcar.infrastructure.h2.mapper.PricesDboMapper;
import com.caixa.rentcar.infrastructure.h2.repository.InfraPricesRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
@Slf4j
public class PricesH2Adapter implements DomainPricesRepositoryPort {
    
    InfraPricesRepository pricesRepository;
    PricesDboMapper pricesMapper;

    @Override
    public DomainPricesModel findPriceByType(String carType) {
        log.debug("findPriceByType()");
        return pricesMapper.toDomain(pricesRepository.findPriceByType(carType));
    }
}
