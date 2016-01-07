/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programdatagenerator.util;
import java.io.File;
import java.io.FileWriter;
import java.time.Year;
import java.util.Calendar;
    import org.dom4j.Document;
    import org.dom4j.DocumentException;
    import org.dom4j.DocumentHelper;
    import org.dom4j.Element;
    import org.dom4j.ElementHandler;
    import org.dom4j.ElementPath;
    import org.dom4j.io.OutputFormat;
    import org.dom4j.io.SAXReader;
    import org.dom4j.io.XMLWriter;
import programdatagenerator.simulationdata.SubLot;
import programdatagenerator.simulationdata.Variables;
/**
 *
 * @author Administrator
 */
public class DataWriter {
    public static  OutputFormat format= OutputFormat.createPrettyPrint();
        
    public static XMLWriter writer;
    public static File file;

    public DataWriter() {
        format.setIndent(true);
        format.setIndentSize(2);
    }
    public static void writeStartLot(SubLot subLot){
        file = new File(Variables.logPath.getAbsoluteFile()+ "\\" +subLot.getTesterName()+"\\"+ getYYMM()+ "\\" + subLot.getMotherLotHead().getLotID());
        if(!file.exists()){
            if(!file.mkdirs())
                file=null;
        }
        if(file!=null){
               
            try {
                file= new File(file.getAbsoluteFile()+"\\"+"StartLot_"+subLot.getTesterName()+"_"+ subLot.getMotherLotHead().getLotID()+"_"+System.currentTimeMillis()+".xml");
                if(file.createNewFile()){
                    writer = new XMLWriter(new FileWriter(file.getAbsolutePath()), format);
                    Document document = DocumentHelper.createDocument();
                    Element root = document.addElement( "StartLot" );
                    root.addElement("LotStartTime").setText(String.valueOf(subLot.getLotStartTime()));
                    root.addElement("lot_number").setText(subLot.getMotherLotHead().getLotID());
                    root.addElement("tester_number").setText(subLot.getTesterName());
                    root.addElement("handler").setText(subLot.getHandler());
                    root.addElement("device").setText(subLot.getMotherLotHead().getDevice());
                    root.addElement("test_code").setText(subLot.getMotherLotHead().getTestCode());
                    root.addElement("test_program").setText(subLot.getMotherLotHead().getTestProgram());
                    root.addElement("program_version").setText(subLot.getMotherLotHead().getProgramVersion());
                    writer.write(document);
                    writer.close();
                    System.out.println("successfuly create start lot file: "+ file.getName());
                }
                else
                    System.out.println("failed to create start lot file: "+ file.getName());
            }
            catch(Exception e){
                System.out.println("failed to create start lot file: "+ file.getName());
                e.printStackTrace();
            }
        }
        else
            System.out.println("failed to create start lot file: "+ file.getName());
    }
    
    public static String getYYMM(){
    return "201601";
        
        
     
    }
}
