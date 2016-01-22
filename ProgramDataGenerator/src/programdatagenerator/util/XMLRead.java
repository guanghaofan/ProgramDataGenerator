/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programdatagenerator.util;

import java.io.File;
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
import programdatagenerator.simulationdata.Lot;
import programdatagenerator.simulationdata.Product;
import programdatagenerator.simulationdata.SubLot;
import programdatagenerator.simulationdata.Variables;

/**
 *
 * @author ghfan
 */
public class XMLRead {
    public static String CurrentProduct= null;
    public static final List<Product> Products = new ArrayList<>();

    public XMLRead() {
    }
    public static List<Product> readProducts(){
        
        File file = new File("./doc/product.xml");
        if(file.exists()){
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
                    Products.add(myProduct);
                    row.detach();
                }
            });
            reader.addHandler("/products/FirstYield",new ElementHandler() {
                @Override
                public void onStart(ElementPath path) {
                }
                @Override
                public void onEnd(ElementPath path) {
                    // process a ROW element
                    Element row = path.getCurrent(); 
                    if(row.getText()!=null)
                        Variables.FirstYield=Double.valueOf(row.getText());
                    row.detach();
                }
            });
            reader.addHandler("/products/TesterCnt",new ElementHandler() {
                @Override
                public void onStart(ElementPath path) {
                }
                @Override
                public void onEnd(ElementPath path) {
                    // process a ROW element
                    Element row = path.getCurrent(); 
                    if(row.getText()!=null)
                        Variables.TesterCnt=Integer.valueOf(row.getText());
                    row.detach();
                }
            });
            reader.addHandler("/products/RescreenYield",new ElementHandler() {
                @Override
                public void onStart(ElementPath path) {
                }
                @Override
                public void onEnd(ElementPath path) {
                    // process a ROW element
                    Element row = path.getCurrent(); 
                    if(row.getText()!=null)
                        Variables.RescreenYield=Double.valueOf(row.getText());
                    row.detach();
                }
            });
            reader.addHandler("/products/FinalYield",new ElementHandler() {
                @Override
                public void onStart(ElementPath path) {
                }
                @Override
                public void onEnd(ElementPath path) {
                    // process a ROW element
                    Element row = path.getCurrent(); 
                    if(row.getText()!=null)
                        Variables.FinalYield=Double.valueOf(row.getText());
                    row.detach();
                }
            });
            reader.addHandler("/products/logPath",new ElementHandler() {
                @Override
                public void onStart(ElementPath path) {
                }
                @Override
                public void onEnd(ElementPath path) {
                    // process a ROW element
                    Element row = path.getCurrent();                    
                    if(row.getText()!=null){
                        File logPath= new File(row.getText());
                        if((!logPath.isDirectory())&& (!logPath.exists())){
                            if(logPath.mkdirs())
                                Variables.logPath = logPath;
                            else
                                Variables.logPath = null;
                        }
                        else
                            Variables.logPath=logPath;
                    }
               
                    row.detach();
                }
            });
            
            reader.addHandler("/products/testMode",new ElementHandler() {
                @Override
                public void onStart(ElementPath path) {
                }
                @Override
                public void onEnd(ElementPath path) {
                    // process a ROW element
                    Element row = path.getCurrent();                    
                    if(row.getText()!=null && row.getText().equalsIgnoreCase("fast")){
                        Variables.simulationMode=Variables.TestMode.fast;
                    }
                    else
                        Variables.simulationMode=Variables.TestMode.realTime;
               
                    row.detach();
                }
            });
            reader.addHandler("/products/UpdateCamStar",new ElementHandler() {
                @Override
                public void onStart(ElementPath path) {
                }
                @Override
                public void onEnd(ElementPath path) {
                    // process a ROW element
                    Element row = path.getCurrent();                    
                    if(row.getText()!=null && row.getText().equalsIgnoreCase("true")){
                        Variables.UpdateCamStar=true;
                    }
           
                    row.detach();
                }
            });
            try {
                document = reader.read(file);
                return Products;
            } catch (DocumentException ex) {
               Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
               return null;
            }
        }
        else{
            System.out.println("Product File is not exist");
            return null;
        }
    }
    
    public static SubLot getNextSubLot(){
        String lotID=null;
        if(CurrentProduct!=null){
            System.out.println("Previous Product is: " + CurrentProduct);
            for(int i=0; i!= Products.size();i++){
                if(Products.get(i).getProductName().equals(CurrentProduct)){
                    if(i==Products.size()-1)
                        CurrentProduct=Products.get(0).getProductName();
                    else
                        CurrentProduct=Products.get(i+1).getProductName();
                    break;
                }
                    
            }
            System.out.println("get product for next lot: " + CurrentProduct);
        }
        else{
           
            CurrentProduct=Products.get(0).getProductName();
             System.out.println("this is the first time for testing, so choose the first product: " + CurrentProduct);
        
        }
        boolean getLot=false;
        for(Product product: Products){
            if(product.getProductName().equals(CurrentProduct)){
                for(Lot lot: product.getRandomLot()){
                    if(!lot.isTestCompleted()){
                        // which means a new lot still waiting for test
                       
                        lotID=lot.getLotHeadInfo().getLotID();
                        System.out.println("get next lot: " + lot.getLotHeadInfo().getLotID() + " for product " + CurrentProduct);
                        
                        for(SubLot subLot:lot.getSubLots()){
                            if((!subLot.isTestCompleted())&&(!subLot.isInTesting())&& subLot.isReadForTesting()){
                                getLot=true;
                                if(!subLot.isFreshLot()){
                                    System.out.println("succesfully get next rescreen sub lot ");
                                    for(String unitID: subLot.getRejects())
                                        System.out.println("unit "  + unitID);
                                    System.out.println("total units cnt " + subLot.getSubLotUnitCnt());
                                    System.out.println("data set count " + subLot.getDataSetCnt());
                                }
                                return subLot;
                            }
                        
                        }
                       
                    }
                }   
            }
        }
        return null;
        
  
    }
    
 
}
