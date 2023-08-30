package org.group_3.GameLogic;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameLogic {


    // Створюємо додатковий список для збору відповідей.
    static List<String> usedCities = new ArrayList<>();
    private List<String> citiesList;

    public GameLogic() {
        citiesList = downloadCityList();
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


    public void clearCollections() {
        citiesList.clear();
        usedCities.clear();

    }


    public static List<String> downloadCityList() {
        List<String> cityList = new ArrayList<>();

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {

            HttpGet httpGet = new HttpGet("https://spravka109.net/ua/adres/ukraine/cities");
            HttpResponse response = httpClient.execute(httpGet);

            if (response.getStatusLine().getStatusCode() == 200) {

                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                Document document = Jsoup.parse(content);

                Elements cityElements = document.select(".alist");
                for (Element cityElement : cityElements) {
                    String cityName = cityElement.text();


                    if (cityName.length() >= 2) {

                        cityName = cityName.split("\\(")[0].trim();

                        cityName = cityName.replace("Воронеж-45", "Вроцлав").trim();
                        cityName = cityName.replace(". р-н", "").trim();


                        cityList.add(cityName);
                    }
                }
            } else {
                System.out.println("Failed to retrieve web page. Status code: " + response.getStatusLine().getStatusCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return cityList;
    }
}



