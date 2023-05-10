import java.util.NoSuchElementException;

public class Lesson002_Pt2 {
    public static void main(String[] args) throws Exception{
        
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (Throwable ex) { // Захват исключения
            System.out.println("Что-то пошло не так...");
            try {
                throw new NullPointerException(); // Проверка на нулевой указатель
            } catch (NullPointerException ex1) {
                System.out.println("Указатель не может указывать на null!");
                try {
                    throw new IndexOutOfBoundsException(); // Проверка на выход за пределы массива
                } catch (IndexOutOfBoundsException ex2) {
                        System.out.println("Массив выходит за пределы своего размера!");
                }
            }
        }
     
    }

    public static void printSum(Integer a, Integer b) throws NoSuchElementException { // FileNotFoundException заменен на NoSuchElementException
        System.out.println(a + b);
    }
     

    private static void Exercise2() {
        try {
            int[] intArray = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ,11}; // Добавлен массив
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
            throw new ArithmeticException(); // Добавлен проброс исключения
         } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
         }
         
    }

}
