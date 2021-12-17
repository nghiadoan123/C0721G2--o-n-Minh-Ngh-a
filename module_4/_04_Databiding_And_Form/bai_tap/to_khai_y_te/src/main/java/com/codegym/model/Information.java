package com.codegym.model;

public class Information {

    private String name;
    private String birthday;
    private String gender;
    private String national;
    private String idCard;
    private String vehicleMove;
    private String vehicleNumber;
    private String chairNumber;
    private String startDay;
    private String endDay;
    private String movingInformation;
    private String cityName;
    private String districtName;
    private String wardsName;
    private String phone;
    private String email;
    Boolean fever;
    Boolean cough;
    Boolean difficultyOfBreathing;
    Boolean soreThroat;

    Boolean vomiting;
    Boolean diarrhea ;
    Boolean skinHemorrhage;
    Boolean rash;

    Boolean visitAny;
    Boolean careFor;

    public Information() {
    }

    public Information(String name, String birthday, String gender, String national, String idCard, String vehicleMove, String vehicleNumber, String chairNumber, String startDay, String endDay, String movingInformation, String cityName, String districtName, String wardsName, String phone, String email, Boolean fever, Boolean cough, Boolean difficultyOfBreathing, Boolean soreThroat, Boolean vomiting, Boolean diarrhea, Boolean skinHemorrhage, Boolean rash, Boolean visitAny, Boolean careFor) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.national = national;
        this.idCard = idCard;
        this.vehicleMove = vehicleMove;
        this.vehicleNumber = vehicleNumber;
        this.chairNumber = chairNumber;
        this.startDay = startDay;
        this.endDay = endDay;
        this.movingInformation = movingInformation;
        this.cityName = cityName;
        this.districtName = districtName;
        this.wardsName = wardsName;
        this.phone = phone;
        this.email = email;
        this.fever = fever;
        this.cough = cough;
        this.difficultyOfBreathing = difficultyOfBreathing;
        this.soreThroat = soreThroat;
        this.vomiting = vomiting;
        this.diarrhea = diarrhea;
        this.skinHemorrhage = skinHemorrhage;
        this.rash = rash;
        this.visitAny = visitAny;
        this.careFor = careFor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getVehicleMove() {
        return vehicleMove;
    }

    public void setVehicleMove(String vehicleMove) {
        this.vehicleMove = vehicleMove;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getChairNumber() {
        return chairNumber;
    }

    public void setChairNumber(String chairNumber) {
        this.chairNumber = chairNumber;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getMovingInformation() {
        return movingInformation;
    }

    public void setMovingInformation(String movingInformation) {
        this.movingInformation = movingInformation;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getWardsName() {
        return wardsName;
    }

    public void setWardsName(String wardsName) {
        this.wardsName = wardsName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getFever() {
        return fever;
    }

    public void setFever(Boolean fever) {
        this.fever = fever;
    }

    public Boolean getCough() {
        return cough;
    }

    public void setCough(Boolean cough) {
        this.cough = cough;
    }

    public Boolean getDifficultyOfBreathing() {
        return difficultyOfBreathing;
    }

    public void setDifficultyOfBreathing(Boolean difficultyOfBreathing) {
        this.difficultyOfBreathing = difficultyOfBreathing;
    }

    public Boolean getSoreThroat() {
        return soreThroat;
    }

    public void setSoreThroat(Boolean soreThroat) {
        this.soreThroat = soreThroat;
    }

    public Boolean getVomiting() {
        return vomiting;
    }

    public void setVomiting(Boolean vomiting) {
        this.vomiting = vomiting;
    }

    public Boolean getDiarrhea() {
        return diarrhea;
    }

    public void setDiarrhea(Boolean diarrhea) {
        this.diarrhea = diarrhea;
    }

    public Boolean getSkinHemorrhage() {
        return skinHemorrhage;
    }

    public void setSkinHemorrhage(Boolean skinHemorrhage) {
        this.skinHemorrhage = skinHemorrhage;
    }

    public Boolean getRash() {
        return rash;
    }

    public void setRash(Boolean rash) {
        this.rash = rash;
    }

    public Boolean getVisitAny() {
        return visitAny;
    }

    public void setVisitAny(Boolean visitAny) {
        this.visitAny = visitAny;
    }

    public Boolean getCareFor() {
        return careFor;
    }

    public void setCareFor(Boolean careFor) {
        this.careFor = careFor;
    }
}
