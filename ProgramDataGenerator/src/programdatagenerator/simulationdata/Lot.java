/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programdatagenerator.simulationdata;

/**
 *
 * @author ghfan
 */
public class Lot {
    private LotHead LotHeadInfo;
    private SubLot SubLots;

    public Lot(LotHead LotHead) {
        this.LotHeadInfo=LotHead;
    }

    public LotHead getLotHeadInfo() {
        return LotHeadInfo;
    }

    public SubLot getSubLots() {
        return SubLots;
    }

    public void setLotHeadInfo(LotHead LotHeadInfo) {
        this.LotHeadInfo = LotHeadInfo;
    }
    
    
    
    
}
