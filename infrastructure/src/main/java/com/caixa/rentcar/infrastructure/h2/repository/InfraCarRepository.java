package com.caixa.rentcar.infrastructure.h2.repository;

import com.caixa.rentcar.infrastructure.h2.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfraCarRepository extends JpaRepository<CarEntity, Long> {

    @Query(nativeQuery = true, value ="SELECT c.id, c.plate, c.year, c.make, c.model, c.type, c.created_on FROM cars c order by c.plate")
    List<CarEntity> getCarInventory();
    @Query(nativeQuery = true, value ="SELECT c.* FROM cars c where c.plate=?1 order by c.plate")
    CarEntity findCarInventoryByCarPlate(String carPlate);
    @Query(nativeQuery = true, value ="SELECT c.* FROM cars c where c.plate in (:carPlateList)")
    List<CarEntity> findCarInventoryByCarPlateList(@Param("carPlateList") List<String> carPlateList);
    @Query(nativeQuery = true, value ="SELECT c.* FROM cars c "+
                                      "inner join rentcar_orders ro on c.plate=ro.car_plate and ro.return_date is null "+
                                      "where c.plate in (:carPlateList)")
    List<CarEntity> findUnavailableCarByPlateList(@Param("carPlateList") List<String> carPlateList);
}