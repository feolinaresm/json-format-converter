package com.jsonformatconverter.models.redesign.number;


import lombok.Data;

import java.util.List;

@Data
public class JsonDealerNumberResponseModel {

    private String[] messages;
    private List<JsonDealerNumberRedesignModel> locations;
    private String[] errors;

    public JsonDealerNumberResponseModel(List<JsonDealerNumberRedesignModel> locations) {
        this.locations = locations;
    }
}
