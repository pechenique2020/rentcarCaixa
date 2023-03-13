package com.caixa.rentcar.springboot.config;

import com.caixa.rentcar.domain.api.ports.*;
import com.caixa.rentcar.domain.spi.ports.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.caixa.rentcar"})
@EnableJpaRepositories(basePackages={"com.caixa.rentcar.infrastructure.h2.repository"})
@EntityScan(basePackages={"com.caixa.rentcar.infrastructure.h2.entity"})
@EnableTransactionManagement
public class SpringbootRestApplication
{
    public static void main(String[] args) {
        SpringApplication.run(SpringbootRestApplication.class, args);
    }

    @Bean
    DomainClientServicePort getDomainClientServicePort(final DomainClientRepositoryPort domainClientRepositoryPort, final DomainClientBonusRepositoryPort domainClientBonusRepositoryPort, final DomainRentCarOrderClientRepositoryPort domainRentCarOrderClientRepositoryPort){
        return new DomainClientServicePortImpl(domainClientRepositoryPort,domainClientBonusRepositoryPort,domainRentCarOrderClientRepositoryPort);
    }
    @Bean
    DomainCarServicePort getDomainCarServicePort(final DomainCarRepositoryPort domainCarRepositoryPort){
        return new DomainCarServicePortImpl(domainCarRepositoryPort);
    }
    @Bean
    DomainRentCarServicePort getDomainRentCarServicePort(final DomainRentCarOrderRepositoryPort domainRentCarOrderRepositoryPort,final DomainClientBonusRepositoryPort domainClientBonusRepositoryPort, final DomainClientRepositoryPort domainClientRepositoryPort, final DomainCarRepositoryPort domainCarRepositoryPort,final DomainPricesRepositoryPort domainPricesRepositoryPort, final DomainPriceItemsRepositoryPort domainPriceItemsRepositoryPort ){
        return new DomainRentCarServicePortImpl(domainRentCarOrderRepositoryPort,domainClientBonusRepositoryPort,domainClientRepositoryPort,domainCarRepositoryPort,domainPricesRepositoryPort,domainPriceItemsRepositoryPort);
    }

}
