/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programdatagenerator.simulationdata;

import java.io.File;

/**
 *
 * @author ghfan
 */
public class Variables {
    public static File logPath=null;
    public enum TesterStatus{Testing, Paused, Idle,Completed};
    public enum TestMode{fast, realTime};
    public static TestMode simulationMode=TestMode.fast;
    public static double FirstYield=0.90;
    public static double RescreenYield=0.5;
    public static double FinalYield=0.98;
    public static int TesterCnt=12;
      
}
