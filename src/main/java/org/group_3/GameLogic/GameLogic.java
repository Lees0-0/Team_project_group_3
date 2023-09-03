package org.group_3.GameLogic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameLogic {
    private final char b = 'ь';
    private final char c = 'и';
    private final char d = 'й';

    private final char e = 'ґ';

    private final char f = 'ї';

    private final char g = 'ц';

    public static List<String> usedCities = new ArrayList<>();

    private final List<String> citiesList;

    public GameLogic() throws IOException{
        citiesList = CitiesLibrary.downloadCityList();
    }

    public String generateComputerResponse(String userInput) {
        char lastLetter = Character.toLowerCase(userInput.charAt(userInput.length() - 1));

        if (lastLetter == b || lastLetter == c || lastLetter == d || lastLetter == e || lastLetter == f || lastLetter == g) {
            lastLetter = Character.toLowerCase(userInput.charAt(userInput.length() - 2));
        }
        if (userInput.toLowerCase().endsWith("ий")) {
            lastLetter = Character.toLowerCase(userInput.charAt(userInput.length() - 3));
        }

        List<String> availableCities = new ArrayList<>();
        for (String city : citiesList) {
            if (city.toLowerCase().charAt(0) == lastLetter && !isCityUsed(city)) {
                availableCities.add(city);
            }
        }

        if (!availableCities.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(availableCities.size());
            String chosenCity = availableCities.get(randomIndex);
            citiesList.remove(chosenCity);
            return chosenCity;
        }

        return "здаюсь";
    }


    public boolean isValidCity(String city) {
        for (String cities : citiesList) {
            if (cities.equalsIgnoreCase(city)) {
                return false;
            }

        }
        return true;
    }

    public boolean checkingFirstLastSymbol(String userInput) {
        char firstLetter = Character.toLowerCase(userInput.charAt(0));
        String lastAddedCity = usedCities.get(usedCities.size() - 1);
        char lastLetter = Character.toLowerCase(lastAddedCity.charAt(lastAddedCity.length() - 1));
        if (lastLetter == b || lastLetter == c || lastLetter == d || lastLetter == e || lastLetter == f || lastLetter == g) {
            lastLetter = Character.toLowerCase(lastAddedCity.charAt(lastAddedCity.length() - 2));
        }
        if (lastAddedCity.toLowerCase().endsWith("ий")) {
            lastLetter = Character.toLowerCase(userInput.charAt(userInput.length() - 3));
        }
        return firstLetter != lastLetter;
    }


    public static boolean isCityUsed(String city) {
        for (String cities : usedCities) {
            if (cities.equalsIgnoreCase(city)) {
                return true;
            }
        }
        return false;
    }

    public void clearCollections() {
        citiesList.clear();
        usedCities.clear();
    }
}