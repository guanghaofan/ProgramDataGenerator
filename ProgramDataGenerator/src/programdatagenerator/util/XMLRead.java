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

/**
 *
 * @author ghfan
 */
public class XMLRead {

    public XMLRead() {
    }
    public static List<Product> getProducts(){
        final List<Product> products;
        products = new ArrayList<>();
        
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
                    myProduct.print();
                    products.add(myProduct);
                    row.detach();
                }
            });
            try {
                document = reader.read(file);
                return products;
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
