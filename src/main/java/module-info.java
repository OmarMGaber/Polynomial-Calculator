module polynomialcalculator {

    requires javafx.controls;
    requires javafx.fxml;


    opens polynomialcalculator to javafx.fxml;
    exports polynomialcalculator;
}