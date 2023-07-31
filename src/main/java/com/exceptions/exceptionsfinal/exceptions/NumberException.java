package com.exceptions.exceptionsfinal.exceptions;
import com.exceptions.exceptionsfinal.HelloApplication;
import com.exceptions.exceptionsfinal.exceptions.AppException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NumberException extends AppException{
    public void getWarning() {
        try {
            FXMLLoader new_lLoader = new FXMLLoader(HelloApplication.class.getResource("NumberCheck.fxml"));
            Scene scene = new Scene(new_lLoader.load(), 450, 150);
            Stage stage = new Stage();
            stage.setTitle("Ошибка!");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {

        }
    }
}
