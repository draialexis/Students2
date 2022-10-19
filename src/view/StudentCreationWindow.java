package view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class StudentCreationWindow {

    private String lastname;
    private String firstname;

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    @FXML
    private TextField firstnameTF;
    @FXML
    private TextField lastnameTF;

    @FXML
    private void clickCreate() {
        lastname = lastnameTF.getText();
        firstname = firstnameTF.getText();
        close();
    }

    @FXML
    private void clickCancel() {
        lastname = null;
        firstname = null;
        close();
    }

    private void close(){
        firstnameTF.getScene().getWindow().hide();
    }
}
