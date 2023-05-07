public class DivisionByZeroException extends Exception{
    public String getException() {
        String e = "ПРЕДУПРЕЖДЕНИЕ: попытка деления на 0 в ходе выполнения программы.\nРезультат данной операции будет приравнен к 0.";
        return e;     
    }
}
