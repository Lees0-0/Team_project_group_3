package org.group_3.EnglishWindows;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnglishGameLogic {

    private final char q = 'q';
    private final char w = 'w';
    private final char x = 'x';

    public static List<String> usedCities = new ArrayList<>();

    String fileName = "./files/EnglishCitiesLibrary.txt";

    private final List<String> citiesList;

    private List<String> readCitiesFromFile() throws IOException {
        List<String> cities = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                cities.add(line);
            }
        }
        return cities;
    }

    public EnglishGameLogic() throws IOException {
        citiesList = readCitiesFromFile();
    }

    public String generateComputerResponse(String userInput) {
        char lastLetter = Character.toLowerCase(userInput.charAt(userInput.length() - 1));
        if (lastLetter == q || lastLetter == w || lastLetter == x) {
            lastLetter = Character.toLowerCase(userInput.charAt(userInput.length() - 2));
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

        return "give up";
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
        if (lastLetter == q || lastLetter == w || lastLetter == x) {
            lastLetter = Character.toLowerCase(lastAddedCity.charAt(lastAddedCity.length() - 2));
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
