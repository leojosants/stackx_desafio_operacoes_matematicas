import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.directory.NoSuchAttributeException;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        try {

            System.out.println("\nInforme os dados abaixo solicitados");

            String email = requestEmail(scanner);

            // validarEmail(email);

            String name = requestName(scanner);
            Integer age = requestAge(scanner);

            System.out.println("\nInforme dois valores inteiros diferentes");

            Integer first_value = requestFirstValue(scanner);
            Integer second_value = requestSecondValue(scanner);
            Boolean equal_values = checkIfValuesAreEqual(first_value, second_value);

            requestNewValues(equal_values, scanner, first_value, second_value);

            Integer sum_result = performSum(first_value, second_value);
            Integer substraction_result = performSubtraction(first_value, second_value);
            Integer multiplication_result = performMultiplication(first_value, second_value);
            Integer division_result = performDivision(first_value, second_value);

            displayData(email, name, age, first_value, second_value, sum_result, substraction_result,
                    multiplication_result, division_result);
                    
        } catch (ArithmeticException e) {
            System.out.println("\n-> erro, não é possível realizar divisão por zero");

        } catch (InputMismatchException e) {
            System.out.println("\n-> erro, entrada inválida, reinicie o processo");

        } catch (Exception e) {
            System.out.println(e);

        } finally {
            scanner.close();
            System.out.println("-> fim do programa");
        }
    }

    /*
     * methods
     */
    private static String requestEmail(Scanner scanner) throws Exception {
        String email = "";

        do {
            System.out.print("\nDigite o e-mail [usuario@email.com]: ");
            email = scanner.nextLine().trim();

            while (email.isEmpty()) {
                System.out.print("-> campo 'e-mail' não pode ser vazio, digite o e-mail novamente [usuario@email.com]: ");
                email = scanner.nextLine().trim();
            }
        } while ((email.isEmpty()));

        while (validarEmail(email)) {
            System.out.print("-> 'e-mail' inválido, digite o e-mail novamente [usuario@email.com]: ");
            email = scanner.nextLine().trim();
            validarEmail(email);
        }

        return email;
    }

    private static boolean validarEmail(String email) throws Exception {
        boolean isValid = false;
        Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,3}$");
        Matcher m = p.matcher(email.trim());
        isValid = (!m.find());
        return isValid;
    }

    private static String requestName(Scanner scanner) {
        String name = "";

        do {
            System.out.print("\nDigite o nome: ");
            name = scanner.nextLine().trim();

            while (name.isEmpty()) {
                System.out.print("-> campo 'nome' não pode ser vazio, digite o nome novamente: ");
                name = scanner.nextLine().trim();
            }
        } while (name.isEmpty());

        return name;
    }

    private static Integer requestAge(Scanner scanner) {
        Integer age = 0;

        do {
            System.out.print("\nDigite a idade: ");
            age = scanner.nextInt();

            while (age < 0) {
                System.out.print("-> campo 'idade' não pode ser menor que zero, digite a idade novamente: ");
                age = scanner.nextInt();
            }
        } while (age < 0);

        return age;
    }

    private static Integer requestFirstValue(Scanner scanner) {
        Integer number = 0;

        do {
            System.out.print("Digite o primeiro valor: ");
            number = scanner.nextInt();

            while (number < 0) {
                System.out.print(
                        "-> campo 'primeiro valor' deve ser um numero positivo, digite o primeiro valor novamente: ");
                number = scanner.nextInt();
            }
        } while (number < 0);

        return number;
    }

    private static Integer requestSecondValue(Scanner scanner) {
        Integer number = 0;

        do {
            System.out.print("\nDigite o segundo valor: ");
            number = scanner.nextInt();

            while (number < 0) {
                System.out.print(
                        "-> campo 'segundo valor' deve ser um numero positivo, digite o segundo valor novamente: ");
                number = scanner.nextInt();
            }
        } while (number < 0);

        return number;
    }

    private static Boolean checkIfValuesAreEqual(Integer first_value, Integer second_value) {
        Boolean equal_values = false;

        if (first_value.equals(second_value)) {
            equal_values = true;
        }

        return equal_values;
    }

    private static void requestNewValues(Boolean equal_values, Scanner scanner, Integer first_value,
            Integer second_value) {
        if (equal_values == true) {
            do {
                System.out.println("\n-> os valores não podem ser iguais, tente novamente\n");
                first_value = requestFirstValue(scanner);
                second_value = requestSecondValue(scanner);
                equal_values = checkIfValuesAreEqual(first_value, second_value);
            } while (equal_values == true);
        }
    }

    private static Integer performSum(Integer first_value, Integer second_value) {
        Integer result = 0;
        result = (first_value + second_value);
        return result;
    }

    private static Integer performSubtraction(Integer first_value, Integer second_value) {
        Integer result = 0;
        result = (first_value - second_value);
        return result;
    }

    private static Integer performMultiplication(Integer first_value, Integer second_value) {
        Integer result = 0;
        result = (first_value * second_value);
        return result;
    }

    private static Integer performDivision(Integer first_value, Integer second_value) {
        Integer result = 0;
        result = (first_value / second_value);
        return result;
    }

    private static void displayData(String email, String name, Integer age, Integer first_value, Integer second_value,
            Integer sum_result, Integer substraction_result, Integer multiplication_result, Integer division_result) {
        System.out.println("\n- Informações do usuário -");
        System.out.printf("Email informado:  %s%n", email);
        System.out.printf("Nome  informado:  %s%n", name);
        System.out.printf("Idade informada:  %d%n", age);

        System.out.println("\n- Resultados das operações matemáticas - ");
        System.out.printf("Primeiro valor informado:   %d%n", first_value);
        System.out.printf("Segundo  valor informado:   %d%n", second_value);
        System.out.printf("Resultado da adição:        %d%n", sum_result);
        System.out.printf("Resultado da subtração:     %d%n", substraction_result);
        System.out.printf("Resultado da multiplicação: %d%n", multiplication_result);
        System.out.printf("Resultado da divisão:       %d%n", division_result);
    }
}