package com.caixa.rentcar.domain.api.ports;

import com.caixa.rentcar.domain.model.*;
import com.caixa.rentcar.domain.shared.constants.DomainMessages;
import com.caixa.rentcar.domain.shared.exceptions.DomainNotFoundException;
import com.caixa.rentcar.domain.spi.ports.*;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static java.time.LocalDateTime.now;

@RequiredArgsConstructor
public class DomainRentCarServicePortImpl implements DomainRentCarServicePort {

    private final DomainRentCarOrderRepositoryPort domainRentCarOrderRepositoryPort;
    private final DomainClientBonusRepositoryPort domainClientBonusRepositoryPort;
    private final DomainClientRepositoryPort domainClientRepositoryPort;
    private final DomainCarRepositoryPort domainCarRepositoryPort;
    private final DomainPricesRepositoryPort domainPricesRepositoryPort;
    private final DomainPriceItemsRepositoryPort domainPriceItemsRepositoryPort;

    @Override
    public DomainRentCarOrderClientModel findRentCarOrder(String rentcarId) {
        DomainRentCarOrderClientModel domainRentCarOrderInfoModel = domainRentCarOrderRepositoryPort.findRentCarOrder(rentcarId);
        if (domainRentCarOrderInfoModel != null) {
            return domainRentCarOrderInfoModel;
        } else {
            throw new DomainNotFoundException(DomainMessages.KEY_NOT_FOUND);
        }
    }

    @Override
    @Transactional
    public DomainApiResponseModel createRentCarOrder(List<DomainRentCarOrderModel> domainRentCarOrderListModel) {
        List<DomainRentCarOrderModel> rentcarOrderSaved;
        checkRentCarOrders(domainRentCarOrderListModel);
        domainRentCarOrderListModel = updatePrice(domainRentCarOrderListModel);
        rentcarOrderSaved = domainRentCarOrderRepositoryPort.createRentCarOrder(domainRentCarOrderListModel);

        return new DomainApiResponseModel(DomainMessages.OPERATION_OK_CODE, DomainMessages.OPERATION_OK_TEXT, "Se ha completado la operación correctamente", rentcarOrderSaved);
    }

    @Override
    @Transactional
    public DomainApiResponseModel completeRentCarOrder(String carPlate, String returnDate) throws ParseException {
        DomainRentCarOrderModel domainRentCarOrderModel;
        List<DomainRentCarOrderModel> domainRentCarOrderListModel = new ArrayList<>();
        Date newReturnDate = new SimpleDateFormat("yyyy-MM-dd").parse(returnDate);

        DomainCarModel currentCar = checkCarExists(carPlate);
        DomainPricesModel priceTemplate = domainPricesRepositoryPort.findPriceByType(currentCar.getType());
        List<DomainPriceItemsModel> priceItemList = domainPriceItemsRepositoryPort.findPriceItemsByType(currentCar.getType());
        domainRentCarOrderModel = checkRentCarOrderExists(carPlate);
        domainRentCarOrderModel = fillRentCarOrderExists(domainRentCarOrderModel,priceTemplate,priceItemList,newReturnDate);

        domainRentCarOrderRepositoryPort.completeRentCarOrder(domainRentCarOrderModel);
        domainClientBonusRepositoryPort.addBonus(getClientBonus(domainRentCarOrderModel,priceTemplate.getPoints()));
        domainRentCarOrderListModel.add(domainRentCarOrderModel);
        return new DomainApiResponseModel(DomainMessages.OPERATION_OK_CODE, DomainMessages.OPERATION_OK_TEXT, "Se ha completado la orden asociada al coche "+carPlate,domainRentCarOrderListModel);
    }

