package com.jsonformatconverter.app;

import com.jsonformatconverter.models.legacy.JsonDealerLegacyModel;
import com.jsonformatconverter.models.redesign.detail.JsonDealerDetailsResponseModel;
import com.jsonformatconverter.models.redesign.number.JsonDealerNumberResponseModel;
import com.jsonformatconverter.utils.ConverterUtils;
import com.jsonformatconverter.utils.FileUtils;

public class JsonConverterApp {

    private static final String INPUT_LEGACY_PATH = "src/main/resources/input_legacy_dealers.json";
    private static final String INPUT_REDESIGN_NUMBERS_PATH = "src/main/resources/output_redesign_location_numbers.json";
    private static final String INPUT_REDESIGN_DETAILS_PATH = "src/main/resources/output_redesign_location_details.json";

    public static void main(String[] args) {

        JsonDealerLegacyModel dealerLegacyModel = FileUtils.readLegacyModelFromJsonFile(INPUT_LEGACY_PATH);

        JsonDealerNumberResponseModel numberResponseModel = ConverterUtils.generateDealerNumberFromLegacy(dealerLegacyModel);

        FileUtils.writeJsonDealerRedesignModel(numberResponseModel, INPUT_REDESIGN_NUMBERS_PATH);

        JsonDealerDetailsResponseModel detailsResponseModel = ConverterUtils.generateDealerDetailsFromLegacy(dealerLegacyModel);

        FileUtils.writeJsonDealerRedesignModel(detailsResponseModel, INPUT_REDESIGN_DETAILS_PATH);

    }
}
