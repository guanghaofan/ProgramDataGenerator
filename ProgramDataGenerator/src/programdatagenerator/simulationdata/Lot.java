/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programdatagenerator.simulationdata;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ghfan
 */
public class Lot {
    private LotHead LotHeadInfo;
    private List<SubLot> SubLots= new ArrayList();

    public Lot(LotHead LotHead) {
        this.LotHeadInfo=LotHead;
        generateSubLots();
    }

    public LotHead getLotHeadInfo() {
        return LotHeadInfo;
    }

    public List<SubLot> getSubLots() {
        return SubLots;
    }

    public void setLotHeadInfo(LotHead LotHeadInfo) {
        this.LotHeadInfo = LotHeadInfo;
    }
    
    private void generateSubLots(){
        int lotUnitCnt=this.LotHeadInfo.getLotQty();
        if(lotUnitCnt>1500){
            this.SubLots.add(new SubLot(300, this.LotHeadInfo.getLotUnitStart(),LotHeadInfo));
            this.SubLots.add(new SubLot(300,this.LotHeadInfo.getLotUnitStart()+300,LotHeadInfo));
            this.SubLots.add(new SubLot(300, this.LotHeadInfo.getLotUnitStart()+600,LotHeadInfo));
            this.SubLots.add(new SubLot(300,this.LotHeadInfo.getLotUnitStart()+900,LotHeadInfo));
            this.SubLots.add(new SubLot(lotUnitCnt-1200, this.LotHeadInfo.getLotUnitStart()+1200,LotHeadInfo));
        
        }
        else if(lotUnitCnt>1200){
            this.SubLots.add(new SubLot(300,this.LotHeadInfo.getLotUnitStart(),LotHeadInfo));
            this.SubLots.add(new SubLot(300,this.LotHeadInfo.getLotUnitStart()+300,LotHeadInfo));
            this.SubLots.add(new SubLot(300, this.LotHeadInfo.getLotUnitStart()+600,LotHeadInfo));
    
            this.SubLots.add(new SubLot(lotUnitCnt-900, this.LotHeadInfo.getLotUnitStart()+900,LotHeadInfo));
        
        }
        else if(lotUnitCnt>1000){
            this.SubLots.add(new SubLot(300,this.LotHeadInfo.getLotUnitStart(),LotHeadInfo));
            this.SubLots.add(new SubLot(400,this.LotHeadInfo.getLotUnitStart()+300,LotHeadInfo));
 
            this.SubLots.add(new SubLot(lotUnitCnt-700, this.LotHeadInfo.getLotUnitStart()+700,LotHeadInfo));
        
        }
        else if(lotUnitCnt>600){
            this.SubLots.add(new SubLot(300,this.LotHeadInfo.getLotUnitStart(),LotHeadInfo));
            this.SubLots.add(new SubLot(lotUnitCnt-300,this.LotHeadInfo.getLotUnitStart()+300,LotHeadInfo));
        }
        else{
             this.SubLots.add(new SubLot(lotUnitCnt,this.LotHeadInfo.getLotUnitStart(),LotHeadInfo));
        }
    }
    
    public void printLotInfo(){
        LotHeadInfo.printLotHead();
        for(SubLot lot: this.SubLots){
            lot.printSubLot();
        }
    }
    
    
    
}
