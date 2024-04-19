package javafx.guiproject;

import javafx.application.Application;
import javafx.scene.Scene;  
import javafx.stage.Stage;

// import javafx.fxml.FXMLLoader;  // DELETE LATER
// import javafx.scene.Parent;  // DELETE LATER
// import java.io.IOException;  // DELETE LATER

import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
// import javafx.event.ActionEvent;
// import javafx.event.EventHandler;

/**
 * JavaFX App
 */

public class App extends Application {

    private Label cityLabel;     
    private Label managerLabel;     
    private Label zipCodeLabel;
    private Label stateAbbLabel;
    private Label locationIDLabel;
    private TextField cityField;  
    private TextField managerField; 
    private TextField zipCodeField;
    private TextField stateAbbField;
    private TextField locationIDField;
    private Button addButton;   

    // private static Scene scene;  DELETE

    @Override
    public void start(Stage applicationStage) {
        
        Scene scene = null;
        GridPane gridPane = null;
        Insets gridPadding = null;

        gridPane = new GridPane();
        scene = new Scene(gridPane);

        cityLabel = new Label("City:");
        managerLabel = new Label("Manager:");
        zipCodeLabel = new Label("Zip Code:");
        stateAbbLabel = new Label("State Abbreviation (2 letters): ");
        locationIDLabel = new Label("Location ID:");
        
        cityField = new TextField(); 
        cityField.setPrefColumnCount(15);
        cityField.setEditable(true);

        managerField = new TextField(); 
        managerField.setPrefColumnCount(15);
        managerField.setEditable(true);

        zipCodeField = new TextField(); 
        zipCodeField.setPrefColumnCount(15);
        zipCodeField.setEditable(true);

        stateAbbField = new TextField(); 
        stateAbbField.setPrefColumnCount(15);
        stateAbbField.setEditable(true);

        locationIDField = new TextField(); 
        locationIDField.setPrefColumnCount(15);
        locationIDField.setEditable(true);

        addButton = new Button("Add");

        gridPadding = new Insets(10, 10, 10, 10); // Padding values for top, right, bottom, and left
        gridPane.setPadding(gridPadding);         // Set padding around  grid
        gridPane.setHgap(10);                     // Spacing between columns
        gridPane.setVgap(10);                     // Spacing between rows     

        gridPane.add(cityLabel, 0, 0);
        gridPane.add(cityField, 1, 0);
        gridPane.add(managerLabel, 0, 1);
        gridPane.add(managerField, 1, 1);
        gridPane.add(zipCodeLabel, 0, 2);
        gridPane.add(zipCodeField, 1, 2);
        gridPane.add(stateAbbLabel, 0, 3);
        gridPane.add(stateAbbField, 1, 3);
        gridPane.add(locationIDLabel, 0, 4);
        gridPane.add(locationIDField, 1, 4);
        gridPane.add(addButton, 0, 5);

        applicationStage.setScene(scene);
        applicationStage.setTitle("Store Locations");
        applicationStage.show();
    }

    /*
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    */

    public static void main(String[] args) {
        launch(args);
    }

}