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
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import programdatagenerator.simulationdata.Lot;
import programdatagenerator.simulationdata.Product;
import programdatagenerator.simulationdata.Variables;
import programdatagenerator.util.XMLRead;
import ui.TesterCell;

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
    public long TotalUnitCnt=0;
    final TreeView summaryView= new TreeView();
    
    
    
    @Override
    public void start(Stage primaryStage) {
        Products= XMLRead.readProducts();
        TreeItem rootItem= new TreeItem("Products");
        summaryView.setRoot(rootItem);
        if(Products!=null){
            for(Product myProduct: Products){
                TotalUnitCnt+= myProduct.getTotalUnitCnt()*myProduct.getSiteCnt();
                TreeItem productItem = new TreeItem(myProduct.getProductName());
                productItem.getChildren().add( new TreeItem("Product Total Qty: "+ myProduct.getTotalUnitCnt()*myProduct.getSiteCnt()));
                for(Lot lot: myProduct.getRandomLot()){
                    TreeItem lotItem = new TreeItem(lot.getLotHeadInfo().getLotID());
                    productItem.getChildren().add(lotItem);
                    
                    lotItem.getChildren().add(new TreeItem("Lot Qty : " + lot.getLotHeadInfo().getLotQty()* lot.getLotHeadInfo().getSiteCnt()));
                    TreeItem lotStatusItem = new TreeItem();
                    lotStatusItem.valueProperty().bind(lot.getStatus());
                    lotItem.getChildren().add(lotStatusItem);
                }
//                myProduct.printProductInfo();
//                myProduct.printRandomLotHeadInfo();
                TreeItem totalTestedUnits= new TreeItem();
                TreeItem unitCntItem= new TreeItem("TotalTestedUnits");
                totalTestedUnits.valueProperty().bind(myProduct.getTotalTestedUnits());
                productItem.getChildren().add(unitCntItem);
                unitCntItem.getChildren().add(totalTestedUnits);

                rootItem.getChildren().add(productItem);
                
                

            }
            rootItem.getChildren().add( new TreeItem("All Products Total Qty: " + TotalUnitCnt));
            
        }
        summaryView.setShowRoot(true);
        
        System.out.println("Simulation Mode: " + Variables.simulationMode.toString());
        System.out.println("Log Path is: " + Variables.logPath.getAbsolutePath());
        System.out.println("TotalUnitCnt: " + TotalUnitCnt);
        
        
        
        
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {  
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        
        
                
        VBox vbox= new VBox();
        
        
        
        for(int i =0;i!= Variables.TesterCnt;i++){
           vbox.getChildren().add(getTesterPanel(i));
        }
        
//        vbox.getChildren().addAll(getTesterPanel(0),getTesterPanel(1),getTesterPanel(2));
     
//        TesterCell ateTester = new TesterCell(0);

       
//        vbox.getChildren().addAll(ateTester);
//        vbox.setPrefSize(200, 24*6);
        final TabPane root= new TabPane();
        Tab tab1= new Tab("Tester status");
        tab1.setClosable(false);
        Tab tab2= new Tab("Summary");
        tab2.setClosable(false);
        root.getTabs().addAll(tab1,tab2);
        
        
        
        
        
        
        ScrollPane testerPane = new ScrollPane();
        tab1.setContent(testerPane);
        tab2.setContent(summaryView);
        testerPane.setPadding(new Insets(2,2,2,2));
        testerPane.setContent(vbox);
        
        
        tester.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){

            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                
                
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
//        Scene scene = new Scene(root, 800, 600);
        Scene scene = new Scene(root, 1210, 600);
        
      
        
        
        
        primaryStage.setTitle("ATE Data Generator");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public HBox getTesterPanel(int testerNo){
        HBox hbox = new HBox();
//         hbox.setSpacing(5);
        hbox.getChildren().addAll(new TesterCell(testerNo*4),new TesterCell(testerNo*4+1),new TesterCell(testerNo*4+2),new TesterCell(testerNo*4+3) );
        return hbox;
    }
    
}
