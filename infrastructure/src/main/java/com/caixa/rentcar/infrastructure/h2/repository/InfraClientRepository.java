package com.caixa.rentcar.infrastructure.h2.repository;

import com.caixa.rentcar.infrastructure.h2.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfraClientRepository extends JpaRepository<ClientEntity, Long> {

    @Query(nativeQuery = true, value ="SELECT c.* FROM clients c order by c.dni")
    List<ClientEntity> getAll();
    @Query(nativeQuery = true, value ="SELECT c.* FROM clients c where c.dni=?1")
    ClientEntity findClientByDni(String clientDni);
    @Query(nativeQuery = true, value ="SELECT c.* FROM clients c where c.dni in (:clients)")
    List<ClientEntity> findClientByDniList(@Param("clients") List<String> clients);

}