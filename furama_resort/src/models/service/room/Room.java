package models.service.room;

import models.service.facility.Facility;

public class Room extends Facility {
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
}
