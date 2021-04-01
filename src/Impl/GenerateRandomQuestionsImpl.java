package Impl;
import Interfaces.GenerateRandomQuestionsService;

import java.util.HashMap;

public class GenerateRandomQuestionsImpl implements GenerateRandomQuestionsService {
    
    private DatabaseImpl database = new DatabaseImpl();

    private HashMap<String, Boolean> cities = new HashMap<>();
    private HashMap <String, HashMap> countries = new HashMap<>();

    public void addQuestionsToDatabase(String country, String capital){

        database.addQuestions(country, capital);

    }

    public void addQuestionsToDatabase(){

        database.addQuestions();

    }



     public HashMap getQuestion(){
        cities.clear();
        countries.clear();

        String country = database.getRandomCountry();           // получение рандомной страны из базы
        database.removeCountry(country);                        // удаление страны из базы , чтобы не появлялась в вопросах повторно

        String city = database.getCountryAndCapital(country);   // получение столицы по ключу {Страна}

        cities.put(city, true);                                 // добавление правильной столицы
        database.removeCity(city);                              // временное удаление столицы, чтобы повторно не появлялась в вариантах
        database.shuffleCities();                               // смешивание списка городов

            for (int i = 0; i < 3; i++){                        // получение рандомных городов для вариантов ответа

                cities.put(database.getRandomCity(i), false);

            }

        database.addCity(city);                                 // добавление ранее временно удаленной столицы обратно в базу, чтобы использовать повторно в след. вопросах
        countries.put(country, cities);                         // добавление {country:{city:boolean}}
        return countries;
    }
}