    private void checkRentCarOrders(List<DomainRentCarOrderModel> domainRentCarOrderListModel) {
        StringBuilder msgReturn = new StringBuilder();

        msgReturn.append(checkClientDni(domainRentCarOrderListModel.stream().map(c -> c.getClientDni()).collect(Collectors.toList())));
        msgReturn.append(checkCarPlateUnknown(domainRentCarOrderListModel.stream().map(c -> c.getCarPlate()).collect(Collectors.toList())));
        msgReturn.append(checkCarPlateUnavailable(domainRentCarOrderListModel.stream().map(c -> c.getCarPlate()).collect(Collectors.toList())));
        msgReturn.append(checkCarPlateDuplicate(domainRentCarOrderListModel.stream().map(c -> c.getCarPlate()).collect(Collectors.toList())));

        if (!msgReturn.isEmpty()) {
            throw new DomainNotFoundException(msgReturn.toString());
        }
    }

    private String checkClientDni(List<String> clientDniList) {
        String msgNotFoundResult = "";
        List<String> clientDniListTemp = clientDniList;
        List<DomainClientModel> currentList = domainClientRepositoryPort.findClientByDniList(clientDniList);
        clientDniListTemp.removeAll(currentList.stream().map(c -> c.getDni()).collect(Collectors.toList()));
        if (clientDniListTemp.size() > 0) {
            msgNotFoundResult = DomainMessages.UNKNOWN_CLIENT_TEXT + String.join(",", clientDniListTemp);
        }
        return msgNotFoundResult;
    }

    private String checkCarPlateUnknown(List<String> carPlateList) {
        String msgUnknownResult = "";
        List<String> carPlateListTemp = carPlateList;
        List<DomainCarModel> currentList = domainCarRepositoryPort.findCarInventoryByCarPlateList(carPlateList);
        carPlateListTemp.removeAll(currentList.stream().map(c -> c.getPlate()).collect(Collectors.toList()));
        if (carPlateListTemp.size() > 0) {
            msgUnknownResult = DomainMessages.UNKNOWN_CAR_TEXT + String.join(",", carPlateListTemp);
        }
        return msgUnknownResult;
    }

    private String checkCarPlateUnavailable(List<String> carPlateList) {
        String msgUnavailableResult = "";
        List<DomainCarModel> currentList = domainCarRepositoryPort.findUnavailableCarByPlateList(carPlateList);
        if (currentList.size() > 0) {
            msgUnavailableResult = DomainMessages.UNAVAILABLE_CAR_TEXT + String.join(",", currentList.stream().map(c -> c.getPlate()).collect(Collectors.toList()));
        }
        return msgUnavailableResult;
    }

    private String checkCarPlateDuplicate(List<String> carPlateList) {
        String msgUnavailableResult = "";
        List<String> currentList = carPlateList.stream()
                .filter(i -> Collections.frequency(carPlateList, i) > 1)
                .collect(Collectors.toList());
        if (currentList.size() > 0) {
            msgUnavailableResult = DomainMessages.DUPLICATED_CAR_TEXT + String.join(",", currentList);
        }
        return msgUnavailableResult;
    }

    private List<DomainRentCarOrderModel> updatePrice(List<DomainRentCarOrderModel> domainRentCarOrderListModel){

        for(DomainRentCarOrderModel rentCarOrderRecord : domainRentCarOrderListModel){
            DomainCarModel currentCar = checkCarExists(rentCarOrderRecord.getCarPlate());
            DomainPricesModel priceTemplate = domainPricesRepositoryPort.findPriceByType(currentCar.getType());
            List<DomainPriceItemsModel> priceItemList = domainPriceItemsRepositoryPort.findPriceItemsByType(currentCar.getType());

            rentCarOrderRecord.setPrice(calculateInitPrice(rentCarOrderRecord,priceTemplate,priceItemList));
            rentCarOrderRecord.setStatus(DomainMessages.NEW_RENTAR_ORDER);
            rentCarOrderRecord.setCreatedOn(now());
        }
        return domainRentCarOrderListModel;
    }

    private DomainCarModel checkCarExists(String carPlate) {
        DomainCarModel domainCarModel = domainCarRepositoryPort.findCarInventoryByCarPlate(carPlate);
        if (domainCarModel!=null){
            return domainCarModel;
        }else{
            throw new DomainNotFoundException(DomainMessages.UNKNOWN_CAR_TEXT+carPlate);
        }
    }

