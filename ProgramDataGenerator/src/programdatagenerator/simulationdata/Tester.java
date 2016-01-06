/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programdatagenerator.simulationdata;

import programdatagenerator.simulationdata.Variables.TesterStatus;

/**
 *
 * @author Administrator
 */
public class Tester {
    private String TesterName=null;
   // private status
    private TesterStatus Status = null;
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
    public void startTesting(Lot lot){
        
    }

    public TesterStatus getStatus() {
        return Status;
    }

    public void setStatus(TesterStatus Status) {
        this.Status = Status;
    }
    public void pauseTesting(){}
    public void resumeTesting(){}
    
    /**
     * @ TODO 
     * onLotCompleted()
     * set Status
     * set DIB 
     */
    
    
    
           
    
    
}
