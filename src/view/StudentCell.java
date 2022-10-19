package view;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import viewmodel.StudentVM;

public class StudentCell extends ListCell<StudentVM> {
    @Override
    protected void updateItem(StudentVM item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty) {

            Label lastnameLbl = new Label();
            Label firstnameLbl = new Label();
            Rectangle hairClrRect = new Rectangle();
            lastnameLbl.textProperty().bind(item.lastnameProperty());
            firstnameLbl.textProperty().bind(item.firstnameProperty());
            hairClrRect.setHeight(10.0);
            hairClrRect.setWidth(10.0);
            hairClrRect.fillProperty().bind(item.hairColorProperty());

            BorderPane pane = new BorderPane();
            pane.setLeft(lastnameLbl);
            pane.setCenter(firstnameLbl);
            pane.setRight(hairClrRect);

            setGraphic(pane);
        }
        else {
            setGraphic(null);
        }
    }
}
