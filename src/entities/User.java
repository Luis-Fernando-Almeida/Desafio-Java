package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class User {
    private String name;
    private String email;
    private Integer age;
    private static double height;

    public User(String name, String email, Integer age, double height) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }


    @Override
    public String toString() {
        return name + "\n"
                + email + "\n"
                + age + "\n"
                + height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Double.compare(height, user.height) == 0 && Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, age, height);
    }

    public static User registerUser(Scanner sc, List<String> questions) {
        List<String> answer = new ArrayList<>();

        for (String question : questions) {
            System.out.println(question);

            if (question.contains("nome")) {
                verifyNameLength(sc, answer);
            } else if (question.contains("email")) {
                verifyEmail(sc, answer);
            } else if (question.contains("idade")) {
                verifyAge(sc, answer);
            } else if (question.contains("altura")) {
                verifyHeight(sc, answer);
            } else {
                answer.add(sc.nextLine());
            }
        }
        String name = answer.get(0);
        String email = answer.get(1);
        int age = Integer.parseInt(answer.get(2));
        double height = Double.parseDouble(answer.get(3));
        return new User(name, email, age, height);
    }

    private static void verifyNameLength(Scanner sc, List<String> answer) {
        String name = sc.nextLine();
        if (name.length() > 10) {
            answer.add(name);
        } else {
            System.out.println("O nome deve conter mais de 10 letras");
            System.out.println("Tente novamente:");
            verifyNameLength(sc, answer);
        }
    }

    private static void verifyEmail(Scanner sc, List<String> answer) {
        String email = sc.nextLine();
        if (answer.contains(email)) {
            System.out.println("Email já cadastrado");
            System.out.println("Tente novamente");
            verifyEmail(sc, answer);
        } else {
            answer.add(email);
        }
    }

    private static void verifyAge(Scanner sc, List<String> answer) {
        int age = Integer.parseInt(sc.nextLine());
        if (age >= 18) {
            answer.add(String.valueOf(age));
        } else {
            System.out.println("Usuário deve ter mais de 18 anos");
            System.out.println("Tente novamente:");
            verifyAge(sc, answer);
        }
    }

    private static void verifyHeight(Scanner sc, List<String> answer) {
        String heightString = sc.nextLine();

        if (heightString.contains(",")) {
            System.out.println("Use '.' como separador decimal ");
            System.out.println("Tente novamente:");
            verifyHeight(sc, answer);
        } else {
            try {
                double height = Double.parseDouble(heightString);
                answer.add(String.valueOf(height));

            } catch (NumberFormatException e) {
                System.out.println("Formato inválido. Insira um número válido");
                System.out.println("Tente novamente:");
                verifyAge(sc, answer);
            }
        }
    }
}



