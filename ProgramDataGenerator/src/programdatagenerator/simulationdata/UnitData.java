/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programdatagenerator.simulationdata;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Administrator
 */
public class UnitData {
    
    class unit{
        private int Sequence=0;
        private String UnitID =null;
        private Double TestTime=0.1;
        private Double IndexTime=0.0;
        private char BinType ='P';
        private int HardBin=0;
        private int SoftBin=0;
        private String HardBinDes=null;
        private String SoftBinDes=null;
        private int ChuckID =0;

        public unit( ) {
        }
        public void enerateUnit(int sequence){
            this.Sequence=sequence;
            this.UnitID="Unit_" + this.Sequence;
            this.TestTime=randomTestTime();
            this.IndexTime=randomIndexTime();
            randomTestResult();
        }
        
        private Double randomTestTime(){
            return (new Random().nextDouble())*5+10;
        
        }
        private Double randomIndexTime(){
            return (new Random().nextDouble())+3;
        
        }
        private void randomTestResult(){
            if(new Random().nextDouble()>0.9){
                this.BinType='P';
                this.HardBin=1;
            }
            else if(new Random().nextDouble()>0.9){
                this.BinType='P';
                this.HardBin=2;
            }
            else if(new Random().nextDouble()>0.7){
                this.BinType='P';
                this.HardBin=3;
            }
            else if(new Random().nextDouble()>0.6){
                this.BinType='P';
                this.HardBin=1;
            }
            else if(new Random().nextDouble()>0.5){
                this.BinType='P';
                this.HardBin=2;
            }
            else if(new Random().nextDouble()>0.4){
                this.BinType='P';
                this.HardBin=3;
            }
            else if(new Random().nextDouble()>0.3){
                this.BinType='F';
                this.HardBin=1;
            }
            else if(new Random().nextDouble()>0.2){
                this.BinType='F';
                this.HardBin=13;
            }
            else if(new Random().nextDouble()>0.1){
                this.BinType='F';
                this.HardBin=14;
            }
            else{
                this.BinType='F';
                this.HardBin=15;
            }
            
            int SoftBin= new Random().nextInt(10);
            this.SoftBin=this.HardBin*1000 + SoftBin;
            if(this.BinType=='P'){
                this.HardBinDes="Good HardBin "+ this.HardBin;
                this.SoftBinDes= this.HardBinDes + " ,SoftBin " + SoftBin;
            }
            else{
                this.HardBinDes="Bad HardBin "+ this.HardBin;
                this.SoftBinDes= this.HardBinDes + " ,SoftBin " + SoftBin;
            }
            
            this.ChuckID=new Random().nextInt(3)+2;
            
        
        }

        public int getChuckID() {
            return ChuckID;
        }

        public int getHardBin() {
            return HardBin;
        }

        public String getHardBinDes() {
            return HardBinDes;
        }

        public Double getIndexTime() {
            return IndexTime;
        }

        public int getSequence() {
            return Sequence;
        }

        public int getSoftBin() {
            return SoftBin;
        }

        public String getSoftBinDes() {
            return SoftBinDes;
        }

        public char getTestResult() {
            return BinType;
        }

        public Double getTestTime() {
            return TestTime;
        }

        public String getUnitID() {
            return UnitID;
        }

        public void setChuckID(int ChuckID) {
            this.ChuckID = ChuckID;
        }

        public void setHardBin(int HardBin) {
            this.HardBin = HardBin;
        }

        public void setHardBinDes(String HardBinDes) {
            this.HardBinDes = HardBinDes;
        }

        public void setIndexTime(Double IndexTime) {
            this.IndexTime = IndexTime;
        }

        public void setSequence(int Sequence) {
            this.Sequence = Sequence;
        }

        public void setSoftBin(int SoftBin) {
            this.SoftBin = SoftBin;
        }

        public void setSoftBinDes(String SoftBinDes) {
            this.SoftBinDes = SoftBinDes;
        }

        public void setTestResult(char TestResult) {
            this.BinType = TestResult;
        }

        public void setTestTime(Double TestTime) {
            this.TestTime = TestTime;
        }

        public void setUnitID(String UnitID) {
            this.UnitID = UnitID;
        }
    }
    
}
