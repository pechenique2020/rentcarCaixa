package com.caixa.rentcar.infrastructure.h2.adapter;

import com.caixa.rentcar.domain.model.DomainPriceItemsModel;
import com.caixa.rentcar.domain.spi.ports.DomainPriceItemsRepositoryPort;
import com.caixa.rentcar.infrastructure.h2.mapper.PriceItemsDboMapper;
import com.caixa.rentcar.infrastructure.h2.repository.InfraPriceItemsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
@Slf4j
public class PriceItemsH2Adapter implements DomainPriceItemsRepositoryPort {
    
    InfraPriceItemsRepository priceItemsRepository;
    PriceItemsDboMapper priceItemsMapper;

    @Override
    public List<DomainPriceItemsModel> findPriceItemsByType(String carType) {
        log.debug("findPriceItemsByType()");
        return priceItemsMapper.toDomainList(priceItemsRepository.findPriceItemsByType(carType));
    }
}
