package com.jsonformatconverter.utils;

import com.jsonformatconverter.models.legacy.JsonDealerLegacyModel;
import com.jsonformatconverter.models.redesign.detail.JsonDealerDetailsRedesignModel;
import com.jsonformatconverter.models.redesign.detail.JsonDealerDetailsResponseModel;
import com.jsonformatconverter.models.redesign.number.JsonDealerNumberRedesignModel;
import com.jsonformatconverter.models.redesign.number.JsonDealerNumberResponseModel;

import java.text.DateFormat;
import java.text.Normalizer;
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

            String LegalName = Normalizer
                    .normalize(dealerDetails.getName().toUpperCase().trim(), Normalizer.Form.NFD)
                    .replaceAll("[^\\p{ASCII}]", "");

            String saddr = Normalizer
                    .normalize(dealerDetails.getSaddr(), Normalizer.Form.NFD)
                    .replaceAll("[^\\p{ASCII}]", "");

            String city = Normalizer
                    .normalize(dealerDetails.getCity(), Normalizer.Form.NFD)
                    .replaceAll("[^\\p{ASCII}]", "");

            String state = Normalizer
                    .normalize(dealerDetails.getState(), Normalizer.Form.NFD)
                    .replaceAll("[^\\p{ASCII}]", "");

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

            //Compare languaje
            String compare = dealerDetails.getCod().substring(0, 2);
            List<JsonDealerDetailsRedesignModel.Holidays> holidays = new ArrayList<>();

            if (compare.equals("BR")){
                JsonDealerDetailsRedesignModel.Holidays Day1 = new JsonDealerDetailsRedesignModel.Holidays("Natal", "12-25-2020", "12-25-2020", "", "Y", "Y");
                JsonDealerDetailsRedesignModel.Holidays Day2 = new JsonDealerDetailsRedesignModel.Holidays("Ano Novo", "01-01-2021", "01-01-2021", "", "Y", "Y");

                holidays.add(Day1);
                holidays.add(Day2);
            }else{
                JsonDealerDetailsRedesignModel.Holidays Day1 = new JsonDealerDetailsRedesignModel.Holidays("Navidad", "12-25-2020", "12-25-2020", "", "Y", "Y");
                JsonDealerDetailsRedesignModel.Holidays Day2 = new JsonDealerDetailsRedesignModel.Holidays("Año nuevo", "01-01-2021", "01-01-2021", "", "Y", "Y");

                holidays.add(Day1);
                holidays.add(Day2);
            }

            detailsResponseModel.getLocations()
                    .add(
                            new JsonDealerDetailsRedesignModel(
                                    dealerDetails.getCod(),
                                    dealerDetails.getCod(),
                                    createDate,
                                    createDateWithHours,
                                    LegalName,
                                    saddr,
                                    city,
                                    state,
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
