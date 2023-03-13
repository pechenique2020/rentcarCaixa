package com.caixa.rentcar.infrastructure.h2.repository;

import com.caixa.rentcar.infrastructure.h2.entity.RentCarOrderClientEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfraRentCarOrderClientRepository extends JpaRepository<RentCarOrderClientEntity, Long> {

     @Query(nativeQuery = true, value ="SELECT ro.* FROM rentcar_orders ro where ro.client_dni=?1")
     List<RentCarOrderClientEntity> findRentCarOrderByClientDni(String clientDni);
}