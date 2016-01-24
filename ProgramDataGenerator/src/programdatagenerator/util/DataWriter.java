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
import java.text.NumberFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.ElementHandler;
import org.dom4j.ElementPath;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import programdatagenerator.simulationdata.CamstarData;
import programdatagenerator.simulationdata.Lot;
import programdatagenerator.simulationdata.Product;
import programdatagenerator.simulationdata.SubLot;
import programdatagenerator.simulationdata.Variables;
import programdatagenerator.simulationdata.Variables.TestMode;
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
        String yymm= getYYMM();
        subLot.setLogPath(Variables.logPath.getAbsoluteFile()+ "\\" +subLot.getTesterName()+"\\"+ yymm+"\\" + subLot.getMotherLotHead().getLotID() );
        file = new File(subLot.getLogPath());
        subLot.setYYMM(yymm);
        
        if(!file.exists()){
            if(!file.mkdirs())
                file=null;
        }
        if(file!=null){
            try {
                file= new File(file.getAbsoluteFile()+"\\"+"StartLot_"+subLot.getTesterName()+"_"+ subLot.getMotherLotHead().getLotID()+"_"+subLot.getLotStartTime()+".xml");
                if(file.createNewFile()){
                    writer = new XMLWriter(new FileWriter(file.getAbsolutePath()), format);
                    Document document = DocumentHelper.createDocument();
                    Element root = document.addElement( "StartLot" );
                    
                    /*
                      <lot_number>WG46424</lot_number>
                      <tester_number>suzb2sa07a</tester_number>
                      <test_program>KV2FM2R2DA1CFS0</test_program>
                      <program_version>tsp</program_version>
                      <device>5302ALC9</device>
                      <test_mode>Fresh</test_mode>
                      <mfg_step>6260</mfg_step>
                      <test_code>GAKFNP</test_code>
                      <package>UOF906</package>
                      <handler_id>SUMC59</handler_id>
                      <dib_id>AMD_2F-KVFM2UOGC14</dib_id>
                      <lot_start_time>20160111140006</lot_start_time>
                      <lot_open_time>20160111135945</lot_open_time>
                    
                    */
                    
//                    root.addElement("LotStartTime").setText(String.valueOf(subLot.getLotStartTime()));
                    
                    root.addElement("lot_number").setText(subLot.getMotherLotHead().getLotID());
                    root.addElement("tester_number").setText(subLot.getTesterName());
                    root.addElement("test_program").setText(subLot.getMotherLotHead().getTestProgram());
                    root.addElement("program_version").setText(subLot.getMotherLotHead().getProgramVersion());
                    root.addElement("device").setText(subLot.getMotherLotHead().getDevice());
                    root.addElement("test_mode").setText(subLot.getTestMode());
                    
                    root.addElement("mfg_step").setText(subLot.getMotherLotHead().getMFGStep());
                    
                    root.addElement("test_code").setText(subLot.getMotherLotHead().getTestCode());
                    root.addElement("package").setText(subLot.getMotherLotHead().getPackage());
                    root.addElement("handler_id").setText(subLot.getHandler());
                    root.addElement("dib_id").setText(subLot.getDIB());
                    root.addElement("lot_start_time").setText(subLot.getLotStartTime());
                    root.addElement("lot_open_time").setText(subLot.getLotStartTime());
                    
                    
                    
                    writer.write(document);
                    writer.close();
                    System.out.println("successfuly create start lot file: "+ file.getName());
                    writeIndicatorFile(subLot);
                    subLot.setInTesting(true);
                    
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
    public static void writeEndLot(SubLot subLot){
        /*
        <EndLot>
        <lot_number>WG46439</lot_number>
        <tester_number>suzb2sa03a</tester_number>
        <lot_start_time>20160112015418</lot_start_time>
        <lot_end_time>20160112022308</lot_end_time>
        <total_tested_units>60</total_tested_units>
        <total_log_units>60</total_log_units>
        <end_lot_unit_sequence>30</end_lot_unit_sequence>
        <valid_lot>Y</valid_lot>
      </EndLot>
        */
         file = new File(subLot.getLogPath());
        if(!file.exists()){
            if(!file.mkdirs())
                file=null;
        }
        if(file!=null){
            try {
                file= new File(file.getAbsoluteFile()+"\\"+"EndLot_"+ subLot.getMotherLotHead().getLotID()+ "_" +subLot.getTesterName()+"_"+ subLot.getLotStartTime()+".xml");
                if(file.createNewFile()){
                    writer = new XMLWriter(new FileWriter(file.getAbsolutePath()), format);
                    Document document = DocumentHelper.createDocument();
                    Element root = document.addElement( "EndLot" );
                    
                    root.addElement("lot_number").setText(subLot.getMotherLotHead().getLotID());
                    root.addElement("tester_number").setText(subLot.getTesterName());
                    root.addElement("lot_start_time").setText(subLot.getLotStartTime());
                    root.addElement("lot_end_time").setText(getCurrentTime());
                    int totalTestedUnits=0;
                    if(subLot.isFreshLot()){
                        totalTestedUnits=subLot.getSubLotUnitCnt()*subLot.getMotherLotHead().getSiteCnt();
                    }
                    else
                        totalTestedUnits= subLot.getRejects().size();
                    root.addElement("total_tested_units").setText(String.valueOf(totalTestedUnits));
                    root.addElement("total_log_units").setText(String.valueOf(totalTestedUnits));
                    
                    root.addElement("end_lot_unit_sequence").setText(String.valueOf(subLot.getSubLotUnitCnt()));
                    root.addElement("tsp_valid_lot").setText("Y");
                    writer.write(document);
                    writer.close();
                    System.out.println("successfuly create end lot file: "+ file.getName());
                    writeIndicatorFile(subLot);
                }
            }
            catch(Exception e){}
        
        }
        // here start to generate a new sub lot
        if(!subLot.getRejects().isEmpty()&&(subLot.isFreshLot())){
             for(Product product: XMLRead.Products){
                for(Lot lot: product.getRandomLot()){
                    if(lot.getLotHeadInfo().equals(subLot.getMotherLotHead())){
                       System.out.println("generate new sublot for rejects in lot " + lot.getLotHeadInfo().getLotID());
                       lot.getSubLots().add(new SubLot(subLot.getRejects().size(), subLot.getMotherLotHead(),subLot.getRejects()));
                       for(String unitID: subLot.getRejects())
                           System.out.println("add Unit " + unitID);
                       subLot.getRejects().clear();
                    }
                }
            }
            
        }
        
        
    }
    public static void writeUnitData(SubLot subLot){
        file = new File(subLot.getLogPath());
        if(!file.exists()){
            if(!file.mkdirs())
                file=null;
        }
        if(file!=null){
            try {
                file= new File(file.getAbsoluteFile()+"\\"+"UnitData_"+subLot.getMotherLotHead().getLotID()+"_"+ subLot.getTesterName()+ "_"+getCurrentTime()+ "_"+ subLot.getLotStartTime() + ".xml");
                if(file.createNewFile()){
                    writer = new XMLWriter(new FileWriter(file.getAbsolutePath()), format);
                    Document document = DocumentHelper.createDocument();
                    Element root = document.addElement( "UnitData" );
                   
                    String lotStartTime= subLot.getLotStartTime();
                    int dataSetCnt= subLot.getDataSetCnt();
                    int dataSetNo= subLot.getCurrentDataSetNo();
                    long currentTime= System.currentTimeMillis();
                    long endTime=0;
                    int chuckID= new Random().nextInt(3);
                    int unitCnts=0;
                    int unitNoInSubLot =0;
                    for(int touchDownNo=0; touchDownNo!=5 ;touchDownNo++){
                        
                        if(!subLot.isFreshLot()||(subLot.isFreshLot() && dataSetNo*5+ touchDownNo+1<=subLot.getSubLotUnitCnt())){
                            
                            for(int site=0;site!=subLot.getMotherLotHead().getSiteCnt();site++){
                                unitNoInSubLot =(dataSetNo*5+ touchDownNo)* subLot.getMotherLotHead().getSiteCnt() + site +1;
                                if((!subLot.isFreshLot())&&(unitNoInSubLot>subLot.getRejects().size()))
                                    break;
                                if(!subLot.isFreshLot())
                                    System.out.println("re-test reject " + subLot.getRejects().get(unitNoInSubLot-1));
                                unitCnts=(dataSetNo*5+ touchDownNo+1)*subLot.getMotherLotHead().getSiteCnt();
                                if(!subLot.isFreshLot())
                                    unitCnts=unitNoInSubLot;

                                Element unitData= root.addElement("Unit");
                                unitData.addElement("unit_sequence").setText(Integer.toString(dataSetNo*5+ touchDownNo +1));
                                unitData.addElement("tester_number").setText(subLot.getTesterName());
                                String unitID=subLot.getMotherLotHead().getShortName() + "_UnitID_" 
                                        + String.valueOf(subLot.getSubLotUnitStart()*subLot.getMotherLotHead().getSiteCnt()+
                                                (dataSetNo*5+ touchDownNo)* subLot.getMotherLotHead().getSiteCnt() + site +1);
                                if(subLot.isFreshLot())
                                    unitData.addElement("unit_id").setText(unitID);
                                else
                                    unitData.addElement("unit_id").setText(subLot.getRejects().get(unitNoInSubLot-1));
                                unitData.addElement("site").setText(String.valueOf(site));
                                unitData.addElement("dib_id").setText(subLot.getDIB());
                                unitData.addElement("handler_id").setText(subLot.getHandler());
                                unitData.addElement("chuck_id").setText(String.valueOf(chuckID));
                                unitData.addElement("lot_start_time").setText(lotStartTime);
                                unitData.addElement("start_test_time").setText(String.valueOf(subLot.getLastTestedTime()));

                                endTime= (currentTime-subLot.getLastTestedTime())/5+ subLot.getLastTestedTime();

                                unitData.addElement("end_test_time").setText(String.valueOf(endTime-2000));

                                RandomResult result;
                                if(subLot.isFreshLot())
                                    result = new RandomResult(Variables.FirstYield);
                                else
                                    result = new RandomResult(Variables.RescreenYield);

                                unitData.addElement("test_result").setText(result.result);
                                unitData.addElement("hard_bin").setText(String.valueOf(result.hard_bin));
                                unitData.addElement("hard_bin_desc").setText(result.hard_bin_desc);
                                unitData.addElement("soft_bin").setText(String.valueOf(result.soft_bin));
                                unitData.addElement("soft_bin_desc").setText(result.soft_bin_desc);
                                if(subLot.isFreshLot() && result.result.equals("F")){
                                    subLot.getRejects().add(unitID);
                                }
                                
                                if(result.result.equals("P")){
                                    subLot.setTotalPassCnt(subLot.getTotalPassCnt()+1);
                                    System.out.println("total pass cnt is " + subLot.getTotalPassCnt());
                                }
                                


                            }
                            subLot.setLastTestedTime(endTime);
                        }
                        
                                                
                    }
                  
                    writer.write(document);
                    writer.close();
                    
                    subLot.setCurrentDataSetNo(subLot.getCurrentDataSetNo()+1);
//                    if(!subLot.isFreshLot())
//                        unitCnts=unitNoInSubLot;
                     
                    subLot.setTotalTestedUnits(unitCnts);
                    
                    double yield=subLot.getTotalPassCnt()/unitCnts;
                    
                    
                    NumberFormat nf = java.text.NumberFormat.getPercentInstance(); 
                    nf.setMaximumIntegerDigits(2);
                    nf.setMinimumFractionDigits(2);
               
                    subLot.setYield(nf.format(yield));
                    if(yield==1.0)
                        subLot.setYield("100.0%");
                    System.out.println("successfuly create unitdata file: "+ file.getName() + " for " + subLot.getCurrentDataSetNo() + "/" + subLot.getDataSetCnt() + " yield = " +yield );
                    if(Variables.simulationMode.equals(TestMode.realTime))
                        writeIndicatorFile(subLot);
                    
                }
                else
                    System.out.println("failed to create unitdata file: "+ file.getName());
            }
            catch(Exception e){
                System.out.println("failed to create unitdata file: "+ file.getName());
                e.printStackTrace();
            }
            
            if(subLot.getCurrentDataSetNo()==subLot.getDataSetCnt()){
                try {
                    Thread.sleep(2000);
                    writeEndLot(subLot);
                    subLot.setTestCompleted(true);
                    subLot.setInTesting(false);
                   
                    if(isMotherLotCompleted(subLot)){
                        if(Variables.UpdateCamStar){
                            new CamstarData(subLot.getMotherLotHead().getLotID(),
                            subLot.getMotherLotHead().getTestProgram(),
                            subLot.getMotherLotHead().getProgramVersion(),
                            subLot.getMotherLotHead().getPackage(),
                            subLot.getMotherLotHead().getDevice(),
                            subLot.getMotherLotHead().getTestCode(),
                            subLot.getMotherLotHead().getMFGStep(),
                            subLot.getTotalTestedUnits().getValue().toString(),
                            String.valueOf(subLot.getTotalPassCnt().intValue())).insertCamStarData();
                        }
                    }
                    
//                writeIndicatorFile(subLot);
                } catch (InterruptedException ex) {
                    Logger.getLogger(DataWriter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else
            System.out.println("failed to create unitdata file: "+ subLot.getLogPath());
        
    }
    public static void writeIndicatorFile(SubLot subLot){
        File file = new File(Variables.logPath+ "//" +"LotList");
        if(!file.exists()){
            if(!file.mkdirs())
                file=null;
        }
        File[] files;
        if(file!=null){
            files= file.listFiles();
            boolean find=false;
            int dirCnt=0;
            for(int loopNo = files.length-1;loopNo!=-1;loopNo--){
                File dir= files[loopNo];
                if(dir.isDirectory()){
                    System.out.print("dir name is "+ dir.getName());
                    dirCnt+=1;
                    if(dir.listFiles().length<10){
                        find=true;
                        System.out.println("find == true");
                        file=dir;
                        break;
                    }
                    else
                        System.out.println(", but it's too large");
                }
                    
            }
            if(!find){
                if(dirCnt==0){
                    file= new File(Variables.logPath+ "//" +"LotList" + "//" + "default");
                }
                else{
                    file= new File(Variables.logPath+ "//" +"LotList" + "//" +getCurrentTime() );
                } 
            }
            if(!file.exists()){
                if(!file.mkdirs())
                    System.out.println("failed to create log indicator file ");
            }
                try {
                    file=new File(file.getAbsolutePath() +"//" + subLot.getTesterName() +"_"
                            + subLot.getYYMM()+ "_" + subLot.getMotherLotHead().getLotID()+"_"+getCurrentTime()+".xml");
                    file.createNewFile();
                    System.out.println("successfuly create log indicator file "+ file.getName());
                } catch (IOException ex) {
                    System.out.println("failed to create log indicator file ");
                    Logger.getLogger(DataWriter.class.getName()).log(Level.SEVERE, null, ex);
                }
            
          
        }
        else{
            System.out.println("failed to create log indicator file");
        }
    }
    public static class RandomResult{
        /*
        <test_result>F</test_result>
        <hard_bin>14</hard_bin>
        <hard_bin_desc>FAIL Bin 14</hard_bin_desc>
        <soft_bin>14101</soft_bin>
        <soft_bin_desc>PSShortsVdd</soft_bin_desc>
        
        */
        public String result=null;
        public int hard_bin=0;
        public int soft_bin=0;
        public String hard_bin_desc=null;
        public String soft_bin_desc=null;

        public RandomResult(double yield) {
            double value= new Random().nextDouble();
            if(value>yield){
                this.result="F";
                this.hard_bin= 13+ new Random().nextInt(3);
                this.soft_bin= 60+ new Random().nextInt(10);
                this.soft_bin= this.hard_bin*1000+ this.soft_bin;
                this.soft_bin_desc="Fail Unit, Hard Bin " + this.hard_bin + " soft bin " + this.soft_bin;
                this.hard_bin_desc="Fail Unit, Hard Bin " + this.hard_bin;
            }
            else{
                this.result="P";
                this.hard_bin= 1+ new Random().nextInt(3);
                this.soft_bin= 80+ new Random().nextInt(8);
                this.soft_bin= this.hard_bin*1000+ this.soft_bin;
                this.soft_bin_desc="Good Unit, Hard Bin " + this.hard_bin + " soft bin " + this.soft_bin;
                this.hard_bin_desc="Good Unit, Hard Bin " + this.hard_bin;
            }
        }
        
        
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
    
    public static boolean isMotherLotCompleted(SubLot subLot){
        boolean complted=true;
        if(!subLot.isTestCompleted())
            return false;
        else{
            for(Product product: XMLRead.Products){
                for(Lot lot: product.getRandomLot()){
                    if(lot.getLotHeadInfo().equals(subLot.getMotherLotHead())){
                        System.out.println("check lot status .................");
                        lot.printLotInfo();
                        for(SubLot _subLot: lot.getSubLots() ){
//                            System.out.println("check sub lot status...");
                            if(!_subLot.isTestCompleted()){
                                complted=false;
                                break;
                            }
//                            System.out.println("check sub lot status "+ subLot.getMotherLotHead().getLotID() +" : "
//                            + subLot.isTestCompleted());
                        }
                        if(complted){
                            lot.setTestCompleted(true);
                            System.out.println("mother lot " + lot.getLotHeadInfo().getLotID() + " testing completed");
                            lot.getStatus().setValue("Tesing completed");
                            product.getTotalTestedUnits().setValue(String.valueOf(Long.parseLong(product.getTotalTestedUnits().getValue())+lot.getLotHeadInfo().getLotQty()*lot.getLotHeadInfo().getSiteCnt()));
                        }
                        else{
                            System.out.println("mother lot " + lot.getLotHeadInfo().getLotID() + " testing incompleted");
                        }
                        break;    
                    }
                }
            }
            return complted;
        }
    }
}
