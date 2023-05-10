import java.util.Scanner;

public class Lesson002 {
    public static void main(String[] args) {
        System.out.println("Запуск программы...");
        checkInput();
        System.out.println("Программа успешно завершена.\n");

        }

    /*
     * Запрос Пользователя на ввод данных
     * Введена пустая строка -> пробрасывается исключение и запрос на повторный ввод
     * Введена не пустая строка -> считанный аргумент передается в метод checkIfFloat
     */
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

    /*
     * На вход принимается аргумент, считанный из ввода Пользователя
     * Аргумент проверяется на возможность форматирования в тип Float
     * Аргумент можно формаматировать -> форматирование, вывод ответного сообщения в терминал
     * Аргумент нельзя форматировать -> пробрасывается исключение и запрос на повторный ввод
     * В случае успешного форматирования устанавливается флаг на прерывание цикла всей программы
     */
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
