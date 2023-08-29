package org.group_3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameLogic {
    private static final String ABSOLUTE_PARTF = "./textfolder/City.txt";
    public int moveCounter = 0;
    // Створюємо додатковий список для збору відповідей.
    static List<String> usedCities = new ArrayList<>();
    private List<String> citiesList;

    public GameLogic() {
        citiesList = cities();
    }


    public String generateComputerResponse(String userInput) {
        char lastLetter = Character.toLowerCase(userInput.charAt(userInput.length() - 1));
        char b = 'ь';
        if (lastLetter == b) {
            lastLetter = Character.toLowerCase(userInput.charAt(userInput.length() - 2));
        }
        for (String city : citiesList) {
            if (city.toLowerCase().charAt(0) == lastLetter && !isCityUsed(city)) {
                citiesList.remove(city);
                return city;
            }
        }

        return "здаюсь";
    }


    public boolean isValidCity(String city) {
        for (String citys : citiesList) {
            if (citys.equalsIgnoreCase(city)) {
                return false;
            }

        }
        return true;
    }

    public boolean checkingFirstLastSymbol(String userInput) {
        char firstLetter = Character.toLowerCase(userInput.charAt(0));
        String lastAddedCity = usedCities.get(usedCities.size() - 1);
        char lastLetter = Character.toLowerCase(lastAddedCity.charAt(lastAddedCity.length() - 1));
        if (firstLetter != lastLetter) {
            return true;
        }
        return false;
    }

    public static boolean isCityUsed(String city) {
        for (String citys : usedCities) {
            if (citys.equalsIgnoreCase(city)) {
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
        moveCounter = 0;
        usedCities.clear();
    }

}

