import java.util.Scanner;

public class Lesson002 {
    public static void main(String[] args) {
        System.out.println("Запуск программы...");
        checkInput();
        System.out.println("Программа успешно завершена.\n");

        }

    private static void checkInput() {
        boolean success = false;
        System.out.println("\nВведите дроебное число:");
        try (Scanner scanner = new Scanner(System.in)) {
            while (success != true) {
                try {
                    String user_input = scanner.nextLine();
                    if (user_input.equals("")) {
                        throw new EmptyStringException();
                    } else {
                    success = checkIfFloat(user_input);  
                    }                
                } catch (EmptyStringException e) {
                    e.getException();
                }
            }
        }   
    }

    private static boolean checkIfFloat(String input) {
        boolean flag = false;
        try {
            float user_float = Float.parseFloat(input);
            System.out.println("Спасибо. Вы ввели: " + user_float);
            flag = true;
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат ввода. Введите ДРОБНОЕ число в формате 0.0:");
        }
        return flag;
    }

    }
