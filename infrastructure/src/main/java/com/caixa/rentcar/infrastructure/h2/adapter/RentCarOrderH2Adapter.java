package com.caixa.rentcar.infrastructure.h2.adapter;

import com.caixa.rentcar.domain.model.DomainRentCarOrderClientModel;
import com.caixa.rentcar.domain.model.DomainRentCarOrderModel;
import com.caixa.rentcar.domain.spi.ports.DomainRentCarOrderRepositoryPort;
import com.caixa.rentcar.infrastructure.h2.mapper.RentCarOrderDboMapper;
import com.caixa.rentcar.infrastructure.h2.repository.InfraRentCarOrderClientRepository;
import com.caixa.rentcar.infrastructure.h2.repository.InfraRentCarOrderRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
@Slf4j
public class RentCarOrderH2Adapter implements DomainRentCarOrderRepositoryPort {
    
    InfraRentCarOrderRepository rentCarOrderRepository;
    InfraRentCarOrderClientRepository rentCarOrderClientRepository;

    RentCarOrderDboMapper rentCarOrderMapper;

    @Override
    public DomainRentCarOrderClientModel findRentCarOrder(String rentcarId) {
        log.debug("findClientByDni()");
        return rentCarOrderMapper.toDomainInfo(rentCarOrderRepository.findRentCarOrder(rentcarId));
    }
    @Override
    public DomainRentCarOrderModel findRentCarOrderByRentcarOder(String carPlate) {
        log.debug("findRentCarOrderByRentcarOder()");
        return rentCarOrderMapper.toDomain(rentCarOrderRepository.findRentCarOrderByRentcarOder(carPlate));
    }
    @Override
    public List<DomainRentCarOrderModel> createRentCarOrder(List<DomainRentCarOrderModel> domainRentCarOrderListModel) {
        log.debug("findClientByDni()");
        return rentCarOrderMapper.toDomainList(rentCarOrderRepository.saveAll(rentCarOrderMapper.toListDbo(domainRentCarOrderListModel)));
    }
    @Override
    public void completeRentCarOrder(DomainRentCarOrderModel domainRentCarOrderModel ) {
        log.debug("completeRentCarOrder()");
        rentCarOrderRepository.save(rentCarOrderMapper.toDbo(domainRentCarOrderModel));
    }

}
