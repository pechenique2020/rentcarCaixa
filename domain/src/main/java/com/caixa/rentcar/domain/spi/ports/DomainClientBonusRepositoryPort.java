package com.caixa.rentcar.domain.spi.ports;

import com.caixa.rentcar.domain.model.DomainClientBonusModel;
import com.caixa.rentcar.domain.model.DomainClientModel;

public interface DomainClientBonusRepositoryPort {
    void addBonus(DomainClientBonusModel domainClientBonusModel);

    int findClientBonus(String clientDni);

}
