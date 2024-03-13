package lab.unipi.gui;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import lab.unipi.core.Vehicle;
import java.util.ArrayList;
import java.util.List;

import lab.unipi.core.Car;
import lab.unipi.core.TwoWheeled;

public class VehicleSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {
	
	Alert alert = new Alert(AlertType.INFORMATION);
	
    //List of Vehicle
    ArrayList<Vehicle> vehicleList;
    
    Car car1 = new Car(5, 4, "YMI34090", "Hyundai i20", "Gas", "Medium", "1248", 50);
    TwoWheeled two1 = new TwoWheeled(0.5, "Large", "YMH390", "Harley iron883", "Gas", "Big", "2185", 80);
    
    //Flow Pane
    FlowPane buttonFlowPane;
    
    //Grid Panes
    GridPane rootGridPane, inputFieldsPane;
    
    //Vehicle Scene buttons
    Button newVehicleBtn, editVehicleBtn, deleteVehicleBtn, backBtn;
    
    //Vehicle Scene Labels
    Label seatsNumberLbl, doorsNumberLbl, seatHeightLbl, baggageSystemLbl, licensePlateLbl,modelLbl,gasOrPetrolLbl, typeLbl, volumeLbl, rentalPerDayLbl;
    
    //Vehicle Scene TextFields
    TextField seatsNumberField, doorsNumberField, seatHeightField, baggageSystemField, licensePlateField, modelField, gasOrPetrolField, typeField, volumeField, rentalPerDayField;
    
    //TableView
    TableView<Vehicle> vehicleTableView;

