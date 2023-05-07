import java.util.Arrays;

public class ExceptApp {
    public static void main(String[] args) {
        System.out.println("Запуск программы\n...");
        int[] arr1 = new int[] {10, 12, 10, 15, 15};
        int[] arr2 = new int[] {4, 5, 6, 7};
        
        int[] result1 = subtractArrays(arr1, arr2);
        System.out.println("Итоговый массив: " + Arrays.toString(result1));
        System.out.println("Вычитание массивов завершено\n");
        int[] result2 = divideArrays(arr1, arr2);
        System.out.println("Итоговый массив: " + Arrays.toString(result2));
        System.out.println("Деление массивов завершено\n");
    }

    private static int[] subtractArrays(int[] arr1, int[] arr2) {
        System.out.println("Начало вычитания массивов");
        int[] result  = new int[] {};
        if (arr1.length < arr2.length) {
            try {
                int[] temp = new int[arr2.length];
                for (int i = 0; i < temp.length; i++) {
                    try {
                        temp[i] = arr1[i];
                    } catch (IndexOutOfBoundsException exp) {
                        temp[i] = arr2[i];
                    }
                }
                result = new int[temp.length];
                for (int i = 0; i < result.length; i++) {
                    result[i] = temp[i] - arr2[i];
                }
                throw new ArraysSizeException();
            } catch (ArraysSizeException e) {
                System.out.println(e.getException());
            }
        }
        if (arr1.length > arr2.length) {
            try {
                int[] temp = new int[arr1.length];
                for (int i = 0; i < temp.length; i++) {
                    try {
                        temp[i] = arr2[i];
                    } catch (IndexOutOfBoundsException exp) {
                        temp[i] = arr1[i];
                    }
                }
                result = new int[temp.length];
                for (int i = 0; i < result.length; i++) {
                    result[i] = arr1[i] - temp[i];
                }
                throw new ArraysSizeException();
            } catch (ArraysSizeException e) {
                System.out.println(e.getException());
            }
        }
        if (arr1.length == arr2.length) {
            result = new int[arr1.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = arr1[i] - arr2[i];
            }
        }
        return result;
    }

    private static int[] divideArrays(int[] arr1, int[] arr2) {
        System.out.println("Начало деления массивов");
        int[] result  = new int[] {};
        if (arr1.length < arr2.length) {
            try {
                int[] temp = new int[arr2.length];
                for (int i = 0; i < temp.length; i++) {
                    try {
                        temp[i] = arr1[i];
                    } catch (IndexOutOfBoundsException exp) {
                        temp[i] = 0;
                    }
                }
                result = new int[temp.length];
                for (int i = 0; i < result.length; i++) {
                    try {
                        result[i] = temp[i] / arr2[i];
                    } catch (ArithmeticException exp) {
                        try {
                            throw new DivisionByZeroException();
                        } catch (DivisionByZeroException exp1) {
                            System.out.println(exp1.getException());
                            result[i] = 0;
                        }
                    }
                }
                throw new ArraysSizeException();
            } catch (ArraysSizeException e) {
                System.out.println("ПРЕДУПРЕЖДЕНИЕ: для корректного выполнения программы длины массивов были приравнены с добавлением 0 к недостающим значениям.");
            }
        }
        if (arr1.length > arr2.length) {
            try {
                int[] temp = new int[arr1.length];
                for (int i = 0; i < temp.length; i++) {
                    try {
                        temp[i] = arr2[i];
                    } catch (IndexOutOfBoundsException exp) {
                        temp[i] = 0;
                    }
                }
                result = new int[temp.length];
                for (int i = 0; i < result.length; i++) {
                    try {
                        result[i] = arr1[i] / temp[i];
                    } catch (ArithmeticException exp) {
                        try {
                            throw new DivisionByZeroException();
                        } catch (DivisionByZeroException exp1) {
                            System.out.println(exp1.getException());
                            result[i] = 0;
                        }
                    }
                }
                throw new ArraysSizeException();
            } catch (ArraysSizeException e) {
                System.out.println("ПРЕДУПРЕЖДЕНИЕ: для корректного выполнения программы длины массивов были приравнены с добавлением 0 к недостающим значениям.");
            }
        }
        if (arr1.length == arr2.length) {
            result = new int[arr1.length];
            for (int i = 0; i < result.length; i++) {
                try {
                    result[i] = arr1[i] / arr2[i];
                } catch (ArithmeticException e) {
                    try {
                        throw new DivisionByZeroException();
                    } catch (DivisionByZeroException exp) {
                        System.out.println(exp.getException());
                        result[i] = 0;
                    }
                };
            }
        }
        return result;
    }

}
