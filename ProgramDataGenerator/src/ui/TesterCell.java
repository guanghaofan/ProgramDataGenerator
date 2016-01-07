/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import programdatagenerator.simulationdata.Tester;
import programdatagenerator.simulationdata.Variables;

import org.controlsfx.tools.Borders;
import programdatagenerator.simulationdata.Lot;
import programdatagenerator.simulationdata.SubLot;
import programdatagenerator.util.XMLRead;

/**
 *
 * @author ghfan
 */
public class TesterCell extends Region{
    private Tester Tester;
//    private Button StatusButton = new Button("Start Testing");
//    private Label  StatusLabel = new Label("IDLE");
    
    private final Label TestModeLabel= new Label("Test Mode");
    private final TextField TestModeField= new TextField();
    
    private final Label ProductLabel= new Label("Product");
    private final TextField ProductField= new TextField();
    
    private final Label LotLabel = new Label("LotID");
    private final TextField LotIDField= new TextField();
    
    private final Label YieldLabel = new Label("Yield");
    private final TextField YieldField= new TextField();
    
    private final Label TestCodeLabel = new Label("Test Code");
    private final TextField TestCodeField= new TextField();
    
    private final TextField LotQtyField= new TextField();
    private final  Label LotQty = new Label("Lot Qty");
    
    private final TextField TestedUnitsField= new TextField();
    private final Label TestedUnitsLabel = new Label("Tested Units");
    
    private final Label TesterStatusLabel =new Label("Tester Status");
    private final TextField TesterStatusField =new TextField();
    
    private final Label LotStartTimeLabel = new Label("LotStartTime");
    private final TextField LotStartTimeField= new TextField();
    private final Button button = new Button("Start Testing");
    
//    private Lot lot=null;
            
    
//    private boolean firstRun=true;
    
    

