package lab.unipi.gui;

import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import lab.unipi.core.City;

import java.util.ArrayList;
import java.util.List;

public class CitySceneCreator extends SceneCreator implements EventHandler<MouseEvent> {
	
    //List Of Cities
    ArrayList<City> cityList;
    ArrayList<City> cityListSearch;
    
    //Flow Pane
    FlowPane buttonFlowPane;
    
    //Grid Panes
    GridPane rootGridPane, inputFieldsPane;
    
    //City Scene Buttons
    Button newCityBtn, editCityBtn, deleteCityBtn, backBtn;
    
    //City Scene Labels
    Label  cityCodeLbl, cityNameLbl, searchLbl;
    
    //City Scene TextFields
    TextField  cityCodeField, cityNameField, searchField;
    
    //TableView
    TableView<City> cityTableView;

    
    
    public CitySceneCreator(double width, double height) {
    	
        super(width, height);
        
        //Arxikopoihsh twn fields
        cityList = new ArrayList<>();
        cityListSearch = new ArrayList<>();
        
        rootGridPane = new GridPane();
        buttonFlowPane = new FlowPane();

        cityCodeLbl = new Label("City Code ");
        cityNameLbl = new Label("City Name ");
        searchLbl = new Label("SEARCH ");
        
        cityCodeField = new TextField();
        cityNameField = new TextField();
        searchField = new TextField();
        
        newCityBtn = new Button("New City");
        editCityBtn = new Button("Update");
        deleteCityBtn = new Button("Delete");
        backBtn = new Button("Go Back");
        
        inputFieldsPane = new GridPane();
        cityTableView = new TableView<>();
        
        //Gray background gia to textfield
        cityCodeField.setStyle("-fx-background-color: gray;");
        //Prasino xrwma sto Label ths anazhthshs
        searchLbl.setStyle("-fx-text-fill: green; -fx-font-size: 16px;");


        
        //"Denw" ton EventHandler me to component apo to opoio kaleitai h  handle method kathe fora pou klikaroume
        backBtn.setOnMouseClicked(this);
        newCityBtn.setOnMouseClicked(this);
        editCityBtn.setOnMouseClicked(this);
        deleteCityBtn.setOnMouseClicked(this);
        cityTableView.setOnMouseClicked(this);

        //ANAZHTHSH POLEWS
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
        	pause.setOnFinished(event -> {
        		cityListSearch.clear();
        		for (City city: cityList) {
        			if (city.getCityName().toLowerCase().contains(newValue.toLowerCase())) {
        				cityListSearch.add(city);
        			}
        		}
        		tableSyncSearch();
        	});
            pause.playFromStart();
        	
        });
        
        //Rythmizw to Horizontal Gap (keno 10 pixels anamesa sta koumpakia) 
        buttonFlowPane.setHgap(10);
        
        //Vazw ta koumpakia sto flowPane
        buttonFlowPane.getChildren().add(newCityBtn);
        buttonFlowPane.getChildren().add(editCityBtn);
        buttonFlowPane.getChildren().add(deleteCityBtn);
        
        //Stoixizw sto katw meros kai kentro
        buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);

        //Stoixizw sto panw meros kai aristera
        inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
        
        //Rythmizw to Horizontal kai Vertical Gap se 10 pixels 
        inputFieldsPane.setVgap(50);
        inputFieldsPane.setHgap(10);
        
        //Vazw ta components sto flowPane (prwta sthlh, meta grammh)
        inputFieldsPane.add(cityCodeLbl, 0, 0);
        inputFieldsPane.add(cityCodeField, 1, 0);
        inputFieldsPane.add(cityNameLbl, 0, 1);
        inputFieldsPane.add(cityNameField, 1, 1);
        inputFieldsPane.add(searchLbl, 0, 2);
        inputFieldsPane.add(searchField, 1, 2);
        
        cityCodeField.setEditable(false);

        
        //Rythmizw to Horizontal kai Vartical gap se 10 pixels
        rootGridPane.setVgap(10);
        rootGridPane.setHgap(10);
        
        //Vazw ta components sto flowPane
        rootGridPane.add(inputFieldsPane, 1, 0);
        rootGridPane.add(cityTableView, 0, 0);
        rootGridPane.add(buttonFlowPane, 0, 2);
        rootGridPane.add(backBtn, 1, 2);

        //Dhmiourgw TableColumns pou antistoixoun stis sthles tou pinaka
	    //An TableColumn<a,b> , tote to a einai o tupos dedomenwn pou tha dexetai o pinakas kai b o tupos dedomenwn pou tha deixnei ston xrhsth
	    //Se kathe Column rythmizoume poio property tou tupou dedomenou tha antistoixei sth medthodo setCellValueFactory(new PropertyValueFactory<>(“x”));
	    //Eisagwgh Column sto TableView me th methodo getColumns().add(column)
        
        TableColumn<City, String> cityCodeColumn = new TableColumn<>("City Code");
        cityCodeColumn.setCellValueFactory(new PropertyValueFactory<>("cityCode"));
        cityTableView.getColumns().add(cityCodeColumn);

        TableColumn<City, String> cityNameColumn = new TableColumn<>("City Name");
        cityNameColumn.setCellValueFactory(new PropertyValueFactory<>("cityName"));
        cityTableView.getColumns().add(cityNameColumn);

    }

    @Override
    public Scene createScene() {
        return new Scene(rootGridPane, width, height);
    }

    
    @Override
    public void handle(MouseEvent event) {
    	
    	//Phgainei pisw sthn mainScene kai setarei ton titlo tou stage ston titlo ths mainScene
        if (event.getSource() == backBtn) {
            CarRentMainFX.mainStage.setTitle("Car Rental Service");
            CarRentMainFX.mainStage.setScene(CarRentMainFX.mainScene);
        }
        
        //Dhmiourgei neo antikeimeno mesw ths methodou createCity
        if (event.getSource() == newCityBtn) {
            
        	 String  cityName = cityNameField.getText();
        	 if (cityNameField.getText() != null && !cityNameField.getText().trim().isEmpty()) {
                 createCity(cityName);
                 //H tableSync sugxronizei ta stoixeia tou tableView me ta stoixeia ths listas
                 tableSync();
                 //Adeiazei thn lista pou exei o pinakas 
                 clearTextFields();
              }   
        }

        
        //Ôropopoiei ena antikeimeno mesw ths methodou editCity
        if (event.getSource() == editCityBtn) {
        	
        	String cityCode = cityCodeField.getText();
            String cityName = cityNameField.getText();

            editCity(cityCode, cityName);

            tableSync();
            clearTextFields();
        }
        
        
        //Diagrafei ena antikeimeno mesw ths methodou deleteCity
        if (event.getSource() == deleteCityBtn) {
            deleteCity(cityNameField.getText());

            tableSync();
            clearTextFields();
        }
        
        
        //Kanei anazhthsh mias polhs
        if (event.getSource() == searchField) {  		
    		String search = searchField.getText();
    		System.out.println(search);
    	}
        
        
        //Provalei ola ta antikeimena tupou City
        if (event.getSource() == cityTableView) {
            City selectedCity =cityTableView.getSelectionModel().getSelectedItem();
            if (selectedCity != null) {
                cityNameField.setText(selectedCity.getCityName());
                cityCodeField.setText(String.valueOf(selectedCity.getCityCode()));
            }
        
        }
    }
    
    //OI METHODOI
    
    public void tableSync() {
        List<City> items = cityTableView.getItems();
        items.clear();
        for (City c : cityList) {
            if (c instanceof City) {
                items.add((City) c);
            }
        }
    }
    
    
    public void clearTextFields() {
        cityNameField.setText("");
        cityCodeField.setText("");
   
    }

    
    public void createCity(String cityName) {
        City c = new City(cityName);
        cityList.add(c);
    }

 
    public void editCity(String cityCode, String cityName) {
    	
        for ( City c : cityList) {
        	
        	if (String.valueOf(c.getCityCode()).equals(cityCode)) {
        		
                c.setCityName(cityName);
                break;
             }
        }
    	
    }
    

    public void deleteCity(String cityName) {
        for (int i = 0; i < cityList.size(); i++) {
            
    		if (cityList.get(i).getCityName().equals(cityName)) {
                cityList.remove(i);
                break;
            }
        }
    }
    
    
    public void tableSyncSearch() {
        List<City> items = cityTableView.getItems();
        items.clear();
        for (City c : cityListSearch) {
            if (c instanceof City) {
                items.add((City) c);
            }
        }
    }

    
}