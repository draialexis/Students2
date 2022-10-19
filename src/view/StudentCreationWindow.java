package view;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class StudentCreationWindow {

    private String lastname;
    private String firstname;
    private Color hairColor;

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public Color getHairColor() {
        return hairColor;
    }

    @FXML
    private TextField firstnameTF;
    @FXML
    private TextField lastnameTF;
    @FXML
    private ColorPicker hairColorPicker;

    @FXML
    private void clickCreate() {
        lastname = lastnameTF.getText();
        firstname = firstnameTF.getText();
        hairColor = hairColorPicker.getValue();
        close();
    }

    @FXML
    private void clickCancel() {
        lastname = null;
        firstname = null;
        hairColor = null;
        close();
    }

    private void close(){
        firstnameTF.getScene().getWindow().hide();
    }
}