    public TesterCell(int testerNo) {
        Tester= new Tester(testerNo);
        
        button.setOnAction(new EventHandler(){

            @Override
            public void handle(Event t) {
                if(Tester.getStatus().equals(Variables.TesterStatus.Paused)){
                    Tester.setStatus(Variables.TesterStatus.Testing);
                    TesterStatusField.setText("Testing");
                    Tester.resumeTesting();
                    
                    button.setText("Pause Testing");
                }
                else if(Tester.getStatus().equals(Variables.TesterStatus.Testing)){
                    Tester.setStatus(Variables.TesterStatus.Paused);
                    TesterStatusField.setText("Paused");
                    Tester.pauseTesting();
                    
                    button.setText("Resume Testing");
                }
                else if(Tester.getStatus().equals(Variables.TesterStatus.Completed)||Tester.getStatus().equals(Variables.TesterStatus.Idle) ){
                    
                    SubLot subLot= XMLRead.getNextSubLot();
                    if(subLot!=null){
                        //successfuly get sublot and start testing
                        button.setText("Pause Testing");
                        subLot.setLotStartTime(System.currentTimeMillis());
                        Tester.setStatus(Variables.TesterStatus.Testing);
                        TesterStatusField.setText("Testing");
                        /**
                        TODO
                        add colour for status field
                        */
//                        TesterStatusField.setDisable(true);
//                        TesterStatusField.setBackground(Background.EMPTY);
                        
                        ProductField.setText(subLot.getMotherLotHead().getProductName());
                        LotIDField.setText(subLot.getMotherLotHead().getLotID());
                        TestModeField.setText("Fresh");
                        LotQtyField.setText(String.valueOf(subLot.getSubLotUnitCnt()));
                        LotStartTimeField.setText(String.valueOf(subLot.getLotStartTime()));
                        
                        Tester.startTesting(subLot);
                    }
                    
                    
                }

                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
//        getChildren().addAll(StatusButton,StatusLabel);
        
//        getChildren().addAll(ProductLabel,ProductField,LotLabel,LotIDField,YieldLabel,YieldField,TestCodeLabel,TestCodeField,LotQty,LotQtyField,TesterLabel,TesterField);
//        setMinHeight(24);
//        setPrefSize(200, 24)
    
        
//        ProductLabel.setLayoutX(0);
//        ProductLabel.setLayoutY(0);
//       
//        
//        ProductField.setLayoutX(getWidth()/3);
//        ProductField.setLayoutY(0);
//        
//        HBox hbox= new HBox();
//        hbox.getChildren().addAll(ProductLabel,ProductField);
       
        
        
//        LotLabel.setLayoutX(0);
//        LotLabel.setLayoutY(getHeight()/6);
//      
//        
//        LotIDField.setLayoutX(getWidth()/3);
//        LotIDField.setLayoutY(getHeight()/6);
        
//        HBox hbox1= new HBox();
//        hbox1.getChildren().addAll(LotLabel,LotIDField);
        
        
//        YieldLabel.setLayoutX(0);
//        YieldLabel.setLayoutY(getHeight()/3);
//        
//        
//        YieldField.setLayoutX(getWidth()/3);
//        YieldField.setLayoutY(getHeight()/3);
//        HBox hbox2= new HBox();
//        hbox2.getChildren().addAll(YieldLabel,YieldField);
        
//        
//        TestCodeLabel.setLayoutX(0);
//        TestCodeLabel.setLayoutY(getHeight()/2);
//        
//        
//        TestCodeField.setLayoutX(getWidth()/3);
//        TestCodeField.setLayoutY(getHeight()/2);
//        HBox hbox3= new HBox();
//        hbox3.getChildren().addAll(TestCodeLabel,TestCodeField);
        
//        LotQty.setLayoutX(0);
//        LotQty.setLayoutY(getHeight()*2/3);
//       
//        
//        LotQtyField.setLayoutX(getWidth()/3);
//        LotQtyField.setLayoutY(getHeight()*2/3);
//        HBox hbox4= new HBox();
//        hbox4.getChildren().addAll(LotQty,LotQtyField);
        
        
//        TesterLabel.setLayoutX(0);
//        TesterLabel.setLayoutY(getHeight()*5/6);
//        
//        
//        TesterField.setLayoutX(getWidth()/3);
//        TesterField.setLayoutY(getHeight()*5/6);
//        HBox hbox5= new HBox();
//        hbox5.getChildren().addAll(TesterLabel,TesterField);
        
        VBox vbox= new VBox();
//        vbox.getChildren().addAll(hbox,hbox1,hbox2,hbox3,hbox4);
        vbox.setPadding(new Insets(2));
        vbox.getChildren().addAll(ProductLabel,LotLabel,TestModeLabel,LotQty,LotStartTimeLabel,TestedUnitsLabel,YieldLabel,TesterStatusLabel);
        vbox.setSpacing(14);
        vbox.setFillWidth(true);
        
         VBox vbox1= new VBox();
//        vbox.getChildren().addAll(hbox,hbox1,hbox2,hbox3,hbox4);
        vbox1.setPadding(new Insets(2));
        vbox1.setFillWidth(true);
        vbox1.getChildren().addAll(ProductField,LotIDField,TestModeField,LotQtyField,LotStartTimeField,TestedUnitsField,YieldField,TesterStatusField);
        ProductField.setEditable(false);
        LotIDField.setEditable(false);
        TestModeField.setEditable(false);
        LotQtyField.setEditable(false);
        YieldField.setEditable(false);
        TestedUnitsField.setEditable(false);
        TesterStatusField.setEditable(false);
        LotStartTimeField.setEditable(false);
        vbox1.setSpacing(5);
        
//        vbox.setPrefHeight(120);
//        vbox1.setPrefHeight(120);
        
        HBox hbox=new HBox();
        hbox.setPadding(new Insets(3));
        hbox.getChildren().addAll(vbox,vbox1);
                
        Pane root = new Pane();
        button.setAlignment(Pos.CENTER);
        button.setPrefWidth(250);
//        button.setPadding(new Insets(3));
        
        VBox vbox3 = new VBox();
        vbox3.setSpacing(5);
        vbox3.getChildren().addAll(hbox, button);
        
        Node wrappedButton = Borders.wrap(vbox3)
                
                
//                                                 .emptyBorder()
//                                                     .padding(20)
//                                                     .build()
                                                 .lineBorder()
                                                     .title(Tester.getTesterName())
//                                                     .color(Color.GREEN)
//                                                     .thickness(1, 0, 0, 0)
                                                     .thickness(2)
                                                     .radius(5, 5, 5, 5)
                                                     .build()
//                                                 .emptyBorder()
//                                                     .padding(20)
//                                                     .build()
//                                                 .etchedBorder()
//                                                     .title("Etched")
//                                                     .build()
//                                                 .emptyBorder()
//                                                     .padding(20)
//                                                     .build()
                                                 .build();
        
        root.getChildren().add(wrappedButton);
        getChildren().add(root);
        
//        setMinHeight(24*6);
//        setPrefSize(200, 24*6);
        setMaxSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
        
       
    }
    @Override
    protected void layoutChildren(){
//         button.setPrefWidth(getWidth()-40);
        
//        StatusButton.setLayoutX(0);
//        StatusButton.setLayoutY(0);
//        StatusButton.resize(getWidth()/2, getHeight());
//         
//        StatusLabel.setLayoutX(getWidth()/2);
//        StatusLabel.setLayoutY(0);
//        StatusLabel.resize(getWidth()/2, getHeight());
        
        
//        ProductLabel.setLayoutX(0);
//        ProductLabel.setLayoutY(0);
//        ProductLabel.resize(getWidth()/3, getHeight()/6);
//        
//        ProductField.setLayoutX(getWidth()/3);
//        ProductField.setLayoutY(0);
//        ProductField.resize(getWidth()*2/3, getHeight()/6);
//        
//        
//        LotLabel.setLayoutX(0);
//        LotLabel.setLayoutY(getHeight()/6);
//        LotLabel.resize(getWidth()/3, getHeight()/6);
//        
//        LotIDField.setLayoutX(getWidth()/3);
//        LotIDField.setLayoutY(getHeight()/6);
//        LotIDField.resize(getWidth()*2/3, getHeight()/6);
//        
//        
//        YieldLabel.setLayoutX(0);
//        YieldLabel.setLayoutY(getHeight()/3);
//        YieldLabel.resize(getWidth()/3, getHeight()/6);
//        
//        YieldField.setLayoutX(getWidth()/3);
//        YieldField.setLayoutY(getHeight()/3);
//        YieldField.resize(getWidth()*2/3, getHeight()/6);
//        
//        
//        TestCodeLabel.setLayoutX(0);
//        TestCodeLabel.setLayoutY(getHeight()/2);
//        TestCodeLabel.resize(getWidth()/3, getHeight()/6);
//        
//        TestCodeField.setLayoutX(getWidth()/3);
//        TestCodeField.setLayoutY(getHeight()/2);
//        TestCodeField.resize(getWidth()*2/3, getHeight()/6);
//        
//        LotQty.setLayoutX(0);
//        LotQty.setLayoutY(getHeight()*2/3);
//        LotQty.resize(getWidth()/3, getHeight()/6);
//        
//        LotQtyField.setLayoutX(getWidth()/3);
//        LotQtyField.setLayoutY(getHeight()*2/3);
//        LotQtyField.resize(getWidth()*2/3, getHeight()/6);
        
//        ProductLabel.setLayoutX(0);
//        ProductLabel.setLayoutY(0);
//        ProductLabel.resize(60, getHeight()/6);
//        
//        ProductField.setLayoutX(getWidth()/3);
//        ProductField.setLayoutY(0);
//        ProductField.resize(100, getHeight()/6);
//        
//        
//        LotLabel.setLayoutX(0);
//        LotLabel.setLayoutY(getHeight()/6);
//        LotLabel.resize(60, getHeight()/6);
//        
//        LotIDField.setLayoutX(getWidth()/3);
//        LotIDField.setLayoutY(getHeight()/6);
//        LotIDField.resize(100, getHeight()/6);
//        
//        
//        YieldLabel.setLayoutX(0);
//        YieldLabel.setLayoutY(getHeight()/3);
//        YieldLabel.resize(60, getHeight()/6);
//        
//        YieldField.setLayoutX(getWidth()/3);
//        YieldField.setLayoutY(getHeight()/3);
//        YieldField.resize(100, getHeight()/6);
//        
//        
//        TestCodeLabel.setLayoutX(0);
//        TestCodeLabel.setLayoutY(getHeight()/2);
//        TestCodeLabel.resize(60, getHeight()/6);
//        
//        TestCodeField.setLayoutX(getWidth()/3);
//        TestCodeField.setLayoutY(getHeight()/2);
//        TestCodeField.resize(100, getHeight()/6);
//        
//        LotQty.setLayoutX(0);
//        LotQty.setLayoutY(getHeight()*2/3);
//        LotQty.resize(60, getHeight()/6);
//        
//        LotQtyField.setLayoutX(getWidth()/3);
//        LotQtyField.setLayoutY(getHeight()*2/3);
//        LotQtyField.resize(100, getHeight()/6);
//        
//        
//        TesterLabel.setLayoutX(0);
//        TesterLabel.setLayoutY(getHeight()*5/6);
//        TesterLabel.resize(60, getHeight()/6);
//        
//        TesterField.setLayoutX(getWidth()/3);
//        TesterField.setLayoutY(getHeight()*5/6);
//        TesterField.resize(100, getHeight()/6);
        
//        
        
        

    }
    
    
    
}
