package usersystem;

import javafx.application.Application;
import javafx.stage.Stage;
import view.LoginScreen;

public class UserSystem extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("User System");
        LoginScreen loginScreen = new LoginScreen(stage);
        stage.setScene(loginScreen.getScene());
        stage.setResizable(false);
        stage.setHeight(600);
        stage.setWidth(1000);
        stage.show();
    }
}
