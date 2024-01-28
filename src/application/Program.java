package application;

import entities.User;
import util.Menu;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static entities.User.registerUser;
import static util.Menu.printMenu;
import static util.Menu.startProgram;
import static util.Questions.*;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String inputPath = "forms.txt";

        List<User> userList = new ArrayList<>();

        String outputDirectory = "C:\\temp\\out";
        new File(outputDirectory).mkdirs();

        while (Menu.isStartProgram()) {
            printMenu();
            int userChoice = sc.nextInt();
            sc.nextLine();

            if (userChoice == 1) {
                List<String> questions = readQuestions(inputPath);
                User user = registerUser(sc, questions);
                userList.add(user);
                saveAnswers(user, outputDirectory);
                System.out.println(user);
                System.out.println();
            }
            if (userChoice == 2) {
                List<String> names = userList.stream().map(User::getName).toList();
                names.forEach(System.out::println);
                System.out.println();
            }
            if (userChoice == 3) {
                System.out.println("Digite a nova pergunta:");
                String newQuestion = sc.nextLine();
                createNewQuestion(newQuestion, inputPath);
                System.out.println();
            }
            if (userChoice == 4) {
                System.out.println("Digite o número da pergunta que deseja excluir");
                int deleteQuestion = sc.nextInt();
                sc.nextLine();
                removeQuestion(deleteQuestion, inputPath);
                System.out.println();
            }
            if (userChoice == 5) {
                System.out.println("Digite o valor que deseja buscar: nome, email ou idade");
                String search = sc.nextLine().toLowerCase();
                List<User> result = userList.stream()
                        .filter(user -> user.getName().toLowerCase().contains(search)
                                || user.getEmail().toLowerCase().contains(search)
                                || String.valueOf(user.getAge()).equals(search)).toList();
                if (result.isEmpty()){
                    System.out.println("Nenhum usuário encontrado.");
                } else {
                    System.out.println("Usuários encontrados:");
                    result.stream().map(User::getName).forEach(System.out::println);
                    System.out.println();
                }
            }
            if (userChoice == 6){
                startProgram = false;
                System.out.println("Programa encerrado");
            }
        }
        sc.close();
    }
}
