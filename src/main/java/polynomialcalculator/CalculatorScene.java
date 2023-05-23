package polynomialcalculator;

import LinkedList.SingleLinkedList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CalculatorScene {
    Label title;

    Label firstPolynomialLabel;
    Label secondPolynomialLabel;
    Label resultPolynomialLabel;
    Label enterVariableLabel;
    Label evalResult;

    TextField firstPolynomialTextField;
    TextField secondPolynomialTextField;
    TextField resultPolynomialTextField;
    TextField evaluate1stTextField;
    TextField evaluate2ndTextField;
    TextField evaluateResultTextField;
    TextField firstVariableTextField;
    TextField secondVariableTextField;
    TextField resultVariableTextField;


    Button addButton;
    Button subtractButton;
    Button multiplyButton;
    Button clearButton;
    Button evaluate1stButton;
    Button evaluate2ndButton;
    Button evaluate3rdButton;

    GridPane gridPane;

    CalculatorScene() {
        initialize();
        renderScene();
        addButtonActions();
        addStyles();
    }

    void initialize() {
        title = new Label("Polynomial Calculator");
        firstPolynomialLabel = new Label("First Polynomial");
        secondPolynomialLabel = new Label("Second Polynomial");
        resultPolynomialLabel = new Label("Result Polynomial");
        enterVariableLabel = new Label("Enter Variable X Value");
        evalResult = new Label("Evaluation Result");

        firstPolynomialTextField = new TextField();
        secondPolynomialTextField = new TextField();
        resultPolynomialTextField = new TextField();
        evaluate1stTextField = new TextField();
        evaluate2ndTextField = new TextField();
        evaluateResultTextField = new TextField();

        addButton = new Button("Add");
        subtractButton = new Button("Subtract");
        multiplyButton = new Button("Multiply");
        clearButton = new Button("Clear");
        evaluate1stButton = new Button("eval");
        evaluate2ndButton = new Button("eval");
        evaluate3rdButton = new Button("eval");

        firstVariableTextField = new TextField();
        secondVariableTextField = new TextField();
        resultVariableTextField = new TextField();

        gridPane = new GridPane();
    }

    void renderScene() {
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(title, 0, 0, 4, 1);
        gridPane.add(firstPolynomialLabel, 0, 1);
        gridPane.add(firstPolynomialTextField, 1, 1, 3, 1);
        gridPane.add(secondPolynomialLabel, 0, 2);
        gridPane.add(secondPolynomialTextField, 1, 2, 3, 1);
        gridPane.add(resultPolynomialLabel, 0, 3);
        gridPane.add(resultPolynomialTextField, 1, 3, 3, 1);
        gridPane.add(addButton, 1, 4);
        gridPane.add(subtractButton, 2, 4);
        gridPane.add(multiplyButton, 3, 4);
        gridPane.add(clearButton, 4, 4);
        gridPane.add(enterVariableLabel, 4, 0);
        gridPane.add(firstVariableTextField, 4, 1);
        gridPane.add(secondVariableTextField, 4, 2);
        gridPane.add(resultVariableTextField, 4, 3);
        gridPane.add(evaluate1stButton, 5, 1);
        gridPane.add(evaluate2ndButton, 5, 2);
        gridPane.add(evaluate3rdButton, 5, 3);
        gridPane.add(evalResult, 6, 0);
        gridPane.add(evaluate1stTextField, 6, 1);
        gridPane.add(evaluate2ndTextField, 6, 2);
        gridPane.add(evaluateResultTextField, 6, 3);

    }

    void addButtonActions(){
        Main main = new Main();

        addButton.setOnAction(e -> {
            SingleLinkedList firstPolynomial = main.newPolynomial(firstPolynomialTextField.getText());
            SingleLinkedList secondPolynomial = main.newPolynomial(secondPolynomialTextField.getText());
            SingleLinkedList resultPolynomial = main.add(firstPolynomial, secondPolynomial);
            resultPolynomialTextField.setText(resultPolynomial.toString());
        });

        subtractButton.setOnAction(e -> {
            SingleLinkedList firstPolynomial = main.newPolynomial(firstPolynomialTextField.getText());
            SingleLinkedList secondPolynomial = main.newPolynomial(secondPolynomialTextField.getText());
            SingleLinkedList resultPolynomial = main.sub(firstPolynomial, secondPolynomial);
            resultPolynomialTextField.setText(resultPolynomial.toString());
        });

        multiplyButton.setOnAction(e -> {
            SingleLinkedList firstPolynomial = main.newPolynomial(firstPolynomialTextField.getText());
            SingleLinkedList secondPolynomial = main.newPolynomial(secondPolynomialTextField.getText());
            SingleLinkedList resultPolynomial = main.multiply(firstPolynomial, secondPolynomial);
            resultPolynomialTextField.setText(resultPolynomial.toString());
        });

        clearButton.setOnAction(e -> {
            firstPolynomialTextField.setText("");
            secondPolynomialTextField.setText("");
            resultPolynomialTextField.setText("");
            firstVariableTextField.setText("");
            secondVariableTextField.setText("");
            resultVariableTextField.setText("");
            evaluate1stTextField.setText("");
            evaluate2ndTextField.setText("");
            evaluateResultTextField.setText("");
        });

        evaluate1stButton.setOnAction(e -> {
            SingleLinkedList firstPolynomial = main.newPolynomial(firstPolynomialTextField.getText());
            double variable = Double.parseDouble(firstVariableTextField.getText());
            double result = main.evaluate(variable, firstPolynomial);
            evaluate1stTextField.setText(String.valueOf(result));
        });

        evaluate2ndButton.setOnAction(e -> {
            SingleLinkedList secondPolynomial = main.newPolynomial(secondPolynomialTextField.getText());
            double variable = Double.parseDouble(secondVariableTextField.getText());
            double result = main.evaluate(variable, secondPolynomial);
            evaluate2ndTextField.setText(String.valueOf(result));
        });

        evaluate3rdButton.setOnAction(e -> {
            SingleLinkedList resultPolynomial = main.newPolynomial(resultPolynomialTextField.getText());
            double variable = Double.parseDouble(resultVariableTextField.getText());
            double result = main.evaluate(variable, resultPolynomial);
            evaluateResultTextField.setText(String.valueOf(result));
        });
    }

    void addStyles(){
        title.getStyleClass().add("title");
        firstPolynomialLabel.getStyleClass().add("subtitle");
        secondPolynomialLabel.getStyleClass().add("subtitle");
        resultPolynomialLabel.getStyleClass().add("subtitle");
        enterVariableLabel.getStyleClass().add("subtitle");
        evalResult.getStyleClass().add("subtitle");
        addButton.getStyleClass().add("button");
        subtractButton.getStyleClass().add("button");
        multiplyButton.getStyleClass().add("button");
        clearButton.getStyleClass().add("button");
        evaluate1stButton.getStyleClass().add("button");
        evaluate2ndButton.getStyleClass().add("button");
        evaluate3rdButton.getStyleClass().add("button");
        firstPolynomialTextField.getStyleClass().add("text-field");
        secondPolynomialTextField.getStyleClass().add("text-field");
        resultPolynomialTextField.getStyleClass().add("text-field");
        evaluate1stTextField.getStyleClass().add("text-field");
        evaluate2ndTextField.getStyleClass().add("text-field");
        evaluateResultTextField.getStyleClass().add("text-field");
        firstVariableTextField.getStyleClass().add("text-field");
        secondVariableTextField.getStyleClass().add("text-field");
        resultVariableTextField.getStyleClass().add("text-field");

    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public Scene getScene() {
        return new Scene(gridPane, 1000, 600);
    }
}
