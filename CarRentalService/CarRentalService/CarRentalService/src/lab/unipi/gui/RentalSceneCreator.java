package lab.unipi.gui;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import lab.unipi.core.Rental;

import java.util.ArrayList;
import java.util.List;

public class RentalSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {
	
    //List of Rentals
	ArrayList<Rental> rentalList;
	
    //Flow Pane
    FlowPane buttonFlowPane;
    
    //Grid Panes
    GridPane rootGridPane, inputFieldsPane;
    
    //Rental Scene buttons
    Button newRentalBtn, cancelRentalBtn, backBtn;
    
    //Rental Scene Labels
    Label rentalCodeLbl, rentedVehicleLbl, rentingClientLbl, rentingStoreLbl, pickUpDateLbl, pickUpHourLbl, returningStoreLbl, returnDateLbl, returnHourLbl, totalCostLbl;
    
    //Rental Scene TextFields
    TextField rentalCodeField, rentedVehicleField, rentingClientField, rentingStoreField, pickUpDateField, pickUpHourField, returningStoreField, returnDateField, returnHourField, totalCostField ;
    
    //TableView
    TableView<Rental> rentalTableView;

    
    public RentalSceneCreator(double width, double height) {
    	
        super(width, height);
        
        //Arxikopoihsh twn fields
        rentalList = new ArrayList<>();
        
        rootGridPane = new GridPane();
        buttonFlowPane = new FlowPane();
        
        rentalCodeLbl = new Label("Rental Code: ");
        rentedVehicleLbl = new Label("Vehicle: ");
        rentingClientLbl = new Label("Client: ");
        rentingStoreLbl = new Label("Renting Store: ");
        pickUpDateLbl = new Label("Pick Up Date: ");
        pickUpHourLbl = new Label("Pick Up Hour: ");
        returningStoreLbl = new Label("Returning Store: ");
        returnDateLbl = new Label("Return Date: ");
        returnHourLbl = new Label("Return Hour: ");
        totalCostLbl = new Label("Total Cost: ");
        
       rentalCodeField = new TextField();
       rentedVehicleField = new TextField();
       rentingClientField = new TextField();
       rentingStoreField = new TextField();
       pickUpDateField = new TextField();
       pickUpHourField = new TextField();
       returningStoreField = new TextField();
       returnDateField = new TextField();
       returnHourField = new TextField();
       totalCostField = new TextField();

        newRentalBtn = new Button("New Rental");
        cancelRentalBtn = new Button("Cancel Rental");
        backBtn = new Button("Go Back");
        
        inputFieldsPane = new GridPane();
        rentalTableView = new TableView<>();

        
        //"Denw" ton EventHandler me to component apo to opoio kaleitai h  handle method kathe fora pou klikaroume
        backBtn.setOnMouseClicked(this);
        newRentalBtn.setOnMouseClicked(this);
        cancelRentalBtn.setOnMouseClicked(this);
        rentalTableView.setOnMouseClicked(this);

        
        //Rythmizw to Horizontal Gap (keno 10 pixels anamesa sta koumpakia)
        buttonFlowPane.setHgap(10);
        
        //Vazw ta koumpakia sto flowPane
        buttonFlowPane.getChildren().add(newRentalBtn);
        buttonFlowPane.getChildren().add(cancelRentalBtn);
        
        //Stoixizw sto katw meros kai kentro
        buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
    

    	//Stoixizw sto panw meros kai aristera
    	inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
    	
    	//Rythmizw to Horizontal kai Vertical Gap se 10 pixels 
    	inputFieldsPane.setVgap(10);
    	inputFieldsPane.setHgap(10);
    	
    	//Vazw ta components sto flowPane (prwta sthlh, meta grammh)
        inputFieldsPane.add(rentalCodeLbl, 0, 0);
    	inputFieldsPane.add(rentalCodeField, 1, 0);
    	inputFieldsPane.add(rentedVehicleLbl, 0, 1);
    	inputFieldsPane.add(rentedVehicleField, 1, 1);
    	inputFieldsPane.add(rentingClientLbl, 0, 2);
    	inputFieldsPane.add(rentingClientField, 1, 2);
    	inputFieldsPane.add(rentingStoreLbl, 0, 3);
    	inputFieldsPane.add(rentingStoreField, 1, 3);
    	inputFieldsPane.add(pickUpDateLbl, 0, 4);
    	inputFieldsPane.add(pickUpDateField, 1, 4);
    	inputFieldsPane.add(pickUpHourLbl, 0, 5);
    	inputFieldsPane.add(pickUpHourField, 1, 5);
    	inputFieldsPane.add(returningStoreLbl, 0, 6);
    	inputFieldsPane.add(returningStoreField, 1, 6);
    	inputFieldsPane.add(returnDateLbl, 0, 7);
    	inputFieldsPane.add(returnDateField, 1, 7);
    	inputFieldsPane.add(returnHourLbl, 0, 8);
    	inputFieldsPane.add(returnHourField, 1, 8);
    	inputFieldsPane.add(totalCostLbl, 0, 9);
    	inputFieldsPane.add(totalCostField, 1, 9);
    	
    	rentalCodeField.setEditable(false);
    	

    	//Rythmizw to Horizontal kai Vartical gap se 30 pixels
	    rootGridPane.setVgap(10);
	    rootGridPane.setHgap(10);
	    
	    //Vazw ta components sto flowPane
	    rootGridPane.add(inputFieldsPane, 1, 0);
	    rootGridPane.add(rentalTableView, 0, 0);
	    rootGridPane.add(buttonFlowPane, 0, 2);
	    rootGridPane.add(backBtn, 1, 2);

	    //Dhmiourgw TableColumns pou antistoixoun stis sthles tou pinaka
	    //An TableColumn<a,b> , tote to a einai o tupos dedomenwn pou tha dexetai o pinakas kai b o tupos dedomenwn pou tha deixnei ston xrhsth
	    //Se kathe Column rythmizoume poio property tou tupou dedomenou tha antistoixei sth medthodo setCellValueFactory(new PropertyValueFactory<>(“x”));
	    //Eisagwgh Column sto TableView me th methodo getColumns().add(column)
	    
	    TableColumn<Rental, String> rentalCodeColumn = new TableColumn<>("Rental Code");
	    rentalCodeColumn.setCellValueFactory(new PropertyValueFactory<>("rentalCode"));
	    rentalTableView.getColumns().add(rentalCodeColumn);
	
	    TableColumn<Rental, String> rentedVehicleColumn = new TableColumn<>("Vehicle");
	    rentedVehicleColumn.setCellValueFactory(new PropertyValueFactory<>("rentedVehicle"));
	    rentalTableView.getColumns().add(rentedVehicleColumn);
	    
	    TableColumn<Rental, String> rentingClientColumn = new TableColumn<>("Client");
	    rentingClientColumn.setCellValueFactory(new PropertyValueFactory<>("rentingClient"));
	    rentalTableView.getColumns().add(rentingClientColumn);
	    
	    TableColumn<Rental, String> rentingStoreColumn = new TableColumn<>("Renting Store");
	    rentingStoreColumn.setCellValueFactory(new PropertyValueFactory<>("rentingStore"));
	    rentalTableView.getColumns().add(rentingStoreColumn);
	    
	    TableColumn<Rental, String> pickUpDateColumn = new TableColumn<>("Pick Up Date");
	    pickUpDateColumn.setCellValueFactory(new PropertyValueFactory<>("pickUpDate"));
	    rentalTableView.getColumns().add(pickUpDateColumn);
	    
	    TableColumn<Rental, String> pickUpHourColumn = new TableColumn<>("Pick Up Hour");
	    pickUpHourColumn.setCellValueFactory(new PropertyValueFactory<>("pickUpHour"));
	    rentalTableView.getColumns().add(pickUpHourColumn);
	    
	    TableColumn<Rental, String> returningStoreColumn = new TableColumn<>("Returning Store");
	    returningStoreColumn.setCellValueFactory(new PropertyValueFactory<>("returningStore"));
	    rentalTableView.getColumns().add(returningStoreColumn);
	    
	    TableColumn<Rental, String> returnDateColumn = new TableColumn<>("Return Date");
	    returnDateColumn.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
	    rentalTableView.getColumns().add(returnDateColumn);
	    
	    TableColumn<Rental, String> returnHourColumn = new TableColumn<>("Return Hour");
	    returnHourColumn.setCellValueFactory(new PropertyValueFactory<>("returnHour"));
	    rentalTableView.getColumns().add(returnHourColumn);
	    
	    TableColumn<Rental, String> totalCostColumn = new TableColumn<>("Total Cost");
	    totalCostColumn.setCellValueFactory(new PropertyValueFactory<>("totalCost"));
	    rentalTableView.getColumns().add(totalCostColumn);
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
		    
		    //Dhmiourgei neo antikeimeno mesw ths methodou createRental
		    if (event.getSource() == newRentalBtn) {
		        
		        String rentedVehicle = rentedVehicleField.getText();
		        String rentingClient = rentingClientField.getText();
		        String rentingStore = rentingStoreField.getText();
		        String pickUpDate = pickUpDateField.getText();
		        String pickUpHour = pickUpHourField.getText();
		        String returningStore = returningStoreField.getText();
		        String returnDate = returnDateField.getText();
		        String returnHour = returnHourField.getText();
		        int totalCost = Integer.parseInt(totalCostField.getText());
		        
	     
		        createRental(rentedVehicle, rentingClient, rentingStore, pickUpDate, pickUpHour, returningStore, returnDate, returnHour, totalCost);
		
		        //H tableSync sugxronizei ta stoixeia tou tableView me ta stoixeia ths listas
		        tableSync();
		        //Adeiazei thn lista pou exei o pinakas 
		        clearTextFields();
		    }
		
		    
		    //Diagrafei ena antikeimeno mesw ths methodou deleteRental
		    if (event.getSource() == cancelRentalBtn) {
		    	
		        deleteRental(rentalCodeField.getText());
		
		        tableSync();
		        clearTextFields();
		    }
		    
		    
		  //Provalei ola ta antikeimena tupou Rental
		    if (event.getSource() == rentalTableView) {
		        Rental selectedRental = rentalTableView.getSelectionModel().getSelectedItem();
		        if (selectedRental != null) {
		            rentedVehicleField.setText(selectedRental.getRentedVehicle());
		            rentingClientField.setText(selectedRental.getRentingClient());
		            rentingStoreField.setText(selectedRental.getRentingStore());
		            pickUpDateField.setText(selectedRental.getPickUpDate());
		            pickUpHourField.setText(selectedRental.getPickUpHour());
		            returningStoreField.setText(selectedRental.getReturningStore());
		            returnDateField.setText(selectedRental.getReturnDate());
		            returnHourField.setText(selectedRental.getReturnHour());
	                totalCostField.setText(Integer.toString(selectedRental.getTotalCost()));
		
		        }
		    }
		}
		
		
		
