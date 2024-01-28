package util;

public class Menu {
    public static boolean startProgram = true;

    public Menu() {
    }

    public static boolean isStartProgram() {
        return startProgram;
    }

    public static void setStartProgram(boolean startProgram) {
        Menu.startProgram = startProgram;
    }

    public static void printMenu() {
        System.out.println("Digite um valor correspondente à uma das opções abaixo:");
        System.out.println("1 - Cadastrar um usuário");
        System.out.println("2 - Listar todos os usuários cadastrados");
        System.out.println("3 - Cadastrar nova pergunta no formulário");
        System.out.println("4 - Deletar pergunta do formulário");
        System.out.println("5 - Buscar um usuário");
        System.out.println("6 - Encerrar o programa");
    }
    public static int stringToIntConverter(String input) {
        try{
            return switch (input.toLowerCase()) {
                case "um" -> 1;
                case "dois" -> 2;
                case "três" -> 3;
                case "quatro" -> 4;
                case "cinco" -> 5;
                case "seis" -> 6;
                default -> -1;
            };
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
