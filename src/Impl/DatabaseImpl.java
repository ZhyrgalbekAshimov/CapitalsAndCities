package Impl;

import Interfaces.DatabaseService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class DatabaseImpl implements DatabaseService {

    private HashMap<String, String> countriesAndCapitals = new HashMap<>();
    private ArrayList<String> randomCountries = new ArrayList<>();
    private ArrayList<String> randomCities = new ArrayList<>();


     public void addQuestions() {        // добавление Стран и их Столиц в базу

        countriesAndCapitals.put("USA", "Washington");
        countriesAndCapitals.put("Russia", "Moscow");
        countriesAndCapitals.put("Ukraine", "Kiev");
        countriesAndCapitals.put("Belarus", "Minsk");
        countriesAndCapitals.put("France", "Paris");
        countriesAndCapitals.put("Mongolia", "Ulan-Bator");
        countriesAndCapitals.put("China", "Beijing");
        countriesAndCapitals.put("Armenia", "Yerevan");
        countriesAndCapitals.put("Australia", "Canberra");
        countriesAndCapitals.put("Austria", "Vienna");
        countriesAndCapitals.put("Bulgaria", "Sofia");
        countriesAndCapitals.put("Canada", "Ottawa");
        countriesAndCapitals.put("Croatia", "Zagreb");
        countriesAndCapitals.put("Egypt", "Cairo");
        countriesAndCapitals.put("Estonia", "Tallinn");
        countriesAndCapitals.put("Georgia", "Tbilisi");
        countriesAndCapitals.put("Romania", "Bucharest");
        countriesAndCapitals.put("Peru", "Lima");
        countriesAndCapitals.put("Norway", "Oslo");
        countriesAndCapitals.put("Morocco", "Rabat");
        countriesAndCapitals.put("United Kingdom", "London");
        countriesAndCapitals.put("Turkey", "Ankara");
        countriesAndCapitals.put("Thailand", "Bangkok");
        countriesAndCapitals.put("Taiwan", "Taipei");
        countriesAndCapitals.put("Switzerland", "Bern");


            for (HashMap.Entry<String, String> entry : countriesAndCapitals.entrySet()) {   // добавление Стран и Городов в отдельный ArrayList,
                                                                                            // чтобы смешать для рандомизации
                String key = entry.getKey();
                randomCountries.add(key);

                String value = entry.getValue();
                randomCities.add(value);

        }

                Collections.shuffle(randomCountries);
                Collections.shuffle(randomCities);
    }

        void addQuestions(String country, String capital) {

            countriesAndCapitals.put(country, capital);

        }

        public String getRandomCountry() {                     // метод, возвращающий рандмную страну из базы
            return randomCountries.get(1);
        }

        public String getCountryAndCapital(String country) {   // метод принимает Страну и возвращает ее Столицу
            return countriesAndCapitals.get(country);
        }

        public void addCity(String c){                         // метод принимает Столицу и добавляет в базу
            randomCities.add(c);
        }

        public void shuffleCities(){                          // метод смешивает список городов
            Collections.shuffle(randomCities);
        }

        public String getRandomCity(int i) {                   //метод принимает число и возвращает рандомный город по индексу
            return randomCities.get(i);
        }

        public void removeCity(String city){                   // метод удаляет город из базы
            randomCities.remove(city);
        }

        public void removeCountry(String c) {                 // метод удаляет Страну из базы, чтобы одная и та же страна
            randomCountries.remove(c);                  // не появлялась в вопросах повторно
        }

}