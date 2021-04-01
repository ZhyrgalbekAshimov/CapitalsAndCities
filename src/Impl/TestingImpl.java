package Impl;

import Interfaces.TestingService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class TestingImpl implements TestingService {

    private GenerateRandomQuestionsImpl questions = new GenerateRandomQuestionsImpl();

    private Scanner scan = new Scanner(System.in);


    public void addRecordsToDatabase(String country, String capital){

        questions.addQuestionsToDatabase(country, capital);

    }

    public void addRecordsToDatabase(){

        questions.addQuestionsToDatabase();

    }

    public void test () {
        int correctAnswersCounter = 0;
        int questionsNumberCounter = 1;
            for (int k = 0; k < 5; k++){

                HashMap<String, HashMap> randomQuestion = questions.getQuestion();

                for (HashMap.Entry<String, HashMap> question : randomQuestion.entrySet()) {

                    String country = question.getKey();
                    System.out.println("Question #" + questionsNumberCounter);
                    questionsNumberCounter++;
                    System.out.println("The capital of the country " + country + " is:");
                    HashMap<String, Boolean> tab = question.getValue();

                    ArrayList<String> cities = new ArrayList<>();

                        for (HashMap.Entry<String, Boolean> entry1 : tab.entrySet()) { // добавление городов в ArrayList для смешивания т.к. смешивание в HashMap не эффективна

                            String key1 = entry1.getKey();
                            cities.add(key1);

                        }

                            Collections.shuffle(cities);

                int questionNumber = 1;

                for (String city : cities) {
                    System.out.println(questionNumber + ". " + city);
                    questionNumber++;

                }
                System.out.print("Enter your answer (#): ");
                int answer = scan.nextInt();

                if (tab.get(cities.get(answer - 1))){
                    correctAnswersCounter++;
                }

                System.out.println("---------------------------------");
            }

        }

        System.out.println("Correct answers: " + correctAnswersCounter + "/5 (" + (correctAnswersCounter * 100 / 5) + "%)");
    }

}
