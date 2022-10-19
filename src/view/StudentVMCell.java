package view;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.BorderPane;
import viewmodel.StudentVM;

public class StudentVMCell extends ListCell<StudentVM> {
    @Override
    protected void updateItem(StudentVM item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty) {

            Label lastnameLbl = new Label();
            Label firstnameLbl = new Label();
            lastnameLbl.textProperty().bind(item.lastnameProperty());
            firstnameLbl.textProperty().bind(item.firstnameProperty());

            BorderPane pane = new BorderPane();
            pane.setLeft(lastnameLbl);
            pane.setCenter(firstnameLbl);

            setGraphic(pane);
        }
        else {
            setGraphic(null);
        }
    }
}
