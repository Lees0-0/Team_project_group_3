package org.group_3.GameLogic;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CitiesLibrary {

    public static List<String> downloadCityList() throws IOException {
        List<String> cityList = new ArrayList<>();

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {

            HttpGet httpGet = new HttpGet("https://spravka109.net/ua/adres/ukraine/cities");
            String content = httpClient.execute(httpGet, httpResponse -> Jsoup.parse(httpResponse.getEntity().getContent(), "UTF-8", "").toString());

            Document document = Jsoup.parse(content);
            Elements cityElements = document.select(".alist");
            for (String cityName : cityElements.eachText()) {
                if (cityName.length() >= 2) {
                    cityName = cityName.split("\\(")[0].trim();
                    cityName = cityName.replace("Воронеж-45", "здаюсь").trim();
                    cityName = cityName.replace(". р-н", "").trim();
                    cityList.add(cityName);
                }
            }
            return cityList;
        }
    }
}
