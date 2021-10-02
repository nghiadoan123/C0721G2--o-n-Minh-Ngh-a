package models.service.room;

import models.service.facility.Facility;

import java.io.Serializable;

public class Room extends Facility implements Serializable {
    private String promotionService;

    public Room() {
    }

    public Room(String serviceName, int usableArea, int rentalCost, int maxNumberOfTenants, String typeOfRent, String promotionService) {
        super(serviceName, usableArea, rentalCost, maxNumberOfTenants, typeOfRent);
        this.promotionService = promotionService;
    }

    public String getPromotionService() {
        return promotionService;
    }

    public void setPromotionService(String promotionService) {
        this.promotionService = promotionService;
    }

    @Override
    public String toString() {
        return "Room{" +
                super.toString() +
                "promotionService='" + promotionService + '\'' +
                '}';
    }

    @Override
    public String getInfoToCSV() {
        return super.getServiceName()+","+super.getUsableArea()+","+super.getRentalCost()+","+super.getMaxNumberOfTenants()+","+super.getTypeOfRent()+","+promotionService;
    }
}
