package launcher;

import data.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.MainWindow;
import viewmodel.PromotionVM;

import java.io.IOException;

public class Launcher extends Application {

    private PromotionVM VM = null;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Loadable loader;

        try {
            loader = new Loader();
            VM = loader.load();
        } catch (IOException | ClassNotFoundException __) {
            System.err.println("could not load...");
            loader = new Stub();
            VM = loader.load();
        }
        if (VM == null) VM = new PromotionVM();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/MainWindow.fxml"));
        fxmlLoader.setController(new MainWindow(VM));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        Savable saver;
        try {
            saver = new Saver();
            saver.save(VM);
        } catch (IOException __) {
            System.err.println("could not save...");
        }

        super.stop();
    }
}
