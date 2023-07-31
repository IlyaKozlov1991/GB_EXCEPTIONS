package com.exceptions.exceptionsfinal;

import java.net.URL;

import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button checkUserButton;

    @FXML
    private TextField userBirthDay;

    @FXML
    private TextField userFirstName;

    @FXML
    private TextField userGender;

    @FXML
    private TextField userMiddleName;

    @FXML
    private TextField userPhoneNumber;

    @FXML
    private TextField userSecondName;

    @FXML
    void initialize() {
        Application application = new Application();
        application.checkButtonEvent(checkUserButton, userFirstName, userSecondName, userMiddleName,
                userPhoneNumber, userBirthDay, userGender);
    }
}