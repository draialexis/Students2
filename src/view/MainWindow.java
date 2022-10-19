package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import viewmodel.PromotionVM;
import viewmodel.StudentVM;

import java.io.IOException;

public class MainWindow {
    @FXML
    private ListView<StudentVM> promLV;
    @FXML
    private Label lastnameTF;
    @FXML
    private TextField firstnameTF;

    @FXML
    private void clickAddStudent() {
        prepareCreationWindow();
    }

    private void prepareCreationWindow() {
        Stage stage = new Stage();
        stage.initOwner(promLV.getScene().getWindow());
        stage.initModality(Modality.WINDOW_MODAL);

        StudentCreationWindow controller = initCreationWindow(stage);

        if (controller.getLastname() != null && controller.getFirstname() != null) {
            VM.addStudentVM(new StudentVM(controller.getLastname(), controller.getFirstname()));
        }
    }

    private StudentCreationWindow initCreationWindow(Stage stage) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/StudentCreationWindow.fxml"));
        StudentCreationWindow controller = new StudentCreationWindow();
        loader.setController(controller);

        try {
            stage.setScene(new Scene(loader.load()));
            stage.showAndWait();
        } catch (IOException ex) {
            ex.printStackTrace();
            new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK).showAndWait();
        }
        return controller;
    }

    @FXML
    private void clickRemoveStudent() {
        VM.removeStudentVM(promLV.getSelectionModel().getSelectedItem());
        lastnameTF.setText("");
        firstnameTF.setText("");
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
                lastnameTF.textProperty().unbind();
                firstnameTF.textProperty().unbindBidirectional(oldV.firstnameProperty());
            }
            if (newV != null) {
                lastnameTF.textProperty().bind(newV.lastnameProperty());
                firstnameTF.textProperty().bindBidirectional(newV.firstnameProperty());
            }
        });
    }
}
