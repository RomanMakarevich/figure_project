package by.stormnet.figuresfx;

import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FiguresFxApp extends Application {
    public static void main(String[] args){
        launch();
    }

    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("FigureFX"); // window name
        Parent root = FXMLLoader.load(getClass().getResource("/views/MainScreenView.fxml"));
        window.setScene(new Scene(root, 1024, 600));
        window.setResizable(false);
        window.show();
    }
}
