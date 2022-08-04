package view;

import controller.UserController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginScreen {
    private Scene scene;
    private Label username, password;
    private VBox centerBox;
    private HBox usernameBox, passwordBox, buttonBox;
    private BorderPane borderPane;
    private TextField usernameField, passwordField;
    private Button signinBtn, signupBtn, updateBtn, deleteBtn;
    private UserController userController;
    
    public LoginScreen(Stage stage){
        initComponents(stage);
    }
    
    public void initComponents(Stage stage){
        userController = new UserController();
        ProfileScreen profileScreen = new ProfileScreen(stage);

        username = new Label("Username");
        password = new Label("Password");
        usernameField = new TextField();
        passwordField = new TextField();
        
        usernameBox = new HBox(10);
        usernameBox.getChildren().addAll(username, usernameField);
        usernameBox.setAlignment(Pos.CENTER);
        
        passwordBox = new HBox(10);
        passwordBox.getChildren().addAll(password, passwordField);
        passwordBox.setAlignment(Pos.CENTER);
        
        signinBtn = new Button("SignIn");
        signinBtn.setOnAction(e->{
            userController.read(usernameField.getText(), passwordField.getText());
            stage.setScene(profileScreen.getScene());
        });

        signupBtn = new Button("SignUp");
        signupBtn.setOnAction(e->{
            userController.create(usernameField.getText(), passwordField.getText());
        });

        updateBtn = new Button("Update Account");
        updateBtn.setOnAction(e->{
            UpdateScreen updateScreen = new UpdateScreen();
            stage.setScene(updateScreen.getScene());
        });
        
        deleteBtn = new Button("Delete Account");
        deleteBtn.setOnAction(e->{
            userController.read();
            userController.delete(usernameField.getText(), passwordField.getText());
        });

        buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(signinBtn, signupBtn, updateBtn, deleteBtn);
        buttonBox.setAlignment(Pos.CENTER);
        
        centerBox = new VBox(10);
        centerBox.getChildren().addAll(usernameBox, passwordBox, buttonBox);
        centerBox.setAlignment(Pos.CENTER);
        
        borderPane = new BorderPane();
        borderPane.setCenter(centerBox);
        
        scene = new Scene(borderPane);
    }
    
    public Scene getScene(){
        return scene;
    }
}
