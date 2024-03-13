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
import lab.unipi.core.Client;


import java.util.ArrayList;
import java.util.List;

public class ClientSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {
	
	
    //List of Clients
    ArrayList<Client> clientList;
    ArrayList<Client> clientListSearch;
    
    //Flow Pane
    FlowPane buttonFlowPane;
    
    //Grid Panes
    GridPane rootGridPane, inputFieldsPane;
    
    //Client Scene Buttons
    Button newClientBtn, editClientBtn, deleteClientBtn, backBtn;
    
    //Client Scene Labels
    Label IDnumberLbl,licenseNumberLbl,firstNameLbl, lastNameLbl, emailLbl, addressLbl, telephoneNumberLbl, searchLbl;
    
    //Client Scene TextFields
    TextField IDnumberField, licenseNumberField, firstNameField,lastNameField, emailField, addressField, telephoneNumberField, searchField;
    
    //TableView
    TableView<Client> clientTableView;

    
    public ClientSceneCreator(double width, double height) {
    	
        super(width, height);
        
        //Arxikopoihsh twn fields
        clientList = new ArrayList<>();
        clientListSearch = new ArrayList<>();
        
        rootGridPane = new GridPane();
        buttonFlowPane = new FlowPane();
        
        IDnumberLbl = new Label("ID Number ");
        licenseNumberLbl = new Label("License Number ");
        firstNameLbl = new Label("First Name ");
        lastNameLbl = new Label("Last Name ");
        emailLbl = new Label("Email ");
        addressLbl = new Label("Address ");
        telephoneNumberLbl = new Label("Telephone Number ");
        searchLbl = new Label("SEARCH ");
        
	    IDnumberField = new TextField();
	    licenseNumberField = new TextField();
	    firstNameField = new TextField();
	    lastNameField = new TextField();
	    emailField = new TextField();
	    addressField = new TextField();
	    telephoneNumberField = new TextField();
	    searchField = new TextField();


        newClientBtn = new Button("New Client");
        editClientBtn = new Button("Update");
        deleteClientBtn = new Button("Delete Client");
        backBtn = new Button("Go Back");
        
        inputFieldsPane = new GridPane();
        clientTableView = new TableView<>();

        //Prasino xrwma sto label ths anazhthshs
        searchLbl.setStyle("-fx-text-fill: green; -fx-font-size: 16px;");

        
        //"Denw" ton EventHandler me to component apo to opoio kaleitai h  handle method kathe fora pou klikaroume
        backBtn.setOnMouseClicked(this);
        newClientBtn.setOnMouseClicked(this);
        editClientBtn.setOnMouseClicked(this);
        deleteClientBtn.setOnMouseClicked(this);
        clientTableView.setOnMouseClicked(this);

        
        //ANAZHTHSH
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
        	pause.setOnFinished(event -> {
        		clientListSearch.clear();
        		for (Client client: clientList) {
        			if (client.getIDnumber().toLowerCase().contains(newValue.toLowerCase())) {
        				clientListSearch.add(client);
        			}
        		}
        		tableSyncSearch();
        	});
            pause.playFromStart();
        	
        });

        
        //Rythmizw to Horizontal Gap (keno 10 pixels anamesa sta koumpakia)
        buttonFlowPane.setHgap(10);
        
        //Vazw ta koumpakia sto flowPane
        buttonFlowPane.getChildren().add(newClientBtn);
        buttonFlowPane.getChildren().add(editClientBtn);
        buttonFlowPane.getChildren().add(deleteClientBtn);
        
        //Stoixizw sto katw meros kai kentro
        buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
    

        //Stoixizw sto panw meros kai aristera
    	inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
    	
    	//Rythmizw to Horizontal kai Vertical Gap se 10 pixels
    	inputFieldsPane.setVgap(10);
    	inputFieldsPane.setHgap(10);
    	
    	//Vazw ta components sto flowPane (prwta sthlh, meta grammh)
        inputFieldsPane.add(IDnumberLbl, 0, 0);
    	inputFieldsPane.add(IDnumberField, 1, 0);
    	inputFieldsPane.add(licenseNumberLbl, 0, 1);
    	inputFieldsPane.add(licenseNumberField, 1, 1);
    	inputFieldsPane.add(firstNameLbl, 0, 2);
    	inputFieldsPane.add(firstNameField, 1, 2);
    	inputFieldsPane.add(lastNameLbl, 0, 3);
    	inputFieldsPane.add(lastNameField, 1, 3);
    	inputFieldsPane.add(emailLbl, 0, 4);
    	inputFieldsPane.add(emailField, 1, 4);
    	inputFieldsPane.add(addressLbl, 0, 5);
    	inputFieldsPane.add(addressField, 1, 5);
    	inputFieldsPane.add(telephoneNumberLbl, 0, 6);
    	inputFieldsPane.add(telephoneNumberField, 1, 6);
    	inputFieldsPane.add(searchLbl, 0, 7);
    	inputFieldsPane.add(searchField, 1, 7);
    	

    	//Rythmizw to Horizontal kai Vartical gap se 10 pixels
	    rootGridPane.setVgap(10);
	    rootGridPane.setHgap(10);
	    
	    //Vazw ta components sto flowPane
	    rootGridPane.add(inputFieldsPane, 1, 0);
	    rootGridPane.add(clientTableView, 0, 0);
	    rootGridPane.add(buttonFlowPane, 0, 2);
	    rootGridPane.add(backBtn, 1, 2);

	    //Dhmiourgw TableColumns pou antistoixoun stis sthles tou pinaka
	    //An TableColumn<a,b> , tote to a einai o tupos dedomenwn pou tha dexetai o pinakas kai b o tupos dedomenwn pou tha deixnei ston xrhsth
	    //Se kathe Column rythmizoume poio property tou tupou dedomenou tha antistoixei sth medthodo setCellValueFactory(new PropertyValueFactory<>(“x”));
	    //Eisagwgh Column sto TableView me th methodo getColumns().add(column)
	    
	    TableColumn<Client, String> IDnumberColumn = new TableColumn<>("ID Number");
	    IDnumberColumn.setCellValueFactory(new PropertyValueFactory<>("IDnumber"));
	    clientTableView.getColumns().add(IDnumberColumn);
	
	    TableColumn<Client, String> licenseNumberColumn = new TableColumn<>("License Number");
	    licenseNumberColumn.setCellValueFactory(new PropertyValueFactory<>("licenseNumber"));
	    clientTableView.getColumns().add(licenseNumberColumn);
	    
	    TableColumn<Client, String> firstNameColumn = new TableColumn<>("First Name");
	    firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
	    clientTableView.getColumns().add(firstNameColumn);
	    
	    TableColumn<Client, String> lastNameColumn = new TableColumn<>("Last Name");
	    lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
	    clientTableView.getColumns().add(lastNameColumn);
	    
	    TableColumn<Client, String> emailColumn = new TableColumn<>("Email");
	    emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
	    clientTableView.getColumns().add(emailColumn);
	    
	    TableColumn<Client, String> addressColumn = new TableColumn<>("Address");
	    addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
	    clientTableView.getColumns().add(addressColumn);
	    
	    TableColumn<Client, String> telephoneNumberColumn = new TableColumn<>("Telephone Number");
	    telephoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("telephoneNumber"));
	    clientTableView.getColumns().add(telephoneNumberColumn);
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
		    
		   //Dhmiourgei neo antikeimeno mesw ths methodou createClient
		    if (event.getSource() == newClientBtn) {
		        
		        String IDnumber = IDnumberField.getText();
		        String licenseNumber = licenseNumberField.getText();
		        String firstName = firstNameField.getText();
		        String lastName = lastNameField.getText();
		        String email = emailField.getText();
		        String address = addressField.getText();
		        String telephoneNumber = telephoneNumberField.getText();
		        
		       
		        createClient(IDnumber, licenseNumber, firstName, lastName, email, address, telephoneNumber);
		        
		        //H tableSync sugxronizei ta stoixeia tou tableView me ta stoixeia ths listas
		        tableSync();
		        //Adeiazei thn lista pou exei o pinakas
		        clearTextFields();
		    }
		
		    //Ôropopoiei ena antikeimeno mesw ths methodou editClient
		    if (event.getSource() == editClientBtn) {
		    	
		    	String IDnumber = IDnumberField.getText();
		        String licenseNumber = licenseNumberField.getText();
		        String firstName = firstNameField.getText();
		        String lastName = lastNameField.getText();
		        String email = emailField.getText();
		        String address = addressField.getText();
		        String telephoneNumber = telephoneNumberField.getText();
		
		        editClient(IDnumber, licenseNumber, firstName, lastName, email, address, telephoneNumber);
		
		        tableSync();
		        clearTextFields();
		    }
		    
		    //Diagrafei ena antikeimeno mesw ths methodou deleteCar
		    if (event.getSource() == deleteClientBtn) {
		    	
		        deleteClient(IDnumberField.getText());
		
		        tableSync();
		        clearTextFields();
		    }
		    
		    //Anazhthsh
		    if (event.getSource() == searchField) {    		
	    		String search = searchField.getText();
	    		System.out.println(search);
	    	}
		    
		    //Provalei ola ta antikeimena tupou Client
		    if (event.getSource() == clientTableView) {
		        Client selectedClient = clientTableView.getSelectionModel().getSelectedItem();
		        if (selectedClient != null) {
		        	IDnumberField.setText(selectedClient.getIDnumber());
		            licenseNumberField.setText(selectedClient.getLicenseNumber());
		            firstNameField.setText(selectedClient.getFirstName());
		            lastNameField.setText(selectedClient.getLastName());
		            emailField.setText(selectedClient.getEmail());
		            addressField.setText(selectedClient.getAddress());
		            telephoneNumberField.setText(selectedClient.getTelephoneNumber());
		            
		        }
		    }
		}
		
		
		//OI METHODOI
		
		
		public void tableSync() {
		    List<Client> items = clientTableView.getItems();
		    items.clear();
		    for (Client e : clientList) {
		        if (e instanceof Client) {
		            items.add((Client) e);
		        }
		    }
		}
		
		
		public void clearTextFields() {
		    IDnumberField.setText(" ");
		    licenseNumberField.setText(" ");
		    firstNameField.setText(" ");
		    lastNameField.setText(" ");
		    emailField.setText(" " );
		    addressField.setText(" " );
		    telephoneNumberField.setText(" ");
		}
		
		
		public void createClient(String IDnumber, String licenseNumber, String firstName, String lastName, String email, String address, String telephoneNumber) {
		    Client e = new Client(IDnumber, licenseNumber, firstName, lastName, email, address, telephoneNumber);
		    clientList.add(e);
		}
		
		public void editClient(String IDnumber, String licenseNumber, String firstName, String lastName, String email, String address, String telephoneNumber) {
		    for (Client e : clientList) {
		    	
		    	IDnumberField.setEditable(false);
	 	        licenseNumberField.setEditable(false);
	 	        
	        	if (e.getIDnumber().equals(IDnumber) && e.getLicenseNumber().contentEquals(licenseNumber)) {
	        		IDnumberField.setEditable(false);
		 	        licenseNumberField.setEditable(false);
	               e.setFirstName(firstName);
	               e.setLastName(lastName);
	               e.setEmail(email);
	               e.setTelephoneNumber(telephoneNumber);
	               break;
	            }
	        }
		    
	    	IDnumberField.setEditable(true);
 	        licenseNumberField.setEditable(true);
		}
		
		public void deleteClient(String IDnumber) {
		    for (int i = 0; i < clientList.size(); i++) {
		        
				if (clientList.get(i).getIDnumber().equals(IDnumber)) {
		            clientList.remove(i);
		            break;
		        }
		    }
		}
		
		
		public void tableSyncSearch() {
	        List<Client> items = clientTableView.getItems();
	        items.clear();
	        for (Client e : clientListSearch) {
	            if (e instanceof Client) {
	                items.add((Client) e);
	            }
	        }
	    }
		
}
		 
