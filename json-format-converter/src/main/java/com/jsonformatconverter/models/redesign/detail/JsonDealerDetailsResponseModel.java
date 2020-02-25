package com.jsonformatconverter.models.redesign.detail;

import lombok.Data;

import java.util.List;

@Data
public class JsonDealerDetailsResponseModel {

    private String[] messages;
    private List<JsonDealerDetailsRedesignModel> locations;
    private String[] errors;

    public JsonDealerDetailsResponseModel(List<JsonDealerDetailsRedesignModel> locations){
        this.locations = locations;
    }
}