    RadioButton rb1 = new RadioButton("Car");
    RadioButton rb2 = new RadioButton("Twowheeled");
    
    
    public VehicleSceneCreator(double width, double height) {
    	
        super(width, height);
        
        //Arxikopoihsh twn fields
        vehicleList = new ArrayList<>();
        
        vehicleList.add(car1);
        vehicleList.add(two1);
        
        rootGridPane = new GridPane();
        buttonFlowPane = new FlowPane();
        
        licensePlateLbl = new Label("License Plate ");
        modelLbl = new Label("Model ");
        gasOrPetrolLbl = new Label("Fuel ");
        typeLbl = new Label("Type ");
        volumeLbl = new Label("Volume ");
        rentalPerDayLbl = new Label("Rental Per Day ");
        
        seatsNumberLbl = new Label("Seats Number ");
        doorsNumberLbl = new Label("Doors Number ");
        seatHeightLbl = new Label("Seat Height ");
        baggageSystemLbl = new Label("Baggage System ");
        
        
        licensePlateField = new TextField();
        modelField = new TextField();
        gasOrPetrolField = new TextField();
        typeField = new TextField();
        volumeField = new TextField();
        rentalPerDayField = new TextField();
       
       
        newVehicleBtn = new Button("New Vehicle");
        editVehicleBtn = new Button("Update");
        deleteVehicleBtn = new Button("Delete Vehicle");
        backBtn = new Button("Go Back");
        
        seatsNumberField = new TextField();
        doorsNumberField = new TextField();
        seatHeightField = new TextField();
        baggageSystemField = new TextField();
        
        inputFieldsPane = new GridPane();
        vehicleTableView = new TableView<>();

        
        //"Denw" ton EventHandler me to component apo to opoio kaleitai h  handle method kathe fora pou klikaroume
        backBtn.setOnMouseClicked(this);
        newVehicleBtn.setOnMouseClicked(this);
        editVehicleBtn.setOnMouseClicked(this);
        deleteVehicleBtn.setOnMouseClicked(this);
        vehicleTableView.setOnMouseClicked(this);
        
        rb1.setOnMouseClicked(this);
        rb2.setOnMouseClicked(this);

        
        //Rythmizw to Horizontal Gap (keno 10 pixels anamesa sta koumpakia) 
        buttonFlowPane.setHgap(10);
        
        //Vazw ta koumpakia sto flowPane
        buttonFlowPane.getChildren().add(rb1);
        buttonFlowPane.getChildren().add(rb2);
        buttonFlowPane.getChildren().add(newVehicleBtn);
        buttonFlowPane.getChildren().add(editVehicleBtn);
        buttonFlowPane.getChildren().add(deleteVehicleBtn);
        
        //Stoixizw sto katw meros kai kentro
        buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
    

        //Stoixizw sto panw meros kai aristera
    	inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
    	
    	//Rythmizw to Horizontal kai Vertical Gap se 10 pixels 
    	inputFieldsPane.setVgap(10);
    	inputFieldsPane.setHgap(10);
    	
    	//Vazw ta components sto flowPane (prwta sthlh, meta grammh)
        inputFieldsPane.add(licensePlateLbl, 0, 2);
    	inputFieldsPane.add(licensePlateField, 1, 2);
    	inputFieldsPane.add(modelLbl, 0, 3);
    	inputFieldsPane.add(modelField, 1, 3);
    	inputFieldsPane.add(gasOrPetrolLbl, 0, 4);
    	inputFieldsPane.add(gasOrPetrolField, 1, 4);
    	inputFieldsPane.add(typeLbl, 0, 5);
    	inputFieldsPane.add(typeField, 1, 5);
    	inputFieldsPane.add(volumeLbl, 0, 6);
    	inputFieldsPane.add(volumeField, 1, 6);
    	inputFieldsPane.add(rentalPerDayLbl, 0, 7);
    	inputFieldsPane.add(rentalPerDayField, 1, 7);
    	
    	TableColumn<Vehicle, String> seatsNumberColumn = new TableColumn<>("Seats Number");
        seatsNumberColumn.setCellValueFactory(new PropertyValueFactory<>("seatsNumber"));
        
        TableColumn<Vehicle, String> doorsNumberColumn = new TableColumn<>("Doors Number");
        doorsNumberColumn.setCellValueFactory(new PropertyValueFactory<>("doorsNumber"));
        
        TableColumn<Vehicle, String> seatHeightColumn = new TableColumn<>("Seat Height");
        seatHeightColumn.setCellValueFactory(new PropertyValueFactory<>("seatHeight"));
        
        
        TableColumn<Vehicle, String> baggageSystemColumn = new TableColumn<>("Baggage System");
        baggageSystemColumn.setCellValueFactory(new PropertyValueFactory<>("baggageSystem"));
        
        
        vehicleTableView.getColumns().add(seatsNumberColumn);
        vehicleTableView.getColumns().add(doorsNumberColumn);
        vehicleTableView.getColumns().add(seatHeightColumn);
        vehicleTableView.getColumns().add(baggageSystemColumn);
        
        ToggleGroup radioGroup = new ToggleGroup(); 
        
        rb1.setToggleGroup(radioGroup); 
        rb2.setToggleGroup(radioGroup); 
        
        rb1.selectedProperty().addListener(new InvalidationListener() {
            public void invalidated(Observable ov) {
                if (rb1.isSelected()) {
                	inputFieldsPane.getChildren().remove(seatHeightLbl);
                	inputFieldsPane.getChildren().remove(seatHeightField);
                	inputFieldsPane.getChildren().remove(baggageSystemLbl);
                	inputFieldsPane.getChildren().remove(baggageSystemField);
                	inputFieldsPane.add(seatsNumberLbl, 0, 0);
        	        inputFieldsPane.add(seatsNumberField, 1, 0);
        	        inputFieldsPane.add(doorsNumberLbl, 0, 1);
        	        inputFieldsPane.add(doorsNumberField, 1, 1);
        	        
        	        vehicleTableView.getColumns().remove(seatHeightColumn);
        	        vehicleTableView.getColumns().remove(baggageSystemColumn);
        	        vehicleTableView.getColumns().remove(seatsNumberColumn);
        	        vehicleTableView.getColumns().remove(doorsNumberColumn);
        	        vehicleTableView.getColumns().add(seatsNumberColumn);
        	        vehicleTableView.getColumns().add(doorsNumberColumn);
        	        clearTextFields();
        	        tableSync();
                }
            }
        });
        
        rb2.selectedProperty().addListener(new InvalidationListener() {
            public void invalidated(Observable ov) {
                if (rb2.isSelected()) {
                	inputFieldsPane.getChildren().remove(seatsNumberLbl);
                	inputFieldsPane.getChildren().remove(seatsNumberField);
                	inputFieldsPane.getChildren().remove(doorsNumberLbl);
                	inputFieldsPane.getChildren().remove(doorsNumberField);
                	inputFieldsPane.add(seatHeightLbl, 0, 0);
        	        inputFieldsPane.add(seatHeightField, 1, 0);
        	        inputFieldsPane.add(baggageSystemLbl, 0, 1);
        	        inputFieldsPane.add(baggageSystemField, 1, 1);
        	        
        
        	        vehicleTableView.getColumns().remove(seatHeightColumn);
        	        vehicleTableView.getColumns().remove(baggageSystemColumn);
        	        vehicleTableView.getColumns().remove(seatsNumberColumn);
        	        vehicleTableView.getColumns().remove(doorsNumberColumn);
        	        vehicleTableView.getColumns().add(seatHeightColumn);
        	        vehicleTableView.getColumns().add(baggageSystemColumn);
        	        clearTextFields();
        	        tableSync();
                }
            }
        });
        rb1.setSelected(true);

        
    	//Rythmizw to Horizontal kai Vartical gap se 30 kai 100  pixels
	    rootGridPane.setVgap(30);
	    rootGridPane.setHgap(10);
	    
	    //Vazw ta components sto flowPane
	    rootGridPane.add(inputFieldsPane, 1, 0);
	    rootGridPane.add(vehicleTableView, 0, 0);
	    rootGridPane.add(buttonFlowPane, 0, 2);
	    rootGridPane.add(backBtn, 1, 2);
	    
	    
	    //Dhmiourgw TableColumns pou antistoixoun stis sthles tou pinaka
	    //An TableColumn<a,b> , tote to a einai o tupos dedomenwn pou tha dexetai o pinakas kai b o tupos dedomenwn pou tha deixnei ston xrhsth
	    //Se kathe Column rythmizoume poio property tou tupou dedomenou tha antistoixei sth medthodo setCellValueFactory(new PropertyValueFactory<>(“x”));
	    //Eisagwgh Column sto TableView me th methodo getColumns().add(column)
      
	    TableColumn<Vehicle, String> licensePlateColumn = new TableColumn<>("License Plate");
	    licensePlateColumn.setCellValueFactory(new PropertyValueFactory<>("licensePlate"));
	    vehicleTableView.getColumns().add(licensePlateColumn);
	
	    TableColumn<Vehicle, String> modelColumn = new TableColumn<>("Model");
	    modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
	    vehicleTableView.getColumns().add(modelColumn);
	    
	    TableColumn<Vehicle, String> gasOrPetrolColumn = new TableColumn<>("Fuel");
	    gasOrPetrolColumn.setCellValueFactory(new PropertyValueFactory<>("gasOrPetrol"));
	    vehicleTableView.getColumns().add(gasOrPetrolColumn);
	    
	    TableColumn<Vehicle, String> typeColumn = new TableColumn<>("Type");
	    typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
	    vehicleTableView.getColumns().add(typeColumn);
	    
	    TableColumn<Vehicle, String> volumeColumn = new TableColumn<>("Volume");
	    volumeColumn.setCellValueFactory(new PropertyValueFactory<>("volume"));
	    vehicleTableView.getColumns().add(volumeColumn);
	    
	    TableColumn<Vehicle, String> rentalPerDayColumn = new TableColumn<>("Rental Per Day");
	    rentalPerDayColumn.setCellValueFactory(new PropertyValueFactory<>("rentalPerDay"));
	    vehicleTableView.getColumns().add(rentalPerDayColumn);
	    
	    
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
		    
		    //Dhmiourgei neo antikeimeno mesw ths methodou createVehicle
		    if (event.getSource() == newVehicleBtn) {
		        
		    	double seatHeight;
	        	String baggageSystem;
	        	int doorsNumber;
	        	int seatsNumber;
	        	if (rb1.isSelected()) {
	        		seatHeight = 0;
	        		baggageSystem = "-";
	        		doorsNumber = Integer.parseInt(doorsNumberField.getText());
	        		seatsNumber = Integer.parseInt(seatsNumberField.getText());
	        	} else  {
	        		doorsNumber = 0;
	        		seatsNumber = 0;
	        		seatHeight = Double.valueOf(seatHeightField.getText());
	        		baggageSystem = baggageSystemField.getText();
	        	}
	            String licensePlate = licensePlateField.getText();
	            String model = modelField.getText();
	            String gasOrPetrol = gasOrPetrolField.getText();
	            String type = typeField.getText();
	            String volume = volumeField.getText();
	            double rentalPerDay = Double.parseDouble(rentalPerDayField.getText());
	           
	            if (licensePlateField.getText() != null && !licensePlateField.getText().trim().isEmpty()) {
	            	if (rb1.isSelected()) {
	            		if (createCar(seatsNumber, doorsNumber, licensePlate, model, gasOrPetrol, type, volume ,rentalPerDay)) {
	            			tableSync();
	        	            clearTextFields();
	            		}
	            		
	            	} else {
	            		if (createTwoWheeled(seatHeight, baggageSystem, licensePlate, model, gasOrPetrol, type, volume ,rentalPerDay)) {
	            			tableSync();
	        	            clearTextFields();
	            		}
	            	}
		    }
		    }
		    
		    
		    //Ôropopoiei ena antikeimeno mesw ths methodou editVehicle
		    if (event.getSource() == editVehicleBtn) {
		    	
		        String licensePlate = licensePlateField.getText();
		        String model = modelField.getText();
		        String gasOrPetrol = gasOrPetrolField.getText();
		        String type = typeField.getText();
		        String volume = volumeField.getText();
		        double rentalPerDay = Double.parseDouble(rentalPerDayField.getText());
		        
		        double seatHeight = Double.valueOf(seatHeightField.getText());
		        String baggageSystem = baggageSystemField.getText();
		        int doorsNumber = Integer.valueOf(doorsNumberField.getText());
		        int seatsNumber = Integer.valueOf(seatsNumberField.getText());
		
		        if (rb1.isSelected()) {
		        	 editCar(seatsNumber, doorsNumber, licensePlate, model, gasOrPetrol, type, volume, rentalPerDay);
		        }
		        if (rb2.isSelected()) {
		        	 editTwoWheeled(seatHeight, baggageSystem, licensePlate, model, gasOrPetrol, type, volume, rentalPerDay);
		        }
		        
		        tableSync();
		        clearTextFields();
		    }
		    
		    //Diagrafei ena antikeimeno mesw ths methodou deleteVehicle
		    if (event.getSource() == deleteVehicleBtn) {
		    	
		        deleteVehicle(licensePlateField.getText());
		
		        tableSync();
		        clearTextFields();
		    }
		    
		    
		    //Provalei ola ta antikeimena tupou Vehicle
		    if (event.getSource() == vehicleTableView) {
		        Vehicle selectedVehicle = vehicleTableView.getSelectionModel().getSelectedItem();
		        if (selectedVehicle != null) {
		        	licensePlateField.setText(selectedVehicle.getLicensePlate());
		            modelField.setText(selectedVehicle.getModel());
		            gasOrPetrolField.setText(selectedVehicle.getGasOrPetrol());
		            typeField.setText(selectedVehicle.getType());
		            volumeField.setText(selectedVehicle.getVolume());
		            rentalPerDayField.setText(Double.toString(selectedVehicle.getRentalPerDay()));
		            seatsNumberField.setText(Integer.toString(selectedVehicle.getSeatsNumber()));
	                doorsNumberField.setText(Integer.toString(selectedVehicle.getDoorsNumber()));
	                baggageSystemField.setText(selectedVehicle.getBaggageSystem());
	                seatHeightField.setText(Double.toString(selectedVehicle.getSeatHeight()));
		        }
		    }
		}
		
		
		//OI METHODOI
		
