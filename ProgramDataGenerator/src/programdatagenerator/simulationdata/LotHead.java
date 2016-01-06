/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programdatagenerator.simulationdata;

import java.io.File;

/**
 *
 * @author Administrator
 */
public class LotHead {
    /*
    <LotID>W123456</LotID>
    <TestProgram>SX1SP1XXCB1FFS0</TestProgram>
    <ProgramVersion>1.3</ProgramVersion>
    <TestCode>AABBCC</TestCode>
    <MFGStep>6210</MFGStep>
    <Device>8888D66</Device>
    <Package>UOF433</Package>
    <Facility>SUZHOU</Facility>
    */
    private String ProductName=null;
    private String LotID=null;
    private String TestProgram =null;
    private String TestCode =null;
    private String ProgramVersion =null;
    private String MFGStep= null;
    private String Device=null;
    private String Package =null;
    private String Facility =null; 
    private int LotQty=0;
    private int SiteCnt=0;
    private int LotUnitStart=0; //start from 0
    
    
    
 
    /**
    *@param LotID
    * @param ProductName
    * @param TestProgram
    * @param TestCode
    * @param  ProgramVersion
    * @param MFGStep
    * @param Device
    * @param Package
    * @param Facility
    * @param LotQty
    * @param SiteCnt
    * @param LotUnitStart
    */
    public LotHead(String LotID, String ProductName, String TestProgram, String ProgramVersion,
            String TestCode,String MFGStep, String Device,String Package, 
            String Facility, int LotQty, int SiteCnt, int LotUnitStart){
        this.LotID=LotID;
        this.ProductName=ProductName;
        this.TestProgram= TestProgram;
        this.TestCode= TestCode;
        this.ProgramVersion=ProgramVersion;
        this.MFGStep=MFGStep;
        this.Device=Device;
        this.Package=Package;
        this.Facility=Facility;
        this.LotQty=LotQty;
        this.SiteCnt=SiteCnt;
        this.LotUnitStart=LotUnitStart;

    }

    public LotHead() {
    }
    
    public void printLotHead(){
        System.out.println();
        System.out.println("<----Lot Head Information---->");
        
        System.out.println("LotID: "+ this.LotID);
        System.out.println("ProductName: "+ this.ProductName);
        System.out.println("TestProgram: "+ this.TestProgram);
        System.out.println("TestCode: "+ this.TestCode);
        System.out.println("ProgramVersion: "+ this.ProgramVersion);
        System.out.println("MFGStep: "+ this.MFGStep);
        System.out.println("Device: "+ this.Device);
        System.out.println("Package: "+ this.Package);
        System.out.println("Facility: "+ this.Facility);
        System.out.println("LotQty: "+ this.LotQty);
        System.out.println("SiteCnt: "+ this.SiteCnt);
        System.out.println("LotUnitStart: "+ this.LotUnitStart);

        System.out.println("<--End Lot Head Information--->");
//        System.out.println("LotID: "+ this.LotID);
//        System.out.println("LotID: "+ this.LotID);
//        System.out.println("LotID: "+ this.LotID);
        
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getLotID() {
        return LotID;
    }

    public void setLotID(String LotID) {
        this.LotID = LotID;
    }

    public String getTestProgram() {
        return TestProgram;
    }

    public void setTestProgram(String TestProgram) {
        this.TestProgram = TestProgram;
    }

    public String getTestCode() {
        return TestCode;
    }

    public void setTestCode(String TestCode) {
        this.TestCode = TestCode;
    }

    public String getProgramVersion() {
        return ProgramVersion;
    }

    public void setProgramVersion(String ProgramVersion) {
        this.ProgramVersion = ProgramVersion;
    }

    public String getMFGStep() {
        return MFGStep;
    }

    public void setMFGStep(String MFGStep) {
        this.MFGStep = MFGStep;
    }

    public String getDevice() {
        return Device;
    }

    public void setDevice(String Device) {
        this.Device = Device;
    }

    public String getPackage() {
        return Package;
    }

    public void setPackage(String Package) {
        this.Package = Package;
    }

    public String getFacility() {
        return Facility;
    }

    public void setFacility(String Facility) {
        this.Facility = Facility;
    }

    public int getLotQty() {
        return LotQty;
    }

    public void setLotQty(int LotQty) {
        this.LotQty = LotQty;
    }

    public int getSiteCnt() {
        return SiteCnt;
    }

    public void setSiteCnt(int SiteCnt) {
        this.SiteCnt = SiteCnt;
    }  
 
    public int getLotUnitStart() {
        return LotUnitStart;
    }
    public void generateXML(){
        if(Variables.logPath!=null){
           
            
        }
        
        
    }
    
    
    
     
    
    
    
}
