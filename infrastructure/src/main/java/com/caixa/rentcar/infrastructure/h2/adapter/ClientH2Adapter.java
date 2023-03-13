package com.caixa.rentcar.infrastructure.h2.adapter;

import com.caixa.rentcar.domain.model.DomainClientModel;
import com.caixa.rentcar.domain.spi.ports.DomainClientRepositoryPort;
import com.caixa.rentcar.infrastructure.h2.entity.ClientEntity;
import com.caixa.rentcar.infrastructure.h2.mapper.ClientDboMapper;
import com.caixa.rentcar.infrastructure.h2.repository.InfraClientRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
@Slf4j
public class ClientH2Adapter implements DomainClientRepositoryPort {
    
    InfraClientRepository clientRepository;
    ClientDboMapper clientMapper;


    @Override
    public DomainClientModel findClientByDni(String clientDni) {
        log.debug("findClientByDni()");
        return clientMapper.toDomain(clientRepository.findClientByDni(clientDni));
    }
    @Override
    public List<DomainClientModel> findClientByDniList(List<String> clientDniList) {
        log.debug("findClientByDniList()");
        return clientMapper.toDomainList(clientRepository.findClientByDniList(clientDniList));
    }
    @Override
    public void saveClient(List<DomainClientModel> clientDniList) {
        log.debug("createClient()");
        clientRepository.saveAll(clientMapper.toDboList(clientDniList));
    }
}
