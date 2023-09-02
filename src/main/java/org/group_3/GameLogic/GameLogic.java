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

    // Створюємо додатковий список для збору відповідей.
    public static List<String> usedCities = new ArrayList<>();
    // Список міст
    private final List<String> citiesList;

    public GameLogic() throws IOException{
        citiesList = CitiesLibrary.downloadCityList();
    }

    //Рандомна генерація відповіді комп'ютера
    public String generateComputerResponse(String userInput) {
        char lastLetter = Character.toLowerCase(userInput.charAt(userInput.length() - 1));

        //Перевірка на м'який знак здвие на одну букву
        if (lastLetter == b || lastLetter == c || lastLetter == d || lastLetter == e || lastLetter == f || lastLetter == g) {
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

        return "здаюсь";
    }

    //Перевірка на правильність написання назви міста
    public boolean isValidCity(String city) {
        for (String citys : citiesList) {
            if (citys.equalsIgnoreCase(city)) {
                return false;
            }

        }
        return true;
    }

    //Перевірека на на писання назви міста за правильної літери, якщо у комп'ютера остання літера "ь" берется попередня літера
    public boolean checkingFirstLastSymbol(String userInput) {
        char firstLetter = Character.toLowerCase(userInput.charAt(0));
        String lastAddedCity = usedCities.get(usedCities.size() - 1);
        char lastLetter = Character.toLowerCase(lastAddedCity.charAt(lastAddedCity.length() - 1));
        if (lastLetter == b || lastLetter == c || lastLetter == d || lastLetter == e || lastLetter == f || lastLetter == g) {
            lastLetter = Character.toLowerCase(lastAddedCity.charAt(lastAddedCity.length() - 2));
        }
        return firstLetter != lastLetter;
    }

    //Перевірка на використане місто
    public static boolean isCityUsed(String city) {
        for (String citys : usedCities) {
            if (citys.equalsIgnoreCase(city)) {
                return true;
            }
        }
        return false;
    }

    //Чистка списків для гри знову
    public void clearCollections() {
        citiesList.clear();
        usedCities.clear();
    }
}