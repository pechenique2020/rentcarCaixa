package com.caixa.rentcar.infrastructure.h2.repository;

import com.caixa.rentcar.infrastructure.h2.entity.RentCarOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfraRentCarOrderRepository extends JpaRepository<RentCarOrderEntity, Long> {

    @Query(nativeQuery = true, value ="SELECT ro.* FROM rentcar_orders ro where ro.id=?1")
    RentCarOrderEntity findRentCarOrder(String rentcarId);
    @Query(nativeQuery = true, value ="SELECT ro.* FROM rentcar_orders ro where ro.car_plate=?1 and ro.return_date is null")
    RentCarOrderEntity findRentCarOrderByRentcarOder(String carPlate);

}