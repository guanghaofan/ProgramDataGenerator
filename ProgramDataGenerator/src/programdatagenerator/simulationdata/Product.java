/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programdatagenerator.simulationdata;

import java.io.File;
import static java.lang.Math.random;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.ElementHandler;
import org.dom4j.ElementPath;
import org.dom4j.io.SAXReader;

/**
 *
 * @author ghfan
 */
public class Product {
    private String ProductName=null;
    private String ShortName=null;
    private String TestProgram=null;
    private List<String> ProgramVersion= new ArrayList<>();
    private List<String> TestCode = new ArrayList<>();
    private List<String> DIB = new ArrayList<>();
    private List<String> MFGStep= new ArrayList<>();
    private String Device=null;
    private List<String> Package= new ArrayList<>();
    private String Facility=null;
    private int LotCnt=0;
    private int LotQty=0;
    private int SiteCnt=0;
    private int TotalDIBCnt=0;
    private int TotalUnitCnt=0;
    
    private List<Lot> RandomLot= new ArrayList<>();
    private Double AvgTestTime=0.0;
   

    @SuppressWarnings("empty-statement")
    public Product(Element element) {
        List<Element> nodes= element.elements();
        if(!nodes.isEmpty()){
            this.ProductName=element.attributeValue("name");
            
            for(Element node:nodes){
//                System.out.println(node.getText());
                switch(node.getName()){
                        case "TestProgram":
                            this.TestProgram=node.getText();
                            break;
                        case "ShortName":
                            this.ShortName=node.getText();
                            break;    
                        case "ProgramVersion":
                            readValue(this.ProgramVersion,node);
                           break;
                        case "AvgTestTime":
                           this.AvgTestTime=Double.valueOf(node.getText());
                           break;
                        case "TestCode":
                            readValue(this.TestCode, node);
                            break;
                        case "MFGStep":
                            readValue(this.MFGStep,node);
                            break;
                        case "Device":
                            this.Device=node.getText();
                            break;   
                        case "Package":
                            readValue(this.Package,node);
                            break;   
                        case "Facility":
                            this.Facility=node.getText();
                            break;    
                        case "LotCnt":
                            this.LotCnt=Integer.parseInt(node.getText());
                            break;  
                        case "LotQty":
                            this.LotQty=Integer.parseInt(node.getText());
                            break;  
                        case "SiteCnt":
                            this.SiteCnt= Integer.parseInt(node.getText());
                            break;  
                }                     
            }
            int LotNo=0;
            String LotID=null;
            for(int i=0; i!=this.ProgramVersion.size();i++){
                for(int j=0; j!= this.TestCode.size();j++){
                    for(int k=0; k!= this.Package.size();k++){
                        for(int mfgStep=0; mfgStep!= this.MFGStep.size();mfgStep++){
                            for(int r=0; r!= this.LotCnt;r++){

                                try {
                                    if(LotNo<10){
                                        LotID=this.ShortName+ "00" + String.valueOf(LotNo);
                                    }
                                    else if(LotNo<99){
                                        LotID=this.ShortName+ "0" + String.valueOf(LotNo);
                                    }
                                    else
                                        LotID=this.ShortName + String.valueOf(LotNo);
                                    LotID+=String.valueOf(System.currentTimeMillis());
                                    Thread.sleep(10);
                                    
                                    int lotQty= (int) (this.getLotQty() + random()*30);
                                    
                                    this.RandomLot.add(new Lot( new LotHead(LotID, this.ProductName, this.TestProgram,
                                            this.ProgramVersion.get(i), this.TestCode.get(j),this.MFGStep.get(mfgStep), this.Device,
                                            this.Package.get(k),this.Facility,lotQty, this.SiteCnt,TotalUnitCnt, this.AvgTestTime, this.ShortName)));
                                    LotNo++;
                                    TotalUnitCnt+=lotQty;
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    }
                }
            
            }
        
        }
        
    }
    
    
    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getTestProgram() {
        return TestProgram;
    }

    public void setTestProgram(String TestProgram) {
        this.TestProgram = TestProgram;
    }

    public List<String> getProgramVersion() {
        return ProgramVersion;
    }

    public void setProgramVersion(List<String> ProgramVersion) {
        this.ProgramVersion = ProgramVersion;
    }

    public List<String> getTestCode() {
        return TestCode;
    }

    public void setTestCode(List<String> TestCode) {
        this.TestCode = TestCode;
    }


    public String getDevice() {
        return Device;
    }

    public void setDevice(String Device) {
        this.Device = Device;
    }

    public List<String> getPackage() {
        return Package;
    }

    public void setPackage(List<String> Package) {
        this.Package = Package;
    }

    public String getFacility() {
        return Facility;
    }

    public void setFacility(String Facility) {
        this.Facility = Facility;
    }

    public int getLotCnt() {
        return LotCnt;
    }

    public void setLotCnt(int LotCnt) {
        this.LotCnt = LotCnt;
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
    
    

    public List<String> getDIB() {
        return DIB;
    }

    public String getShortName() {
        return ShortName;
    }

    public int getTotalDIBCnt() {
        return TotalDIBCnt;
    }
    public int getTotalUnitCnt() {
        return TotalUnitCnt;
    }
    

    public void setTotalDIBCnt(int TotalDIBCnt) {
        this.TotalDIBCnt = TotalDIBCnt;
    }
    

    public List<Lot> getRandomLot() {
        return RandomLot;
    }
    
    private void readValue(List<String> list, Element element){
        List<Element> nodes= element.elements();
        if(!nodes.isEmpty()){
            for(Element node: nodes){
                list.add(node.getText());
            }
            
        }
            
    }
    private void printArray(List<String> list, String key){
        System.out.println(key +" :" );
        for(String temp: list){
            System.out.println("  "+ temp);
        }
        
    }
    
    public void printRandomLotHeadInfo(){
        for(Lot lot: this.RandomLot){
//            lot.getLotHeadInfo().printLotHead();
            lot.printLotInfo();
        }
    }
 
    public void printProductInfo(){
        System.out.println("ProductName: " + this.ProductName);
        System.out.println("TestProgram "+ this.TestProgram);
        printArray(this.ProgramVersion, "ProgramVersion");
        printArray(this.TestCode,"TestCode");
        System.out.println("MFGStep: "+ this.MFGStep);
        System.out.println("Device: "+ this.Device);
        printArray(this.Package,"Package");
        System.out.println("Facility: "+ this.Facility);
        System.out.println("LotCnt: "+ this.LotCnt);
        System.out.println("LotQty: "+ this.LotQty);
        System.out.println("SiteCnt: "+ this.SiteCnt);
        System.out.println("TotalUnitCnt: "+ this.TotalUnitCnt);
        
    }
    
    
    
    public static void main(String[] argc){
        int x=4;
        int z=5;
        int y=x/5;
        System.out.println(y);
        System.exit(1);
        File file = new File("./doc/product.xml");
        if(!file.exists()){
            SAXReader reader = new SAXReader();
            reader.setValidation(false);
            Document document = null;

            reader.addHandler("/products/product",new ElementHandler() {
                @Override
                public void onStart(ElementPath path) {
                }
                @Override
                public void onEnd(ElementPath path) {
                    // process a ROW element
                    Element row = path.getCurrent(); 
                    Product myProduct = new Product(row);
                    
                    myProduct.printProductInfo();
                    myProduct.printRandomLotHeadInfo();
                    // prune the tree
                    row.detach();
                }
            });
            try {
                document = reader.read(file);
            } catch (DocumentException ex) {
               Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            System.out.println("Product File is not exist");
        }
    }
}
