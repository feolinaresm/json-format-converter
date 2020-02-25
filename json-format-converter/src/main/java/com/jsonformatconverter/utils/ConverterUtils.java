package com.jsonformatconverter.utils;

import com.jsonformatconverter.models.legacy.JsonDealerLegacyModel;
import com.jsonformatconverter.models.redesign.detail.JsonDealerDetailsRedesignModel;
import com.jsonformatconverter.models.redesign.detail.JsonDealerDetailsResponseModel;
import com.jsonformatconverter.models.redesign.number.JsonDealerNumberRedesignModel;
import com.jsonformatconverter.models.redesign.number.JsonDealerNumberResponseModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class ConverterUtils {

    public static final JsonDealerNumberResponseModel generateDealerNumberFromLegacy(JsonDealerLegacyModel legacyModel) {

        JsonDealerNumberResponseModel numberResponseModel = new JsonDealerNumberResponseModel(new ArrayList<>());

        legacyModel.getPrv().forEach(dealer -> {
            int count = 1;
            String code = String.format("%s%05d", dealer.getCountry().substring(2).toUpperCase(), count);
            numberResponseModel.getLocations().add(new JsonDealerNumberRedesignModel(dealer.getCod(), dealer.getCod()));
            ++count;
        });

        return numberResponseModel;
    }

    public static final JsonDealerDetailsResponseModel generateDealerDetailsFromLegacy(JsonDealerLegacyModel legacyModel) {

        JsonDealerDetailsResponseModel detailsResponseModel = new JsonDealerDetailsResponseModel(new ArrayList<>());

        legacyModel.getPrv().forEach(dealerDetails -> {

            int count = 1;

            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            String createDate = dateFormat.format(date);

            Date dateWithHours = Calendar.getInstance().getTime();
            DateFormat dateFormatWithHours = new SimpleDateFormat("yyyyMMddkkmmss");
            String createDateWithHours = dateFormatWithHours.format(dateWithHours);

            String LegalName = dealerDetails.getName().toUpperCase();
            String retailCategory = "N";
            String locationType = "N";
            String licenseeStore = "N";
            String guestWiFiAvailable = "N";
            String militaryIndicator = "N";
            String lineOfBusiness = "COMMERCIAL";
            List<String> aplication = new ArrayList<>();
            if(dealerDetails.getTbr().equals("TRUE")){
                aplication.add("TRUCK-AND-BUS");
            }
            if(dealerDetails.getOtr().equals("TRUE")) {
                aplication.add("OFF-THE-ROAD");
            }
            if(dealerDetails.getAg().equals("TRUE")){
                aplication.add("AGRICULTURE");
            }
            List<String> brands = new ArrayList<>();

            if (dealerDetails.getBrsrv().equals("TRUE")){
                brands.add("BRIDGESTONE");
            }
            if(dealerDetails.getFrsrv().equals("TRUE")){
                brands.add("FIRESTONE");
            }
            String temporalyClosed = "N";
            String acceptsOnlineAppointments = "N";


            String compare = dealerDetails.getCod().substring(0, 2);

            List<JsonDealerDetailsRedesignModel.Holidays> holidays = new ArrayList<>();

            if (compare.equals("BR")){
                JsonDealerDetailsRedesignModel.Holidays Day1 = new JsonDealerDetailsRedesignModel.Holidays("Dia de Natal", "12-25-2020", "12-25-2020", "", "Y", "Y");
                JsonDealerDetailsRedesignModel.Holidays Day2 = new JsonDealerDetailsRedesignModel.Holidays("Boa noite", "12-24-2020", "12-24-2020", "", "Y", "Y");
                JsonDealerDetailsRedesignModel.Holidays Day3 = new JsonDealerDetailsRedesignModel.Holidays("Dia de Ano Novo", "01-01-2021", "01-01-2021", "", "Y", "Y");
                JsonDealerDetailsRedesignModel.Holidays Day4 = new JsonDealerDetailsRedesignModel.Holidays("Véspera de Ano Novo", "12-31-2020", "12-30-2020", "", "Y", "Y");

                holidays.add(Day1);
                holidays.add(Day2);
                holidays.add(Day3);
                holidays.add(Day4);
            }else{
                JsonDealerDetailsRedesignModel.Holidays Day1 = new JsonDealerDetailsRedesignModel.Holidays("Día de navidad", "12-25-2020", "12-25-2020", "", "Y", "Y");
                JsonDealerDetailsRedesignModel.Holidays Day2 = new JsonDealerDetailsRedesignModel.Holidays("Nochebuena", "12-24-2020", "12-24-2020", "", "Y", "Y");
                JsonDealerDetailsRedesignModel.Holidays Day3 = new JsonDealerDetailsRedesignModel.Holidays("Día de año nuevo", "01-01-2021", "01-01-2021", "", "Y", "Y");
                JsonDealerDetailsRedesignModel.Holidays Day4 = new JsonDealerDetailsRedesignModel.Holidays("Vispera de año nuevo", "12-31-2020", "12-30-2020", "", "Y", "Y");

                holidays.add(Day1);
                holidays.add(Day2);
                holidays.add(Day3);
                holidays.add(Day4);
            }

            detailsResponseModel.getLocations()
                    .add(
                            new JsonDealerDetailsRedesignModel(
                                    dealerDetails.getCod(),
                                    dealerDetails.getCod(),
                                    createDate,
                                    createDateWithHours,
                                    LegalName,
                                    dealerDetails.getSaddr(),
                                    dealerDetails.getCity(),
                                    dealerDetails.getState(),
                                    dealerDetails.getZip(),
                                    dealerDetails.getCountry(),
                                    dealerDetails.getLat(),
                                    dealerDetails.getLon(),
                                    retailCategory,
                                    locationType,
                                    licenseeStore,
                                    guestWiFiAvailable,
                                    militaryIndicator,
                                    lineOfBusiness,
                                    aplication,
                                    brands,
                                    temporalyClosed,
                                    acceptsOnlineAppointments,
                                    holidays));

            ++count;
        });

        return detailsResponseModel;
    }

}
