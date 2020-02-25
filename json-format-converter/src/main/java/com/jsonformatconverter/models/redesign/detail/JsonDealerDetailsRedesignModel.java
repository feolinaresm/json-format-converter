package com.jsonformatconverter.models.redesign.detail;

import lombok.Data;
import java.util.List;

@Data
public class JsonDealerDetailsRedesignModel {

    private String locationNo;
    private String inventoryLocationNo;
    private String createDate;
    private String lastModified;
    private String legalName;
    private String streetAddress;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String latitude;
    private String longitude;
    private String retailCategory;
    private String locationType;
    private String licenseeStore;
    private String guestWiFiAvailable;
    private String militaryIndicator;
    private String lineOfBusiness;
    private List<String> application;
    private List<String> brands;
    private String temporarilyClosed;
    private String acceptsOnlineAppointments;
    private List<Holidays> holidays;

    public JsonDealerDetailsRedesignModel(String locationNo, String inventoryLocationNo, String createDate,
                                          String lastModified, String legalName, String streetAddress, String city,
                                          String state, String postalCode, String country, String latitude, String longitude,
                                          String retailCategory, String locationType, String licenseeStore, String guestWiFiAvailable,
                                          String militaryIndicator, String lineOfBusiness, List<String> application, List<String> brands,
                                          String temporarilyClosed, String acceptsOnlineAppointments, List<Holidays> holidays) {
        this.locationNo = locationNo;
        this.inventoryLocationNo = inventoryLocationNo;
        this.createDate = createDate;
        this.lastModified = lastModified;
        this.legalName = legalName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.retailCategory = retailCategory;
        this.locationType = locationType;
        this.licenseeStore = licenseeStore;
        this.guestWiFiAvailable = guestWiFiAvailable;
        this.militaryIndicator = militaryIndicator;
        this.lineOfBusiness = lineOfBusiness;
        this.application = application;
        this.brands = brands;
        this.temporarilyClosed = temporarilyClosed;
        this.acceptsOnlineAppointments = acceptsOnlineAppointments;
        this.holidays = holidays;
    }

    @Data
    public static class Holidays {
        private String holidayName;
        private String holidayDateFrom;
        private String holidayDateTo;
        private String hoursOpen;
        private String allDayClosure;
        private String annualRepeat;

        public Holidays(String holidayName, String holidayDateFrom, String holidayDateTo, String hoursOpen, String allDayClosure, String annualRepeat) {
            this.holidayName = holidayName;
            this.holidayDateFrom = holidayDateFrom;
            this.holidayDateTo = holidayDateTo;
            this.hoursOpen = hoursOpen;
            this.allDayClosure = allDayClosure;
            this.annualRepeat = annualRepeat;
        }
    }



}
