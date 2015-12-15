/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programdatagenerator;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import programdatagenerator.simulationdata.Product;
import programdatagenerator.util.XMLRead;

/**
 *
 * @author ghfan
 */
public class ProgramDataGenerator extends Application {
    public final Label TesterType =new Label("TesterType");
    public final Label LotQty = new Label("LotQty");
    public final Label Frequency = new Label("Frequency");
    public final Label Location = new Label("Location");
//    public final String[] myTesters = new String[]{"all","sapphire","verigy","SLT","HST","hontech"};
    public final ChoiceBox tester= new ChoiceBox(FXCollections.observableArrayList("ALL","SAPPHIRE","VERIGY","SLT","HST","HONTECH"));
    public List<Product> Products= new ArrayList<>();
    
    
    
    @Override
    public void start(Stage primaryStage) {
        Products= XMLRead.getProducts();
        if(Products!=null){
            for(Product myProduct: Products){


            }
        }
        
        
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        
        tester.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){

            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                
                
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        Scene scene = new Scene(root, 300, 250);
        
        
        
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
