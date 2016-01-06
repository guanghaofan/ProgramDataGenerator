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
import programdatagenerator.simulationdata.Product;
import programdatagenerator.simulationdata.Variables;

/**
 *
 * @author ghfan
 */
public class XMLRead {
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
    
    
 
}
