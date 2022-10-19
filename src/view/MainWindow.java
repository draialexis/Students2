package view;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import viewmodel.PromotionVM;
import viewmodel.StudentVM;

public class MainWindow {
    @FXML
    private ListView<StudentVM> promLV;
    @FXML
    private TextField lastnameTF;
    @FXML
    private TextField firstnameTF;

    @FXML
    private void clickAddStudent() {
        VM.addStudent();
    }

    @FXML
    private void clickRemoveStudent() {
        VM.removeStudent(promLV.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void clickQuit() {
        lastnameTF.getScene().getWindow().hide();
    }

    private final PromotionVM VM;

    public MainWindow(PromotionVM VM) {
        this.VM = VM;
    }

    @FXML
    private void initialize() {

    }
}
