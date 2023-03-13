package com.caixa.rentcar.infrastructure.h2.adapter;

import com.caixa.rentcar.domain.model.DomainClientBonusModel;
import com.caixa.rentcar.domain.model.DomainClientModel;
import com.caixa.rentcar.domain.spi.ports.DomainClientBonusRepositoryPort;
import com.caixa.rentcar.infrastructure.h2.mapper.ClientBonusDboMapper;
import com.caixa.rentcar.infrastructure.h2.mapper.ClientDboMapper;
import com.caixa.rentcar.infrastructure.h2.repository.InfraClientBonusRepository;
import com.caixa.rentcar.infrastructure.h2.repository.InfraClientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
@Slf4j
public class ClientBonusH2Adapter implements DomainClientBonusRepositoryPort {
    
    InfraClientBonusRepository clientBonusRepository;
    ClientBonusDboMapper clientBonusMapper;

    @Override
    public void addBonus(DomainClientBonusModel domainClientBonusModel) {
        log.debug("addBonus()");
        clientBonusRepository.save(clientBonusMapper.toDbo(domainClientBonusModel));
    }

    @Override
    public int findClientBonus(String clientDni) {
        log.debug("findClientBonus()");
        return clientBonusRepository.findClientBonus(clientDni);
    }

}
