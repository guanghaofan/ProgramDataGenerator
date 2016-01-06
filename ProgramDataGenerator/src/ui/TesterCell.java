/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TreeItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import programdatagenerator.simulationdata.Product;
import programdatagenerator.simulationdata.Tester;
import programdatagenerator.simulationdata.Variables;
import programdatagenerator.util.XMLRead;


/**
 *
 * @author ghfan
 */
public class TesterCell extends Region{
    private Tester Tester;
    private Button StatusButton = new Button("Start Testing");
    private Label  StatusLabel = new Label("IDLE");
    
//    private boolean firstRun=true;
    
    

    public TesterCell(int testerNo) {
        Tester= new Tester(testerNo);
        
        StatusButton.setOnAction(new EventHandler(){

            @Override
            public void handle(Event t) {
                if(Tester.getStatus().equals(Variables.TesterStatus.Paused)){
                    Tester.setStatus(Variables.TesterStatus.Testing);
                    StatusLabel.setText("Testing");
                    Tester.resumeTesting();
                    
                    StatusButton.setText("Pause Testing");
                }
                else if(Tester.getStatus().equals(Variables.TesterStatus.Testing)){
                    Tester.setStatus(Variables.TesterStatus.Paused);
                    StatusLabel.setText("Paused");
                    Tester.pauseTesting();
                    
                    StatusButton.setText("Resume Testing");
                }
                else if(Tester.getStatus().equals(Variables.TesterStatus.Completed)||Tester.getStatus().equals(Variables.TesterStatus.Idle) ){
//                    for(Product product: XMLRead.Products){
//                        if(!product.getRandomLot().isEmpty()){
//                            Tester.setStatus(Variables.TesterStatus.Testing);
//                            StatusButton.setText("Testing");
//                            Tester.startTesting(null);
//                            
//                        }
//                        else{
//                            Tester.setStatus(Variables.TesterStatus.Idle);
//                            StatusButton.setText("Idle, No Material");
//                        }
//                    }
                    Tester.setStatus(Variables.TesterStatus.Testing);
                    StatusLabel.setText("Testing");
                    Tester.startTesting(null);
                    
                    StatusButton.setText("Pause Testing");
                    
                    
                }

                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        getChildren().addAll(StatusButton,StatusLabel);
        setMinHeight(24);
        setPrefSize(200, 24);
        setMaxSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
    }
    @Override
    protected void layoutChildren() {
        
//        StatusButton.set
//        if(getWidth()>480)
//            label.resize(120, getHeight());
//        else
//            label.resize(getWidth()/4.0, getHeight());
//        label.setLayoutX(0);
//        label.setLayoutY(0);
//        
//        textBox_1.resize(getWidth()/2-label.getWidth()/2, getHeight());
//        textBox_1.setLayoutX(label.getWidth());
//        textBox_1.setLayoutY(0);

        textBox_2.resize(getWidth()/2-label.getWidth()/2, getHeight());
        textBox_2.setLayoutX(label.getWidth()+ textBox_1.getWidth());
        textBox_2.setLayoutY(0);
        
        openButton.resizeRelocate(getWidth() - 28, 2, 28, 20);
    }
    
    
    
}
