public class ArraysSizeException extends Exception{
    public String getException() {
        String e = "ПРЕДУПРЕЖДЕНИЕ: массивы имеют разную длинну.\nНедостающие значения в итоговом массиве будут заменены на 0.";
        return e;     
    }
}
