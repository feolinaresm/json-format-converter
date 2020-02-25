package com.jsonformatconverter.models.legacy;

import lombok.Data;

import java.util.List;

@Data
public class JsonDealerDetailsLegacyModel {

    private String cod;
    private String name;
    private String saddr;
    private String zip;
    private String country;
    private String state;
    private String city;
    private List<Phone> phone;
    private List<Email> email;
    private String lat;
    private String lon;
    private String wk_day_opn;
    private String wk_day_cls;
    private String sat_opn;
    private String sat_cls;
    private String sun_opn;
    private String sun_cls;
    private String brsrv;
    private String frsrv;
    private String tbr;
    private String otr;
    private String ag;
    private String website;
    private String services;
}
