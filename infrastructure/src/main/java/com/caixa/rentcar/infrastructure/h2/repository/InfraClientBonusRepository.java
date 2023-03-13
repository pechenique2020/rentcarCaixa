package com.caixa.rentcar.infrastructure.h2.repository;

import com.caixa.rentcar.infrastructure.h2.entity.ClientBonusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InfraClientBonusRepository extends JpaRepository<ClientBonusEntity, Long> {
    @Query(nativeQuery = true, value ="SELECT sum(cb.points) as loyalty FROM client_bonus cb where cb.dni=?1")
    int findClientBonus(String clientDni);
}