    private DomainRentCarOrderModel checkRentCarOrderExists(String carPlate){
        DomainRentCarOrderModel domainRentCarOrderModel = domainRentCarOrderRepositoryPort.findRentCarOrderByRentcarOder(carPlate);
        if (domainRentCarOrderModel!=null){
            return domainRentCarOrderModel;
        }else{
            throw new DomainNotFoundException(DomainMessages.RENTCAR_ORDER_NOT_FOUND+carPlate);
        }
    }

    private DomainRentCarOrderModel fillRentCarOrderExists(DomainRentCarOrderModel domainRentCarOrderModel, DomainPricesModel priceTemplate, List<DomainPriceItemsModel> priceItemList, Date newReturnDate){
        domainRentCarOrderModel.setReturnDate(newReturnDate);
        domainRentCarOrderModel.setStatus(DomainMessages.CLOSE_RENTCAR_ORDER);
        domainRentCarOrderModel.setPrice(calculateFinalPrice(domainRentCarOrderModel,priceTemplate,priceItemList,newReturnDate));
        return domainRentCarOrderModel;
    }

    private DomainClientBonusModel getClientBonus(DomainRentCarOrderModel domainRentCarOrderModel, int points){
        return new DomainClientBonusModel(null, domainRentCarOrderModel.getClientDni(), domainRentCarOrderModel.getCarPlate(), domainRentCarOrderModel.getId(), points);
    }

    private double calculateInitPrice( DomainRentCarOrderModel domainRentCarOrderModel,DomainPricesModel priceTemplate, List<DomainPriceItemsModel> priceItemList){
        double basePrice = priceTemplate.getPrice();
        double deltaDayPrice = 0d;

        int deltaDays = calculateDatesDiff(domainRentCarOrderModel.getStartDate(),domainRentCarOrderModel.getEndDate());
        for(DomainPriceItemsModel priceItem : priceItemList){
            if ((deltaDays<priceItem.getEndDay()) && (deltaDayPrice==0)){
                deltaDayPrice=(basePrice*deltaDays);
            }
            if (((priceItem.getInitDay()==0) && (priceItem.getEndDay()==0)) && (deltaDayPrice==0)){
                deltaDayPrice=(basePrice*deltaDays)*(priceItem.getRecharge()/100.0);
            }
        }
        return deltaDayPrice;
    }

    private double calculateFinalPrice( DomainRentCarOrderModel domainRentCarOrderModel,DomainPricesModel priceTemplate, List<DomainPriceItemsModel> priceItemList, Date newReturnDate){
        double basePrice = priceTemplate.getPrice();
        double deltaDayPrice = 0d;
        double deltaExtraDayPrice = 0d;
        int deltaDays = calculateDatesDiff(domainRentCarOrderModel.getStartDate(),domainRentCarOrderModel.getEndDate());
        int deltaExtraDays = calculateDatesDiff(domainRentCarOrderModel.getEndDate(),newReturnDate);
        for(DomainPriceItemsModel priceItem : priceItemList){
            if ((deltaDays<priceItem.getEndDay()) && (deltaDayPrice==0)){
                deltaDayPrice=(basePrice*deltaDays)*(priceItem.getRecharge()/100.0);
            }
            if (((priceItem.getInitDay()==0) && (priceItem.getEndDay()==0)) && (deltaDayPrice==0)){
                deltaDayPrice=(basePrice*deltaDays)*(priceItem.getRecharge()/100.0);
            }
            if ((deltaExtraDays>0) && ((priceItem.getInitDay()<0) && (priceItem.getEndDay()<0))){
                deltaExtraDayPrice = (basePrice*deltaExtraDays)*(priceItem.getRecharge()/100.0);
            }
        }
        return deltaDayPrice+deltaExtraDayPrice;
    }

    private int calculateDatesDiff(Date dateBefore, Date dateAfter){
        long dateBeforeInMs = dateBefore.getTime();
        long dateAfterInMs = dateAfter.getTime();

        long timeDiff = Math.abs(dateAfterInMs - dateBeforeInMs);
        long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);

        if (daysDiff<0){
            throw new DomainNotFoundException(DomainMessages.DATES_DIFF_KO);
        }else{
            return (int)daysDiff;
        }
    }

}
