/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programdatagenerator.simulationdata;

import java.util.ArrayList;
import java.util.List;
import programdatagenerator.util.XMLRead;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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
private String logPath=null;
private IntegerProperty totalTestedUnits =new SimpleIntegerProperty(1);
private StringProperty yield = new SimpleStringProperty("0.0%");
private Double totalPassCnt=0.0;
private String YYMM=null;
private ArrayList<String> rejects= new ArrayList<>();
private boolean ReadForTesting=false;

//    public SubLot(String tester) {
//        this.TesterName=tester;
//    }

    public SubLot(int unitCnt, int subLotUnitStart, LotHead lotHead) {
        totalTestedUnits.setValue(0);
        this.SubLotUnitCnt=unitCnt;
        this.SubLotUnitStart=subLotUnitStart;
        this.MotherLotHead=lotHead;
        this.DataSetCnt=unitCnt/5;
        if(unitCnt%5!=0)
            this.DataSetCnt+=1;
        ReadForTesting=true;
    }
    public SubLot(int unitCnt, LotHead lotHead, ArrayList<String> rejects) {
       
        this.MotherLotHead=lotHead;
        totalTestedUnits.setValue(0);
        this.SubLotUnitCnt=unitCnt/this.MotherLotHead.getSiteCnt();
        if(unitCnt%this.MotherLotHead.getSiteCnt()!=0)
            this.SubLotUnitCnt+=1;
        
     
        for(String unitID: rejects){
            System.out.println("add reject to rescreen lot " + unitID);
            this.rejects.add(unitID);
        }
        
        this.DataSetCnt=SubLotUnitCnt/5;
        System.out.println("data set count is " + SubLotUnitCnt +"/5 = "+ this.DataSetCnt );
       
        System.out.println("data set count is " + SubLotUnitCnt +"/5 = "+ this.DataSetCnt );
        
        if(SubLotUnitCnt%5!=0)
            this.DataSetCnt+=1;
        System.out.println("data set count is " + this.DataSetCnt);
        
        
        
        this.FreshLot=false;
        this.InTesting=false;
        this.TestCompleted=false;
        ReadForTesting=true;
    }
    
    public void setTesterName(String tester) {
        this.TesterName = tester;
        setHandler("Handler_"+ tester.substring("sapphire".length()));
    }

    public String getTesterName() {
        return TesterName;
    }

    public String getDIB() {
        return DIB;
    }
    
    

    public Double getTotalPassCnt() {
        return totalPassCnt;
    }

    public void setTotalPassCnt(Double totalPassCnt) {
        this.totalPassCnt = totalPassCnt;
    }

    public StringProperty getYield() {
        return yield;
    }

    public void setYield(String yield) {
        this.yield.setValue(yield);
    }

    public void setTotalTestedUnits(int totalTestedUnits) {
        this.totalTestedUnits.setValue(totalTestedUnits);
    }
    

    public IntegerProperty getTotalTestedUnits() {
        return totalTestedUnits;
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
    
   

    public void setYYMM(String YYMM) {
        this.YYMM = YYMM;
    }

    public String getYYMM() {
        return YYMM;
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
    

    public String getLogPath() {
        return logPath;
    }

    public void setLogPath(String logPath) {
        this.logPath = logPath;
    }
    

    public ArrayList<String> getRejects() {
        return rejects;
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
    public String getTestMode(){
        if(this.FreshLot)
            return "Fresh";
        else
            return "Rescreen";
    }

    public boolean isReadForTesting() {
        return ReadForTesting;
    }
   
    
    
}
