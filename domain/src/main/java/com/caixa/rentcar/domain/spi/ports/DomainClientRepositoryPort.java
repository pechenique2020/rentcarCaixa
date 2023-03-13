package com.caixa.rentcar.domain.spi.ports;

import com.caixa.rentcar.domain.model.DomainClientModel;

import java.util.List;

public interface DomainClientRepositoryPort {
    DomainClientModel findClientByDni(String clientDni);
    List<DomainClientModel> findClientByDniList(List<String> clientDniList);
    void saveClient(List<DomainClientModel> clientDniList);

}
