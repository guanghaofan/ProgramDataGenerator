/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programdatagenerator.simulationdata;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import programdatagenerator.simulationdata.Variables.TesterStatus;
import programdatagenerator.util.DataWriter;
import programdatagenerator.util.XMLRead;

/**
 *
 * @author Administrator
 */
public class Tester {
    private String TesterName=null;
    private TesterStatus Status = null;
    private SubLot subLot=null;
    /**
     * 
     * @param testerName 
     */
    public Tester(int testerNo) {
        Status= TesterStatus.Idle;
        this.TesterName="Sapphire_"+ testerNo;
    }
    public String getTesterName() {
        return TesterName;
    }
    public void startLot(SubLot lot){
        /*
        need to get a Fresh SubLot from any product, this sublot should only be testing
        and re-testing on this tester until the yield meet the target 
        */
        subLot= lot;
        if(subLot!=null){
            /*
            assign tester and handler, DIB also set lot status InTesting 
            */
            this.subLot.printSubLot();
            this.subLot.setTesterName(TesterName);
            this.subLot.setInTesting(true);
            this.subLot.setDIB();
            this.subLot.startTesting();
            this.subLot.setLotStartTime(DataWriter.getCurrentTime());
            generateStartLot(); 
        }

    }
    public TesterStatus getStatus() {
        return Status;
    }

    public void setStatus(TesterStatus Status) {
        this.Status = Status;
    }
    public void pauseTesting(){}
    public void resumeTesting(){}
    
    public void generateStartLot(){
        DataWriter.writeStartLot(subLot);
     // start lot doesn't need a timeline
    }
    public void generateUnitData(){
        DataWriter.writeUnitData(subLot);
     // start lot doesn't need a timeline
    }
    
    /**
     * @ TODO 
     * onLotCompleted()
     * set Status
     * set DIB 
     */
    
    
    
           
    
    
}
