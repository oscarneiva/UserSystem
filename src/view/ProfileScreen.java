package view;

import controller.MapController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.File;


public class ProfileScreen {
    private Scene scene;

    public ProfileScreen(Stage stage){
        initComponents(stage);
    }

    public void initComponents(Stage stage){
        MapController mapController = new MapController();

        Label originLbl = new Label("Origin");
        TextField originTxt = new TextField();
        originTxt.setMaxSize(200,20);
        Label destLbl = new Label("Destination");
        TextField destTxt = new TextField();
        destTxt.setMaxSize(200,20);

        Button button = new Button("Find Route");
        button.setOnAction(e->{
            mapController.getRoute(originTxt.getText(), destTxt.getText());
        });

        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        File file = new File("./misc/map.html");
        webEngine.load(file.toURI().toString());
        webView.setMaxSize(700,350);

        VBox inputBox = new VBox(5);
        inputBox.setAlignment(Pos.CENTER);
        inputBox.getChildren().addAll(originLbl, originTxt, destLbl, destTxt, button);

        HBox webViewBox = new HBox();
        webViewBox.setAlignment(Pos.CENTER);
        webViewBox.getChildren().add(webView);

        VBox mainBox = new VBox(20);
        mainBox.getChildren().addAll(inputBox, webViewBox);

        scene = new Scene(mainBox);
    }

    public Scene getScene(){
        return scene;
    }
}
