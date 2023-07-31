package com.exceptions.exceptionsfinal;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.exceptions.exceptionsfinal.exceptions.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Application {
    public void checkButtonEvent(Button checkUserButton, TextField userFirstName, TextField userSecondName,
                                 TextField userMiddleName, TextField userPhoneNumber,
                                 TextField userBirthDay, TextField userGender) {
        checkUserButton.setOnAction(actionEvent -> {
            boolean successName1 = false;
            boolean successname2 = false;
            boolean successname3 = false;
            boolean successNumber = false;
            boolean successDate = false;
            boolean successSex = false;
            if (!userFirstName.getText().equals("") & !userSecondName.getText().equals("") &
                    !userMiddleName.getText().equals("") &
                    !userPhoneNumber.getText().equals("") & !userBirthDay.getText().equals("") &
                    !userGender.getText().equals("")) {
                /*
                Проверка правильного ввода фамилии
                Если ввод можно преобразовать в число -> некорректный ввод -> предупреждение
                Если ввод нельзя преобразовать в число -> захват ФорматЭкспешн и работа со строкой из ввода
                */
                try {
                    Integer.parseInt(userFirstName.getText());
                    throw new AppException();
                } catch (AppException e) {
                    try {
                        throw new NameException();
                    } catch (NameException ex) {
                        ex.getWarning();
                    }
                } catch (NumberFormatException e) {
                    successName1 = true;
                /*
                Исключение не обрабатывается, так как проверяется, что введены НЕ цифры (нельзя распарсить)
                */
                }
                // Аналогичная проверка для имени
                try {
                    Integer.parseInt(userSecondName.getText());
                    throw new AppException();
                } catch (AppException e) {
                    try {
                        throw new NameException();
                    } catch (NameException ex) {
                        ex.getWarning();
                    }
                } catch (NumberFormatException e) {
                    successname2 = true;
                /*
                Исключение не обрабатывается, так как проверяется, что введены НЕ цифры (нельзя распарсить)
                */
                }
                // Аналогичная проверка для отчества
                try {
                    Integer.parseInt(userMiddleName.getText());
                    throw new AppException();
                } catch (AppException e) {
                    try {
                        throw new NameException();
                    } catch (NameException ex) {
                        ex.getWarning();
                    }
                } catch (NumberFormatException e) {
                    successname3 = true;
                /*
                Исключение не обрабатывается, так как проверяется, что введены НЕ цифры (нельзя распарсить)
                */
                }
                /*
                Проверка правильности ввода номера телефона
                Если ввод можно преобразовать в число -> ввод корректный
                Если нельзя -> предупреждение
                */
                try {
                    Long.parseLong(userPhoneNumber.getText());
                    successNumber = true;
                } catch (NumberFormatException numberFormatException) {
                    try {
                        throw new NumberException();
                    } catch (NumberException numberException) {
                        numberException.getWarning();
                    }
                }
                /*
                Проверка правильности ввода даты рождения
                Дата в формате дд.мм.ггг -> верный формат
                Дата в любом другом формате -> предупреждение
                */
                try {
                    Date date = new SimpleDateFormat("dd.MM.yyy").parse(userBirthDay.getText());
                    System.out.println("Enetered date: " + date);
                    successDate = true;
                } catch (java.text.ParseException e1) {
                    try {
                        throw new DateException();
                    } catch (DateException dateException) {
                        dateException.getWarning();
                    }
                }
                /*
                Проверка правильности ввода пола
                Допустимо вводить только m, M, f, F
                 */
                if (userGender.getText().equalsIgnoreCase("M") |
                        userGender.getText().equalsIgnoreCase("F")) {
                    successSex = true;
                } else {
                    try {
                        throw new GenderException();
                    } catch (GenderException genderException) {
                        genderException.getWarning();
                    }
                }
                if (successName1 && successname2 && successname3 && successNumber && successDate && successSex) {
                    try {
                        FXMLLoader new_lLoader = new FXMLLoader(HelloApplication.class.getResource("Success.fxml"));
                        Scene scene = new Scene(new_lLoader.load(), 350, 150);
                        Stage stage = new Stage();
                        stage.setTitle("Успешно!");
                        stage.setScene(scene);
                        stage.setResizable(false);
                        stage.show();
                    } catch (IOException e) {
                    }
                }
            } else {
                try {
                    FXMLLoader new_lLoader = new FXMLLoader(HelloApplication.class.getResource("Fail.fxml"));
                    Scene scene = new Scene(new_lLoader.load(), 350, 150);
                    Stage stage = new Stage();
                    stage.setTitle("Ошибка!");
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

}