module com.exceptions.exceptionsfinal {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.exceptions.exceptionsfinal to javafx.fxml;
    exports com.exceptions.exceptionsfinal;
    exports com.exceptions.exceptionsfinal.exceptions;
    opens com.exceptions.exceptionsfinal.exceptions to javafx.fxml;
}