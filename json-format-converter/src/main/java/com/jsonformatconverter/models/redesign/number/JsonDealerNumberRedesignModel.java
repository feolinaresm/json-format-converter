package com.jsonformatconverter.models.redesign.number;

import lombok.Data;

@Data
public class JsonDealerNumberRedesignModel {

    private String locationNo;
    private String inventoryLocationNo;

    public JsonDealerNumberRedesignModel(String locationNo, String inventoryLocationNo) {
        this.locationNo = locationNo;
        this.inventoryLocationNo = inventoryLocationNo;
    }
}
