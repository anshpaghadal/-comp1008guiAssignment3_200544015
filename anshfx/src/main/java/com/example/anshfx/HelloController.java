package com.example.anshfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HelloController {

    @FXML
    private TextField nameEntered;

    @FXML
    private ColorPicker colorPicker;
    private String[] nameList = new String[9];
    private Color[] colorsList = new Color[9];

    @FXML
    private Pane studentPane1;
    @FXML
    private Pane studentPane2;
    @FXML
    private Pane studentPane3;
    @FXML
    private Pane studentPane4;
    @FXML
    private Pane studentPane5;
    @FXML
    private Pane studentPane6;
    @FXML
    private Pane studentPane7;
    @FXML
    private Pane studentPane8;
    @FXML
    private Pane studentPane9;

    @FXML
    private Text nameText1;
    @FXML
    private Text nameText2;
    @FXML
    private Text nameText3;
    @FXML
    private Text nameText4;
    @FXML
    private Text nameText5;
    @FXML
    private Text nameText6;
    @FXML
    private Text nameText7;
    @FXML
    private Text nameText8;
    @FXML
    private Text nameText9;

    @FXML
    private Label dispalyMessage;

   


    @FXML
    void addingStudent(ActionEvent event) {
        String nameText = nameEntered.getText().trim().toLowerCase();
        Color colorPicked = colorPicker.getValue();

        if (nameText.length() < 1 ) {
            messageOftheError("Please Enter the name.");

            return;
        }

        if (nameText.length() < 2 ) {
            messageOftheError("Name is too short.");
            return;
        }

        if (nameText.contains(" ")) {
            messageOftheError("Do not include space.");
            return;
        }

        if (colorPicked.equals(Color.WHITE)) {
            messageOftheError("Select another color than white.");
            return;
        }

        if (haveData(nameList, nameText)) {
            messageOftheError("Student is already added.");
            return;
        }

        if (haveData(colorsList, colorPicked)) {
            messageOftheError("Color already exists.");
            return;
        }

        int seatIndex = emptySeats();
        if (seatIndex != -1) {
            Pane[] studentPanes = {studentPane1, studentPane2, studentPane3, studentPane4, studentPane5, studentPane6, studentPane7, studentPane8, studentPane9};
            Text[] studentTexts = {nameText1, nameText2, nameText3, nameText4, nameText5, nameText6, nameText7, nameText8, nameText9};

            studentPanes[seatIndex].setStyle("-fx-background-color: #" + colorPicked.toString().substring(2));
            studentTexts[seatIndex].setText(nameText);
            studentTexts[seatIndex].setVisible(true);

            nameList[seatIndex] = nameText;
            colorsList[seatIndex] = colorPicked;

            dispalyMessage.setText(nameText+" added successfully!");
            dispalyMessage.setStyle("-fx-text-fill: lightgreen");


        } else {
            messageOftheError("No seats left for " +"'"+ nameText+"'");

        }
    }

    private boolean haveData(Object[] array, Object obj) {
        for (Object element : array) {
            if (element != null && element.equals(obj)) {
                return true;
            }
        }
        return false;
    }
    private int emptySeats() {
        List<Integer> vacantSeats = new ArrayList<>();
        for (int i = 0; i < nameList.length; i++) {
            if (nameList[i] == null) {
                vacantSeats.add(i);
            }
        }
        if (vacantSeats.isEmpty()) {
            return -1;
        }
        Random random = new Random();
        return vacantSeats.get(random.nextInt(vacantSeats.size()));
    }

    private void messageOftheError(String message) {

        dispalyMessage.setText(message);
        dispalyMessage.setStyle("-fx-text-fill: red");
    }
}