		public void tableSync() {
		    List<Vehicle> items = vehicleTableView.getItems();
		    items.clear();
		    if (rb1.isSelected()) {
	        	for (Vehicle v : vehicleList) {
		            if (v instanceof Car) {
		                items.add((Vehicle) v);
		            }
		        }
	        } else {
	        	for (Vehicle v : vehicleList) {
		            if (v instanceof TwoWheeled) {
		                items.add((Vehicle) v);
		            }
		        }
	        }
		}
		

		public void clearTextFields() {
		    licensePlateField.setText(" ");
		    modelField.setText(" ");
		    gasOrPetrolField.setText(" ");
		    typeField.setText(" " );
		    volumeField.setText(" " );
		    rentalPerDayField.setText(" ");
		    seatsNumberField.setText(" ");
	        doorsNumberField.setText(" ");
	        seatHeightField.setText(" ");
	        baggageSystemField.setText(" ");
		}
		
		public boolean createCar(int seatsNumber, int doorsNumber, String licensePlate, String model, String gasOrPetrol, String type, String volume, double rentalPerDay) {
	        Car c = new Car(seatsNumber, doorsNumber, licensePlate, model, gasOrPetrol, type, volume, rentalPerDay);
	        for (Vehicle v : vehicleList) {
	        	if (v.licensePlate.equals(licensePlate)){
	        		alert.setTitle("License Plate Field Error");
    	        	alert.setHeaderText(null);
    	        	alert.setContentText("License Plate already exists");
    	        	alert.showAndWait();
	        		return false;
	        	}
	        }
	        vehicleList.add(c);
	        return true;
	        
	        
		}
		
