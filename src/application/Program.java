package application;

import entities.User;
import util.Menu;
import util.Questions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static util.Menu.*;
import static util.Questions.*;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String inputPath = "src/forms.txt";

        List<User> userList = new ArrayList<>();

        String outputDirectory = "C:\\temp\\out";
        new File(outputDirectory).mkdirs();

        User user = new User();
        Questions questionsInstance = new Questions();

        while (Menu.isStartProgram()) {
            printMenu();
            String userChoice = sc.nextLine().trim();

            int numericChoice = convertUserChoice(userChoice);

            switch (numericChoice) {
                case 1:
                    List<String> questions = questionsInstance.readQuestions(inputPath);
                    User newUser = user.registerUser(sc, questions);
                    userList.add(newUser);
                    questionsInstance.saveAnswers(newUser, outputDirectory);
                    System.out.println(newUser);
                    System.out.println();
                    break;
                case 2:
                    List<String> names = userList.stream().map(User::getName).toList();
                    names.forEach(System.out::println);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Digite a nova pergunta:");
                    String newQuestion = sc.nextLine();
                    questionsInstance.createNewQuestion(newQuestion, inputPath);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Digite o número da pergunta que deseja excluir");
                    int deleteQuestion = sc.nextInt();
                    sc.nextLine();
                    questionsInstance.removeQuestion(deleteQuestion, inputPath);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Digite o valor que deseja buscar: nome, email ou idade");
                    String search = sc.nextLine().toLowerCase();
                    List<User> result = userList.stream()
                            .filter(u -> u.getName().toLowerCase().contains(search)
                                    || u.getEmail().toLowerCase().contains(search)
                                    || String.valueOf(u.getAge()).equals(search)).toList();
                    if (result.isEmpty()) {
                        System.out.println("Nenhum usuário encontrado.");
                    } else {
                        System.out.println("Usuários encontrados:");
                        result.stream().map(User::getName).forEach(System.out::println);
                        System.out.println();
                    }
                    break;
                case 6:
                    startProgram = false;
                    System.out.println("Programa encerrado");
                    break;
                default:
                    System.out.println("Opção inválida");
                    System.out.println();
                    break;
            }
        }
        sc.close();
    }
}
