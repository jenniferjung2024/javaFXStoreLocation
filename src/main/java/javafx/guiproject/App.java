package javafx.guiproject;

import javafx.application.Application;
import javafx.scene.Scene;  
import javafx.stage.Stage;

import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.layout.HBox;
// import javafx.scene.layout.GridPane;  // NOT NEEDED FOR HBOX AND VBOX

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.Button;
import javafx.geometry.Insets;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.Optional;
import javafx.scene.control.ButtonType;

/**
 * JavaFX App
 */

public class App extends Application {

    /*

    Code used for simple window - not nested layouts with hbox and vbox....(see below)

    private Label cityLabel;     
    private Label managerLabel;     
    private Label zipCodeLabel;
    private Label stateAbbLabel;
    private Label locationIDLabel;

    */

    private TextField cityField;  
    private TextField managerField; 
    private TextField zipCodeField;
    private TextField stateAbbField;
    private TextField locationIDField;
    private Button addButton;   
    private Button deleteButton;

    TableView<Location> locationTable = new TableView<Location>();

    @Override
    public void start(Stage applicationStage) {
                
        cityField = new TextField(); 
        cityField.setPromptText("City");
        cityField.setPrefColumnCount(10);
        // cityField.setEditable(true);  // NO NEED FOR VBOX/HBOX

        managerField = new TextField(); 
        managerField.setPromptText("Manager");
        // managerField.setEditable(true);  // NO NEED FOR VBOX/HBOX

        zipCodeField = new TextField(); 
        zipCodeField.setPromptText("Zip Code");
        zipCodeField.setPrefColumnCount(10);
        // zipCodeField.setEditable(true);  // NO NEED FOR VBOX/HBOX

        stateAbbField = new TextField(); 
        stateAbbField.setPromptText("State Abbreviation (2 letters)");
        stateAbbField.setPrefColumnCount(15);
        //stateAbbField.setEditable(true);  // NO NEED FOR VBOX/HBOX

        locationIDField = new TextField(); 
        locationIDField.setPromptText("Location ID");
        // locationIDField.setEditable(true);   // NO NEED FOR VBOX/HBOX

        addButton = new Button("Add");
        addButton.setOnAction(event -> addButtonMethod());
        deleteButton = new Button("Delete");
        deleteButton.setOnAction(event -> deleteButtonMethod());

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10, 10, 10, 10));
        hbox.setSpacing(10);
        hbox.getChildren().addAll(cityField, managerField, zipCodeField, stateAbbField, locationIDField, addButton, deleteButton);

        final Label title = new Label("Active List of Locations");
        title.setFont(new Font("Arial", 20));
        title.setStyle("-fx-font-weight: bold");
 
        locationTable.setEditable(true);
 
        TableColumn cityCol = new TableColumn("City");
        cityCol.setMinWidth(100);
        cityCol.setCellValueFactory(new PropertyValueFactory<Location, String>("city"));
        cityCol.setCellFactory(TextFieldTableCell.forTableColumn());
 
        TableColumn managerCol = new TableColumn("Manager");
        managerCol.setMinWidth(300);
        managerCol.setCellValueFactory(new PropertyValueFactory<Location, String>("storeManager"));
        managerCol.setCellFactory(TextFieldTableCell.forTableColumn());
 
        TableColumn zipCodeCol = new TableColumn("Zip Code");
        zipCodeCol.setMinWidth(100);
        zipCodeCol.setCellValueFactory(new PropertyValueFactory<Location, String>("zipCode"));
        zipCodeCol.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn stateAbbCol = new TableColumn("State Abbreviation");
        stateAbbCol.setMinWidth(200);
        stateAbbCol.setCellValueFactory(new PropertyValueFactory<Location, String>("stateAbb"));
        stateAbbCol.setCellFactory(TextFieldTableCell.forTableColumn());
        
        TableColumn locationIDCol = new TableColumn("Location ID");
        locationIDCol.setMinWidth(100);
        locationIDCol.setCellValueFactory(new PropertyValueFactory<Location, String>("locationID"));
        locationIDCol.setCellFactory(TextFieldTableCell.forTableColumn());

        locationTable.getColumns().addAll(cityCol, managerCol, zipCodeCol, stateAbbCol, locationIDCol);
        locationTable.setItems(getLocation());

        locationTable.setFixedCellSize(25);
        locationTable.prefHeightProperty().bind(Bindings.size(locationTable.getItems()).multiply(locationTable.getFixedCellSize()).add(30));

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(title, locationTable, hbox);

        /*

        Code for simple window - not nested layouts with hbox and vbox....

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
        deleteButton = new Button("Delete");

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
        gridPane.add(deleteButton, 0, 6);

        */ 

        Scene scene2 = new Scene(vbox);

        applicationStage.setScene(scene2);
        applicationStage.setTitle("Store Locations");
        applicationStage.show();
    }

    public ObservableList<Location> getLocation() {
        ObservableList<Location> locations = FXCollections.observableArrayList();
        locations.add(new Location("Selden", "Jennifer Jung", "11784", "NY", "01100"));
        locations.add(new Location("Tampa", "John Doe", "33592", "FL", "01101"));
        locations.add(new Location("Miami", "Jane Doe", "33101", "FL", "01102"));
        locations.add(new Location("Riverhead", "Adam Bailey", "11901", "NY", "01103"));
        locations.add(new Location("Beverly Hills", "Chad Michael Murray", "90210", "CA", "01104"));
        return locations;
    }

    public void addButtonMethod(){
        Location location = new Location();
        location.setCity(cityField.getText());
        location.setStoreManager(managerField.getText());;
        location.setZipCode(zipCodeField.getText());
        location.setStateAbb(stateAbbField.getText());  // Will need to add data validation to this later on
        location.setLocationID(locationIDField.getText());
        locationTable.getItems().add(location);
        cityField.clear();
        managerField.clear();
        zipCodeField.clear();
        stateAbbField.clear();
        locationIDField.clear();
    }

    public void deleteButtonMethod(){
        ObservableList<Location> locationSelected, allLocations;
        allLocations = locationTable.getItems();
        locationSelected = locationTable.getSelectionModel().getSelectedItems();

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Delete Confirmation Alert");
        alert.setContentText("Click OK if you want to delete the location.");
        
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            locationSelected.forEach(allLocations::remove);
        }   

    }


    public static void main(String[] args) {
        launch(args);
    }

}