		//OI METHODOI
		
		
		public void tableSync() {
		    List<Rental> items = rentalTableView.getItems();
		    items.clear();
		    for (Rental r : rentalList) {
		        if (r instanceof Rental) {
		            items.add((Rental) r);
		        }
		    }
		}
		
		public void clearTextFields() {
		    rentedVehicleField.setText(" ");
		    rentingClientField.setText(" ");
		    rentingStoreField.setText(" " );
		    pickUpDateField.setText(" " );
		    pickUpHourField.setText(" ");
		    returningStoreField.setText(" ");
		    returnDateField.setText(" ");
		    returnHourField.setText(" ");
		    totalCostField.setText(" ");
		}

		public void createRental(String rentedVehicle, String rentingClient, String rentingStore, String pickUpDate,String pickUpHour, String returningStore, String returnDate, String returnHour, int totalCost) {
		    Rental r = new Rental(rentedVehicle, rentingClient, rentingStore, pickUpDate, pickUpHour, returningStore, returnDate, returnHour, totalCost);
		    rentalList.add(r);
		}

		public void deleteRental(String rentedVehicle) {
		    for (int i = 0; i < rentalList.size(); i++) {
		        
				if (rentalList.get(i).getRentedVehicle().equals(rentedVehicle)) {
		            rentalList.remove(i);
		            break;
		        }
		    }
		}
		
}
 