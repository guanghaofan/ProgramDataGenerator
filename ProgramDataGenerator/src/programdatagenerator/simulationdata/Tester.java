/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programdatagenerator.simulationdata;

import programdatagenerator.simulationdata.Variables.TesterStatus;
import programdatagenerator.util.XMLRead;

/**
 *
 * @author Administrator
 */
public class Tester {
    private String TesterName=null;
    private TesterStatus Status = null;
    private Lot lot=null;
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
    public void startTesting(){
//      LotID=XMLRead.getNextLot().getLotHeadInfo().getLotID();
        
        lot= XMLRead.getNextLot();
        for(SubLot subLot: lot.getSubLots()){
            if(!subLot.isSubLotCompleted()){
                this.subLot=subLot;
                break;
            }
        }
        // should be only a sub lot in a mother lot
        
        
        
        
//        lot.getLotHeadInfo().printLotHead();
       
    }

    public TesterStatus getStatus() {
        return Status;
    }

    public void setStatus(TesterStatus Status) {
        this.Status = Status;
    }
    public void pauseTesting(){}
    public void resumeTesting(){}

    public Lot getLot() {
        return lot;
    }
    public void printLotHead(){
          
    }
    
    
    /**
     * @ TODO 
     * onLotCompleted()
     * set Status
     * set DIB 
     */
    
    
    
           
    
    
}
