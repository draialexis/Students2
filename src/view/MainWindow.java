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
        VM.addStudentVM();
    }

    @FXML
    private void clickRemoveStudent() {
        VM.removeStudentVM(promLV.getSelectionModel().getSelectedItem());
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
        promLV.itemsProperty().bind(VM.studentsVMProperty());
        initPromLV();
        promLV.setCellFactory(__ -> new StudentVMCell());
    }

    private void initPromLV() {
        promLV.getSelectionModel().selectedItemProperty().addListener((__, oldV, newV) -> {
            if (oldV != null) {
                lastnameTF.textProperty().unbindBidirectional(oldV.lastnameProperty());
                firstnameTF.textProperty().unbindBidirectional(oldV.firstnameProperty());
            }
            if (newV != null) {
                lastnameTF.textProperty().bindBidirectional(newV.lastnameProperty());
                firstnameTF.textProperty().bindBidirectional(newV.firstnameProperty());
            }
        });
    }
}
