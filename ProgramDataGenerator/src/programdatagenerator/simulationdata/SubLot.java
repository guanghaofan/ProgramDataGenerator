/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programdatagenerator.simulationdata;

import javafx.animation.KeyFrame;
import programdatagenerator.util.DataWriter;
import programdatagenerator.util.XMLRead;
import javafx.animation.Timeline;
import javafx.animation.TimelineBuilder;
import javafx.util.Duration;

/**
 *
 * @author ghfan
 */
public class SubLot{
private LotHead MotherLotHead;    
private String TesterName=null;   
private String Handler=null;
private String DIB=null;
private int SubLotUnitCnt=0;
private int SubLotUnitStart=0;
private String SubLotID=null;

private boolean TestCompleted=false;
private boolean InTesting=false;
private boolean FreshLot=true;
private String LotStartTime=null;

private int DataSetCnt=0;
private int CurrentDataSetNo=0;
private long LastTestedTime=0;
//    public SubLot(String tester) {
//        this.TesterName=tester;
//    }

    public SubLot(int unitCnt, int subLotUnitStart, LotHead lotHead) {
        this.SubLotUnitCnt=unitCnt;
        this.SubLotUnitStart=subLotUnitStart;
        this.MotherLotHead=lotHead;
        this.DataSetCnt=unitCnt/5;
        if(unitCnt%5!=0)
            this.DataSetCnt+=1;
    }
    
    public void setTesterName(String tester) {
        this.TesterName = tester;
        setHandler("Handler_"+ tester.split("_")[1]);
    }

    public String getTesterName() {
        return TesterName;
    }

    public String getDIB() {
        return DIB;
    }
    

    public String getHandler() {
        return Handler;
    }

    public void setDIB() {
        for(Product product:XMLRead.Products ){
            if(product.getProductName().equals(this.MotherLotHead.getProductName())){
                if(product.getDIB().isEmpty()){
                    this.DIB= product.getShortName()+"_DIB_" + product.getTotalDIBCnt();
                    product.setTotalDIBCnt(product.getTotalDIBCnt()+1);
                }
                else
                    this.DIB=product.getDIB().get(0);
            }
        }
    }

    private void setHandler(String Handler) {
        this.Handler = Handler;
    }
    
    public void startTesting(){
        geneareteStartLotXML();
        geneareteUnitDataXML();
        geneareteEndLotXML();
    }
    
    private void geneareteStartLotXML(){
       
          
                    
                    
            
            
                    
           
        
    }
    
    

    public void setCurrentDataSetNo(int CurrentDataSetNo) {
        this.CurrentDataSetNo = CurrentDataSetNo;
    }

    public int getCurrentDataSetNo() {
        return CurrentDataSetNo;
    }
    private void geneareteUnitDataXML(){
    
    }
    private void geneareteEndLotXML(){
    
    }
    

    public void setTestCompleted(boolean SubLotCompleted) {
        this.TestCompleted = SubLotCompleted;
    }

    public boolean isTestCompleted() {
        return TestCompleted;
    }

    public void setSubLotUnitCnt(int SubLotUnitCnt) {
        this.SubLotUnitCnt = SubLotUnitCnt;
    }

    public void setFreshLot(boolean FreshLot) {
        this.FreshLot = FreshLot;
    }

    public void setSubLotID(String SubLotID) {
        this.SubLotID = SubLotID;
    }

    public void setInTesting(boolean InTesting) {
        this.InTesting = InTesting;
    }

    public boolean isInTesting() {
        return InTesting;
    }

    public boolean isFreshLot() {
        return FreshLot;
    }

    public int getSubLotUnitStart() {
        return SubLotUnitStart;
    }

    public int getSubLotUnitCnt() {
        return SubLotUnitCnt;
    }

    public LotHead getMotherLotHead() {
        return MotherLotHead;
    }

    public String getSubLotID() {
        return SubLotID;
    }
    

    public void setLotStartTime(String LotStartTime) {
        this.LotStartTime = LotStartTime;
    }
    

    public String getLotStartTime() {
        return LotStartTime;
    }
    

    public void setDataSetCnt(int DataSetCnt) {
        this.DataSetCnt = DataSetCnt;
    }

    public int getDataSetCnt() {
        return DataSetCnt;
    }
    

    public void setLastTestedTime(long LastTestedTime) {
        this.LastTestedTime = LastTestedTime;
    }

    public long getLastTestedTime() {
        return LastTestedTime;
    }
    
    public void printSubLot(){
        /*
        private String TesterName=null;   
        private String Handler=null;
        private String DIB=null;
        private int SubLotUnitCnt=0;
        private int SubLotUnitStart=0;
        private String SubLotID=null;
        */

        String space="    ";
        println(space, "SubLotID", this.SubLotID);
        println(space,"Tester", this.TesterName );
        println(space, "Handler",this.Handler );
        println(space, "DIB",this.DIB);
        println(space, "SubLotUnitCnt",String.valueOf(SubLotUnitCnt));
        println(space, "SubLotUnitStart",String.valueOf(SubLotUnitStart));
       
        
    }
    private void println(String space, String field, String content){
        if(content!=null)
            System.out.println(space + field + " : "+ content);
    }
    
}
