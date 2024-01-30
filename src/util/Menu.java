package util;

import java.util.NoSuchElementException;

public class Menu {

    public static boolean startProgram = true;

    public Menu() {
    }

    public static boolean startProgram() {
        return true;
    }

    public  boolean isStartProgram() {
        return startProgram;
    }

    public  void setStartProgram(boolean startProgram) {
        Menu.startProgram = startProgram;
    }

    public void printMenu() {
        System.out.println("Digite um valor correspondente à uma das opções abaixo:");
        System.out.println("1 - Cadastrar um usuário");
        System.out.println("2 - Listar todos os usuários cadastrados");
        System.out.println("3 - Cadastrar nova pergunta no formulário");
        System.out.println("4 - Deletar pergunta do formulário");
        System.out.println("5 - Buscar um usuário");
        System.out.println("6 - Encerrar o programa");
    }


     public int convertStringToInt(String input) {
        return switch (input.toLowerCase()) {
            case "um" -> 1;
            case "dois" -> 2;
            case "três" -> 3;
            case "quatro" -> 4;
            case "cinco" -> 5;
            case "seis" -> 6;
            default -> 0;
        };
    }

    public int convertInputToNumeric(String input) {
        try {
            int numericChoice = Integer.parseInt(input.trim());
            if (numericChoice >= 1 && numericChoice <= 6) {
                return numericChoice;
            } else {
                System.out.println("Opção inválida");
                return -1;
            }
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public int convertUserChoice(String userChoice) {
        int numericChoice = convertInputToNumeric(userChoice);

        if (numericChoice == -1) {
            numericChoice = convertStringToInt(userChoice);
            if (numericChoice == -1) {
                System.out.println("Erro: entrada inválida");
                return -1;
            }
        }
        return numericChoice;
    }
}


