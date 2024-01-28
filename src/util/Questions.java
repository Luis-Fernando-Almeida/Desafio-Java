package util;

import entities.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Questions {
    public List<String> readQuestions(String filePath) {
        List<String> questions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                questions.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questions;
    }

    public void saveAnswers(User user, String outputDirectory) {
        String filename = user.getName().toUpperCase().replace(" ", "") + ".TXT";
        String outputPath = outputDirectory + "\\" + filename;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {
            bw.write("1- " + user.getName().toUpperCase() + " 2- " + user.getEmail().toUpperCase() +
                    " 3- " + user.getAge() + " 4- " + user.getHeight());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createNewQuestion(String newQuestion, String filepath) {
        List<String> questions = readQuestions(filepath);
        int numberingOfQuestions = questions.size() + 1;
        String formattedQuestion = numberingOfQuestions + " - " + newQuestion;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath, true))) {
            bw.write(formattedQuestion);
            bw.newLine();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void writeQuestions(List<String> questions, String filepath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath))) {
            for (String question : questions) {
                bw.write(question);
                bw.newLine();
            }
            System.out.println("Perguntas atualizadas com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public void removeQuestion(int numberOfQuestion, String filepath) {
        List<String> questions = readQuestions(filepath);

        if (numberOfQuestion >= 1 && numberOfQuestion <= 4) {
            System.out.println("As quatro primeiras perguntas não podem ser removidas");
        } else if (numberOfQuestion <= questions.size()) {
            questions.remove(numberOfQuestion - 1);
            reorganizeQuestionNumbers(questions);
            writeQuestions(questions, filepath);
        } else {
            System.out.println("Número de pergunta inválido");
        }
    }
    private void reorganizeQuestionNumbers(List<String> questions) {
        for (int i = 0; i < questions.size(); i++) {
            String currentQuestion = questions.get(i);
            int dashIndex = currentQuestion.indexOf('-');

            if (dashIndex != -1) {
                String newNumber = String.format("%d", i + 1);
                questions.set(i, newNumber + currentQuestion.substring(dashIndex));
            }
        }
    }
}



