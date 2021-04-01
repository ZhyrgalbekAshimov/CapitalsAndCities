package Interfaces;

import java.util.HashMap;

public interface GenerateRandomQuestionsService {

    void addQuestionsToDatabase(String country, String capital);

    void addQuestionsToDatabase();

    HashMap getQuestion();

}
