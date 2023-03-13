package com.caixa.rentcar.infrastructure.h2.repository;

import com.caixa.rentcar.infrastructure.h2.entity.CarEntity;
import com.caixa.rentcar.infrastructure.h2.entity.PricesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfraPricesRepository extends JpaRepository<PricesEntity, Long> {

    @Query(nativeQuery = true, value ="SELECT p.* FROM prices p where p.type=?1 order by p.id")
    PricesEntity findPriceByType(String carType);
}