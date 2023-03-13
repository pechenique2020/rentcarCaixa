package com.caixa.rentcar.infrastructure.h2.adapter;

import com.caixa.rentcar.domain.model.DomainCarModel;
import com.caixa.rentcar.domain.spi.ports.DomainCarRepositoryPort;
import com.caixa.rentcar.infrastructure.h2.entity.CarEntity;
import com.caixa.rentcar.infrastructure.h2.mapper.CarDboMapper;
import com.caixa.rentcar.infrastructure.h2.repository.InfraCarRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
@Slf4j
public class CarH2Adapter implements DomainCarRepositoryPort {
    
    InfraCarRepository carRepository;
    CarDboMapper carMapper;

    @Override
    public List<DomainCarModel> getCarInventory() {
        log.debug("getCarInventory()");
        return carMapper.toDomainList(carRepository.getCarInventory());
    }
    @Override
    public DomainCarModel findCarInventoryByCarPlate(String carPlate) {
        log.debug("findClientByDni()");
        return carMapper.toDomain(carRepository.findCarInventoryByCarPlate(carPlate));
    }
    @Override
    public List<DomainCarModel> findCarInventoryByCarPlateList(List<String> carPlateList) {
        log.debug("findCarInventoryByCarPlateList()");
        return carMapper.toDomainList(carRepository.findCarInventoryByCarPlateList(carPlateList));
    }

    @Override
    public List<DomainCarModel> findUnavailableCarByPlateList(List<String> carPlateList) {
        log.debug("findCarInventoryByCarPlateList()");
        return carMapper.toDomainList(carRepository.findUnavailableCarByPlateList(carPlateList));
    }
}
