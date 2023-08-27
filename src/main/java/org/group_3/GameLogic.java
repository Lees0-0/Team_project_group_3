package org.group_3;

import java.util.ArrayList;
import java.util.List;

import static org.group_3.GameWindow.usedCities;

public class GameLogic {


    private List<String> citiesList;


    public GameLogic() {
        citiesList = cities();
    }


    public String generateComputerResponse(String userInput) {
        char lastLetter = Character.toLowerCase(userInput.charAt(userInput.length() - 1));

        for (String city : citiesList) {
            if (city.toLowerCase().charAt(0) == lastLetter &&!GameWindow.isCityUsed(city)) {
                citiesList.remove(city);
                return city;
            }
        }

        return "Комп'ютер не знайшов відповідного міста.";
    }



    public boolean isValidCity(String city) {
        for (String citys:citiesList) {
            if(citys.equalsIgnoreCase(city)){
                return true;
            }

        }
        return false;
    }





    public List<String> cities() {
        List<String> citiesList = new ArrayList<>();
        citiesList.add("Київ");
        citiesList.add("Харків");
        citiesList.add("Суми");
        citiesList.add("Одеса");
        citiesList.add("Дніпро");
        citiesList.add("Донецьк");
        citiesList.add("Запоріжжя");
        citiesList.add("Вінниця");
        citiesList.add("Алчевськ");
        citiesList.add("Амвросіївка");
        citiesList.add("Ананьїв");
        citiesList.add("Красилів");
        citiesList.add("Дубровиця");
        citiesList.add("Єнакієве");
        citiesList.add("Жданівка");
        citiesList.add("Заводське");
        citiesList.add("Зборів");
        citiesList.add("Зіньків");
        citiesList.add("Ялта");
        citiesList.add("Краків");
        citiesList.add("Катовіце");


        return citiesList;
    }
    public void clearCollections() {
        citiesList.clear();
        usedCities.clear();
    }

}

