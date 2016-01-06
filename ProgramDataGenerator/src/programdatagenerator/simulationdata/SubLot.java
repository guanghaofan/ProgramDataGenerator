/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programdatagenerator.simulationdata;

import programdatagenerator.util.XMLRead;

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

//    public SubLot(String tester) {
//        this.TesterName=tester;
//    }

    public SubLot(int unitCnt, int subLotUnitStart, LotHead lotHead) {
        this.SubLotUnitCnt=unitCnt;
        this.SubLotUnitStart=subLotUnitStart;
        this.MotherLotHead=lotHead;
    }
    
    public void setTesterName(int TesterNo) {
        this.TesterName = "Sapphire_"+ TesterNo;
        setHandler("Handler_" + TesterNo);
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
    private void geneareteUnitDataXML(){
    
    }
    private void geneareteEndLotXML(){
    
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
