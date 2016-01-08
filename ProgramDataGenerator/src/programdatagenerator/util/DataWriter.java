/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programdatagenerator.util;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

    private static int Random() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
                file= new File(file.getAbsoluteFile()+"\\"+"StartLot_"+subLot.getTesterName()+"_"+ subLot.getMotherLotHead().getLotID()+"_"+getCurrentTime()+".xml");
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
    
    public static void writeUnitData(SubLot subLot){
        file = new File(Variables.logPath.getAbsoluteFile()+ "\\" +subLot.getTesterName()+"\\"+ getYYMM()+ "\\" + subLot.getMotherLotHead().getLotID());
        if(!file.exists()){
            if(!file.mkdirs())
                file=null;
        }
        if(file!=null){
            try {
                file= new File(file.getAbsoluteFile()+"\\"+"UnitData_"+subLot.getTesterName()+"_"+ subLot.getMotherLotHead().getLotID()+"_"+getCurrentTime()+".xml");
                if(file.createNewFile()){
                    writer = new XMLWriter(new FileWriter(file.getAbsolutePath()), format);
                    Document document = DocumentHelper.createDocument();
                    Element root = document.addElement( "UnitData" );
                   
                    String lotStartTime= subLot.getLotStartTime();
                    int dataSetCnt= subLot.getDataSetCnt();
                    int dataSetNo= subLot.getCurrentDataSetNo();
                    long currentTime= System.currentTimeMillis();
                    long endTime=0;
                    for(int touchDownNo=0; touchDownNo!=5 ;touchDownNo++){
                        for(int site=0;site!=subLot.getMotherLotHead().getSiteCnt();site++){
                            Element unitData= root.addElement("Unit");
                            unitData.addElement("unit_sequence").setText(Integer.toString(dataSetNo*5+ touchDownNo +1));
                            unitData.addElement("tester_number").setText(subLot.getTesterName());
                            unitData.addElement("unit_id").setText(subLot.getMotherLotHead().getShortName() + "_UnitID_" 
                                    + String.valueOf(subLot.getSubLotUnitStart()*subLot.getMotherLotHead().getSiteCnt()*5 +dataSetNo*5+ touchDownNo +1 + site ));
                            unitData.addElement("site").setText(String.valueOf(site));
                            unitData.addElement("dib_id").setText(subLot.getDIB());
                            unitData.addElement("handler_id").setText(subLot.getHandler());
                            unitData.addElement("chuck_id").setText(String.valueOf((Random()*4+1)/1 ));
                            unitData.addElement("lot_start_time").setText(lotStartTime);
                            unitData.addElement("start_test_time").setText(String.valueOf(subLot.getLastTestedTime()));
                            
                            endTime= (currentTime-subLot.getLastTestedTime())/5+ subLot.getLastTestedTime();
                            
                            unitData.addElement("end_test_time").setText(String.valueOf(endTime-2000));
                            
                            
                        }
                        subLot.setLastTestedTime(endTime);
                        
                        
                    }
                    Element unitData= root.addElement("Unit");
                    
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
                    System.out.println("successfuly create unitdata file: "+ file.getName());
                    
                }
                else
                    System.out.println("failed to create unitdata file: "+ file.getName());
            }
            catch(Exception e){
                System.out.println("failed to create unitdata file: "+ file.getName());
                e.printStackTrace();
            }
        }
        else
            System.out.println("failed to create unitdata file: "+ file.getName());
        
    }
    public class RandomResult{
        /**
        <test_result>F</test_result>
        <hard_bin>14</hard_bin>
        <hard_bin_desc>FAIL Bin 14</hard_bin_desc>
        <soft_bin>14101</soft_bin>
        <soft_bin_desc>PSShortsVdd</soft_bin_desc>
        * /
    
    }
    public static String getYYMM(){
        Calendar cal = Calendar.getInstance();
        String year = "" + cal.get(Calendar.YEAR);
        int n = cal.get(Calendar.MONTH) + 1;
//        year = year.substring(2,4); 
        String month = n<10 ? "0"+n : ""+n;
        return year + month;
    }
    public static String getCurrentTime(){
        Calendar cal = Calendar.getInstance();
        String year = "" + cal.get(Calendar.YEAR);
        int n = cal.get(Calendar.MONTH) + 1;
        int d = cal.get(Calendar.DATE);
        int h = cal.get(Calendar.HOUR_OF_DAY);
        int m = cal.get(Calendar.MINUTE);
        int s = cal.get(Calendar.SECOND);
//        year = year.substring(2,4); 
        String month = n<10 ? "0"+n : ""+n;
        String date = d<10 ? "0"+d : ""+d;
        String hour = h<10 ? "0"+h : ""+h;
        String min = m<10 ? "0"+m : ""+m;
        String sec = s<10 ? "0"+s : ""+s;
        return year + month + date  + hour + min + sec;
    }
    public static boolean openFileForWrite(boolean doAppend, String fileName, String data) {
        PrintWriter printWriter;
        boolean success =true;
         try {
            printWriter = new PrintWriter(new FileWriter(fileName, doAppend), true);
            printWriter.println(data);
            printWriter.close();
        } catch (IOException e) {
           System.out.println ("ERROR: Unable to open file "+ fileName + " for writing");
           printWriter = null;
           success=false;
        }     
         return success;
      
   }
}
