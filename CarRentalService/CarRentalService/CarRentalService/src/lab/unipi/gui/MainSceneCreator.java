package lab.unipi.gui;

import java.io.FileNotFoundException;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

public class MainSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {
	
    //Flow Pane
    FlowPane rootFlowPane;
    
    //Main Scene Buttons
    Button cityBtn, storeBtn, clientBtn, vehicleBtn, vehicleRentalBtn;
    
    public MainSceneCreator(double width, double height) throws FileNotFoundException {
    	
    	super(width, height);
    	
        rootFlowPane = new FlowPane();
        cityBtn = new Button("Cities");
        storeBtn = new Button("Stores");
        clientBtn = new Button("Clients");
        vehicleBtn=new Button("Vehicle");
        vehicleRentalBtn = new Button("Vehicle Rental");
    
        
        //"Denw" ton EventHandler me to component apo to opoio kaleitai h  handle method kathe fora pou klikaroume
        cityBtn.setOnMouseClicked(this);
        storeBtn.setOnMouseClicked(this);
        storeBtn.setOnMouseClicked(this);
        clientBtn.setOnMouseClicked(this);
        vehicleBtn.setOnMouseClicked(this);
        vehicleRentalBtn.setOnMouseClicked(this);
        

        //Rythmizw to Horizontal Gap (keno 10 pixels anamesa sta koumpakia)
        rootFlowPane.setHgap(10);
        
        //Stoixizw sto kentro
        rootFlowPane.setAlignment(Pos.CENTER);
               
        //Prosthetw ta koumpia City,Store,Client,VehicleRental kai to ComboBox sto rootFlowPane
        rootFlowPane.getChildren().add(cityBtn);
        rootFlowPane.getChildren().add(storeBtn);
        rootFlowPane.getChildren().add(clientBtn);
        rootFlowPane.getChildren().add(vehicleBtn);
        rootFlowPane.getChildren().add(vehicleRentalBtn);
        
       
       
    }

    @Override
    public Scene createScene() {
        return new Scene(rootFlowPane, width, height);
    }
    
   

    @Override
    public void handle(MouseEvent event) {
    	
        if (event.getSource() == storeBtn) {
            CarRentMainFX.mainStage.setTitle("Stores");
            CarRentMainFX.mainStage.setScene(CarRentMainFX.storeScene);
        }
        
        if (event.getSource()==cityBtn) {
        	CarRentMainFX.mainStage.setTitle("Cities");
        	CarRentMainFX.mainStage.setScene(CarRentMainFX.cityScene);
        }
        
        if (event.getSource()==clientBtn) {
        	CarRentMainFX.mainStage.setTitle("Clients");
        	CarRentMainFX.mainStage.setScene(CarRentMainFX.clientScene);
        }
        
        if (event.getSource() == vehicleBtn) {
            CarRentMainFX.mainStage.setTitle("Vehicles");
            CarRentMainFX.mainStage.setScene(CarRentMainFX.vehicleScene);
        }
        
        if (event.getSource() == vehicleRentalBtn) {
        	CarRentMainFX.mainStage.setTitle("Rentals");
        	CarRentMainFX.mainStage.setScene(CarRentMainFX.vehicleRentalScene);
        }
        
    }
}