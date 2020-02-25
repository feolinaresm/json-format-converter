package com.jsonformatconverter.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jsonformatconverter.models.legacy.JsonDealerLegacyModel;
import com.jsonformatconverter.models.redesign.detail.JsonDealerDetailsResponseModel;
import com.jsonformatconverter.models.redesign.number.JsonDealerNumberResponseModel;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class FileUtils {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static JsonDealerLegacyModel readLegacyModelFromJsonFile(final String jsonFilePath) {
        JsonDealerLegacyModel dealerLegacyModel = null;
        try {
                Reader reader = new FileReader(jsonFilePath); // e.g. "src/main/resources/input.json"
            
            // Convert JSON File to Java Object
            dealerLegacyModel = gson.fromJson(reader, JsonDealerLegacyModel.class);

            // print staff
            System.out.println(dealerLegacyModel);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return dealerLegacyModel;
    }

    public static void writeJsonDealerRedesignModel(final JsonDealerNumberResponseModel responseModel, final String jsonFilePath) {
        String dealerLegacyModelJson = gson.toJson(responseModel);
        System.out.println(dealerLegacyModelJson);

        // Java objects to File
        try {
            FileWriter writer = new FileWriter(jsonFilePath);
            gson.toJson(responseModel, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeJsonDealerRedesignModel(final JsonDealerDetailsResponseModel responseModel, final String jsonFilePath) {
        String dealerLegacyModelJson = gson.toJson(responseModel);
        System.out.println(dealerLegacyModelJson);

        // Java objects to File
        try {
            FileWriter writer = new FileWriter(jsonFilePath);
            gson.toJson(responseModel, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
