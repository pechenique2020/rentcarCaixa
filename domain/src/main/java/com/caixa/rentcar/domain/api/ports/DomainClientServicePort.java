package com.caixa.rentcar.domain.api.ports;

import com.caixa.rentcar.domain.model.DomainApiResponseModel;
import com.caixa.rentcar.domain.model.DomainClientModel;

import java.util.List;

public interface DomainClientServicePort {
    DomainClientModel findClientByDni(String clientDni);
    DomainApiResponseModel createClient(List<DomainClientModel> clientList);


}
