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
}