		public boolean createTwoWheeled(double seatHeight, String baggageSystem, String licensePlate,String model,  String gasOrPetrol, String type, String volume, double rentalPerDay) {
			TwoWheeled t = new TwoWheeled(seatHeight, baggageSystem, licensePlate, model, gasOrPetrol, type, volume, rentalPerDay);

	        for (Vehicle v : vehicleList) {
	        	if (v.licensePlate.equals(licensePlate)){
	        		alert.setTitle("License Plate Field Error");
    	        	alert.setHeaderText(null);
    	        	alert.setContentText("License Plate already exist.");
    	        	alert.showAndWait();
	        		return false;
	        	}
	        }
	        vehicleList.add(t);
	        return true;

	    }
		
		
		public void editCar(int seatsNumber,int doorsNumber, String licensePlate, String model, String gasOrPetrol, String type, String volume, double rentalPerDay) {
		    for (Vehicle v : vehicleList) {
		        if ((v.getLicensePlate()).equals(licensePlate)) {
		        	v.setSeatsNumber(seatsNumber);
	            	v.setDoorsNumber(doorsNumber);
		            v.setModel(model);
		            v.setGasOrPetrol(gasOrPetrol);
		            v.setType(type);
		            v.setVolume(volume);
		            v.setRentalPerDay(rentalPerDay);
		        }
		    }
		}
		
		 public void editTwoWheeled(double seatHeight,String baggageSystem, String licencePlate, String model, String gasOrPetrol, String type, String volume,double rentalPerDay ) {
		        for (Vehicle v : vehicleList) {
		            if ((v.getLicensePlate()).equals(licencePlate)) {
		            	v.setBaggageSystem(baggageSystem);
		            	v.setSeatHeight(seatHeight);
		                v.setModel(model);
		                v.setGasOrPetrol(gasOrPetrol);
		                v.setType(type);
		                v.setVolume(volume);
		                v.setRentalPerDay(rentalPerDay);
		                
		            }
		        }
		    }
		
		public void deleteVehicle(String licensePlate) {
		    for (int i = 0; i < vehicleList.size(); i++) {
		        
				if (vehicleList.get(i).getLicensePlate().equals(licensePlate)) {
		            vehicleList.remove(i);
		            break;
		        }
		    }
		}
		
		
}