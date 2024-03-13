package lab.unipi.gui;
import lab.unipi.core.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CarRentMainFX extends Application {
	
	//Arxikopoihsh twn ArrayLists
	static ArrayList<City> cityList = new ArrayList<City>();
	static ArrayList<Store> storeList = new ArrayList<Store>();
	static ArrayList<Client> clientsList = new ArrayList<Client>();
	static ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
	static ArrayList<Car> carList = new ArrayList<Car>();
	static ArrayList<TwoWheeled> twoWheeledList = new ArrayList<TwoWheeled>();

    //Arxikopoihsh tou kuriou stage
    static Stage mainStage;
    
    //Arxikopoihsh twn Scenes
    static Scene mainScene,storeScene, cityScene, clientScene, vehicleScene, vehicleRentalScene ;
    
    //H main
    public static void main(String[] args) {
        launch(args);
    }
    
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
    	
        mainStage = primaryStage;
        
        SceneCreator mainSceneCreator = new MainSceneCreator(650, 500);
        SceneCreator storeSceneCreator = new StoreSceneCreator(650, 500);
        SceneCreator citySceneCreator = new CitySceneCreator(650,500);
        SceneCreator clientSceneCreator = new ClientSceneCreator(900,500);
        SceneCreator vehicleSceneCreator = new VehicleSceneCreator(1000, 500);
        SceneCreator rentalSceneCreator = new RentalSceneCreator(1100,500);
        
        mainScene = mainSceneCreator.createScene();
        storeScene = storeSceneCreator.createScene();
        cityScene = citySceneCreator.createScene();
        clientScene = clientSceneCreator.createScene();
        vehicleScene = vehicleSceneCreator.createScene(); 
        vehicleRentalScene = rentalSceneCreator.createScene();
        
        primaryStage.setTitle("Car Rental Service");
        primaryStage.setScene(mainScene);
        primaryStage.show();
        
        
    }
}  