package com.caixa.rentcar.infrastructure.h2.repository;

import com.caixa.rentcar.infrastructure.h2.entity.PriceItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfraPriceItemsRepository extends JpaRepository<PriceItemsEntity, Long> {

    @Query(nativeQuery = true, value ="SELECT pi.* FROM prices p inner join price_items pi on pi.price_id=p.id where p.type=?1 order by pi.id")
    List<PriceItemsEntity> findPriceItemsByType(String carType);
}