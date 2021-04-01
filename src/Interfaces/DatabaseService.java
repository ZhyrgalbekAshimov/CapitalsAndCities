package Interfaces;

public interface DatabaseService {

    void addQuestions();

    String getRandomCountry();

    String getCountryAndCapital(String country);

    void addCity(String c);

    void shuffleCities ();

    String getRandomCity(int i);

    void removeCity(String city);

    void removeCountry (String c);

}
