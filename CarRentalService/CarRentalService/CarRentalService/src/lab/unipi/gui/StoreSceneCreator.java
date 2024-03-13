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
import lab.unipi.core.Store;


import java.util.ArrayList;
import java.util.List;

public class StoreSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {
	
	
    //List of Stores
    ArrayList<Store> storeList;
    ArrayList<Store> storeListSearch;
    
    //Flow Pane
    FlowPane buttonFlowPane;
    
    //Grid Panes
    GridPane rootGridPane, inputFieldsPane;
    
    //Store Scene Buttons
    Button newStoreBtn, editStoreBtn, deleteStoreBtn, backBtn;
    
    //Store Scene Labels
    Label  storeCodeLbl, storeNameLbl, storeCityLbl, searchLbl;
    
    //Store Scene TextFields
    TextField  storeCodeField, storeNameField, storeCityField, searchField;
    
    //TableView
    TableView<Store> storeTableView;
    
    
    public StoreSceneCreator(double width, double height) {
    	
        super(width, height);
        
        //Arxikopoihshn twn fields
        storeList = new ArrayList<>();
        storeListSearch = new ArrayList<>();
        
        rootGridPane = new GridPane();
        buttonFlowPane = new FlowPane();
        
        storeCodeLbl = new Label("Store Code ");
        storeNameLbl = new Label("Store Name ");
        storeCityLbl = new Label("Store City ");
        searchLbl = new Label("SEARCH ");
        
        storeCodeField = new TextField();
        storeNameField = new TextField();
        storeCityField = new TextField();
        searchField = new TextField();
        
        newStoreBtn = new Button("New Store");
        editStoreBtn = new Button("Update");
        deleteStoreBtn = new Button("Delete Store");
        backBtn = new Button("Go Back");
        
        inputFieldsPane = new GridPane();
        storeTableView = new TableView<>();

        //Gray background gia to textfield
        storeCodeField.setStyle("-fx-background-color: gray;");
        //Prasino xrwma sto label ths anazhthshs
        searchLbl.setStyle("-fx-text-fill: green; -fx-font-size: 16px;");
        
        //"Denw" ton EventHandler me to component apo to opoio kaleitai h  handle method kathe fora pou klikaroume
        backBtn.setOnMouseClicked(this);
        newStoreBtn.setOnMouseClicked(this);
        editStoreBtn.setOnMouseClicked(this);
        deleteStoreBtn.setOnMouseClicked(this);
        storeTableView.setOnMouseClicked(this);

        
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
        	pause.setOnFinished(event -> {
        		storeListSearch.clear();
        		for (Store d: storeList) {
        			if (d.getStoreCity().toLowerCase().contains(newValue.toLowerCase())) {
        				storeListSearch.add(d);
        			}
        		}
        		tableSyncSearch();
        	});
            pause.playFromStart();
        	
        });
        
        
        
        //Rythmizw to Horizontal Gap (keno 10 pixels anamesa sta koumpakia) 
        buttonFlowPane.setHgap(10);
        
        //Vazw ta koumpakia sto flowPane
        buttonFlowPane.getChildren().add(newStoreBtn);
        buttonFlowPane.getChildren().add(editStoreBtn);
        buttonFlowPane.getChildren().add(deleteStoreBtn);
        
        //Stoixizw sto katw meros kai kentro
        buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
    

    	//Stoixizw sto panw meros kai aristera
    	inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
    	
    	//Rythmizw to Horizontal kai Vertical Gap se 10 pixels 
    	inputFieldsPane.setVgap(10);
    	inputFieldsPane.setHgap(10);
    	
    	//Vazw ta components sto flowPane (prwta sthlh, meta grammh)
    	inputFieldsPane.add(storeCodeLbl, 0, 0);
    	inputFieldsPane.add(storeCodeField, 1, 0);
        inputFieldsPane.add(storeNameLbl, 0, 1);
    	inputFieldsPane.add(storeNameField, 1, 1);
    	inputFieldsPane.add(storeCityLbl, 0, 2);
    	inputFieldsPane.add(storeCityField, 1, 2);
    	inputFieldsPane.add(searchLbl, 0, 3);
    	inputFieldsPane.add(searchField, 1, 3);
    	
        storeCodeField.setEditable(false);

    	
    	

    	//Rythmizw to Horizontal kai Vartical gap se 10 pixels
	    rootGridPane.setVgap(10);
	    rootGridPane.setHgap(10);
	    
	    //Vazw ta components sto flowPane
	    rootGridPane.add(inputFieldsPane, 1, 0);
	    rootGridPane.add(storeTableView, 0, 0);
	    rootGridPane.add(buttonFlowPane, 0, 2);
	    rootGridPane.add(backBtn, 1, 2);

	    
	    //Dhmiourgw TableColumns pou antistoixoun stis sthles tou pinaka
	    //An TableColumn<a,b> , tote to a einai o tupos dedomenwn pou tha dexetai o pinakas kai b o tupos dedomenwn pou tha deixnei ston xrhsth
	    //Se kathe Column rythmizoume poio property tou tupou dedomenou tha antistoixei sth medthodo setCellValueFactory(new PropertyValueFactory<>(“x”));
	    //Eisagwgh Column sto TableView me th methodo getColumns().add(column)
	    
	    TableColumn<Store, String> storeCodeColumn = new TableColumn<>("Store Code");
	    storeCodeColumn.setCellValueFactory(new PropertyValueFactory<>("storeCode"));
	    storeTableView.getColumns().add(storeCodeColumn);
	
	    TableColumn<Store, String> storeNameColumn = new TableColumn<>("Store Name");
	    storeNameColumn.setCellValueFactory(new PropertyValueFactory<>("storeName"));
	    storeTableView.getColumns().add(storeNameColumn);
	
	    TableColumn<Store, String> storeCityColumn = new TableColumn<>("City");
	    storeCityColumn.setCellValueFactory(new PropertyValueFactory<>("storeCity"));
	    storeTableView.getColumns().add(storeCityColumn);
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
		    
		    //Dhmiourgei neo antikeimeno mesw ths methodou createStore
		    if (event.getSource() == newStoreBtn) {
		    	
		        String  storeName = storeNameField.getText();
		        String storeCity = storeCityField.getText();
		       
		        if (storeNameField.getText() != null && !storeNameField.getText().trim().isEmpty()&&storeCityField.getText() != null && !storeCityField.getText().trim().isEmpty()) {
		        
		        createStore(storeName, storeCity);
		
		        //H tableSync sugxronizei ta stoixeia tou tableView me ta stoixeia ths listas 
		        tableSync();
		        //Adeiazei thn lista pou exei o pinakas 
		        clearTextFields();
		        }
		    }
		    
		    //Ôropopoiei ena antikeimeno mesw ths methodou editStore
		    if (event.getSource() == editStoreBtn) {
		    	
		    	String storeCode =  storeCodeField.getText();
		    	String storeName = storeNameField.getText();
		    	
		        editStore(storeCode, storeName);
		
		        tableSync();
		        clearTextFields();
		    }
		    
		    //Diagrafei ena antikeimeno mesw ths methodou deleteStore
		    if (event.getSource() == deleteStoreBtn) {
		        deleteStore(storeNameField.getText());
		
		        tableSync();
		        clearTextFields();
		    }
		    
		    
		    if (event.getSource() == searchField) {
	    		String search = searchField.getText();
	    		System.out.println(search);
	    	}
		    
		    //Provalei ola ta antikeimena tupou Store
		    if (event.getSource() == storeTableView) {
		        Store selectedStore = storeTableView.getSelectionModel().getSelectedItem();
		        if (selectedStore != null) {
		        	storeCodeField.setText(String.valueOf(selectedStore.getStoreCode()));
		            storeNameField.setText(selectedStore.getStoreName());
		            storeCityField.setText(selectedStore.getStoreCity());         
		        }
		    }
		}
		
		
		//OI METHODOI
		
		
		public void tableSync() {
		    List<Store> items = storeTableView.getItems();
		    items.clear();
		    for (Store d : storeList) {
		        if (d instanceof Store) {
		            items.add((Store) d);
		        }
		    }
		}
		
		public void clearTextFields() {
			storeCodeField.setText(" ");
		    storeNameField.setText("");
		    storeCityField.setText("");
		}
		
		public void createStore(String storeName ,  String storeCity) {
		    Store d = new Store(storeName, storeCity);
		    storeList.add(d);
		}
		
		
		
		public void editStore(String storeCode, String storeName) {
		    for (Store d : storeList) {
		    	if (String.valueOf(d.getStoreCode()).equals(storeCode)) {
	        		storeCityField.setEditable(false); 
	                d.setStoreName(storeName);
	                break;
	             }
		    }
	        storeCityField.setEditable(true);
		}
		
		public void deleteStore(String storeName) {
		    for (int i = 0; i < storeList.size(); i++) {
		        
				if (storeList.get(i).getStoreName().equals(storeName)) {
		            storeList.remove(i);
		            break;
		        }
		    }
		}
		
		
		public void tableSyncSearch() {
	        List<Store> items = storeTableView.getItems();
	        items.clear();
	        for (Store d : storeListSearch) {
	            if (d instanceof Store) {
	                items.add((Store) d);
	            }
	        }
	    }
}
 