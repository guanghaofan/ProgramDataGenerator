/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programdatagenerator.simulationdata;

import java.io.Serializable;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.jaxen.FunctionContext;

/**
 *
 * @author ghfan
 */
@Entity
@Table(name = "camstar_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CamstarData.findAll", query = "SELECT c FROM CamstarData c"),
    @NamedQuery(name = "CamstarData.findById", query = "SELECT c FROM CamstarData c WHERE c.id = :id"),
    @NamedQuery(name = "CamstarData.findByCamPline", query = "SELECT c FROM CamstarData c WHERE c.camPline = :camPline"),
    @NamedQuery(name = "CamstarData.findByCamType", query = "SELECT c FROM CamstarData c WHERE c.camType = :camType"),
    @NamedQuery(name = "CamstarData.findByCamInsert", query = "SELECT c FROM CamstarData c WHERE c.camInsert = :camInsert"),
    @NamedQuery(name = "CamstarData.findByCamDevice", query = "SELECT c FROM CamstarData c WHERE c.camDevice = :camDevice"),
    @NamedQuery(name = "CamstarData.findByCamPackage", query = "SELECT c FROM CamstarData c WHERE c.camPackage = :camPackage"),
    @NamedQuery(name = "CamstarData.findByCamLot", query = "SELECT c FROM CamstarData c WHERE c.camLot = :camLot"),
    @NamedQuery(name = "CamstarData.findByCamOper", query = "SELECT c FROM CamstarData c WHERE c.camOper = :camOper"),
    @NamedQuery(name = "CamstarData.findByCamMother", query = "SELECT c FROM CamstarData c WHERE c.camMother = :camMother"),
    @NamedQuery(name = "CamstarData.findByCamTester", query = "SELECT c FROM CamstarData c WHERE c.camTester = :camTester"),
    @NamedQuery(name = "CamstarData.findByCamTcode", query = "SELECT c FROM CamstarData c WHERE c.camTcode = :camTcode"),
    @NamedQuery(name = "CamstarData.findByCamTprog", query = "SELECT c FROM CamstarData c WHERE c.camTprog = :camTprog"),
    @NamedQuery(name = "CamstarData.findByCamTrev", query = "SELECT c FROM CamstarData c WHERE c.camTrev = :camTrev"),
    @NamedQuery(name = "CamstarData.findByCamQtyin", query = "SELECT c FROM CamstarData c WHERE c.camQtyin = :camQtyin"),
    @NamedQuery(name = "CamstarData.findByCamQtyout", query = "SELECT c FROM CamstarData c WHERE c.camQtyout = :camQtyout"),
    @NamedQuery(name = "CamstarData.findByCamYield", query = "SELECT c FROM CamstarData c WHERE c.camYield = :camYield"),
    @NamedQuery(name = "CamstarData.findByCamRej1", query = "SELECT c FROM CamstarData c WHERE c.camRej1 = :camRej1"),
    @NamedQuery(name = "CamstarData.findByCamRej2", query = "SELECT c FROM CamstarData c WHERE c.camRej2 = :camRej2"),
    @NamedQuery(name = "CamstarData.findByCamRej3", query = "SELECT c FROM CamstarData c WHERE c.camRej3 = :camRej3"),
    @NamedQuery(name = "CamstarData.findByCamRej4", query = "SELECT c FROM CamstarData c WHERE c.camRej4 = :camRej4"),
    @NamedQuery(name = "CamstarData.findByCamRej5", query = "SELECT c FROM CamstarData c WHERE c.camRej5 = :camRej5"),
    @NamedQuery(name = "CamstarData.findByCamRej6", query = "SELECT c FROM CamstarData c WHERE c.camRej6 = :camRej6"),
    @NamedQuery(name = "CamstarData.findByCamRej7", query = "SELECT c FROM CamstarData c WHERE c.camRej7 = :camRej7"),
    @NamedQuery(name = "CamstarData.findByCamRej8", query = "SELECT c FROM CamstarData c WHERE c.camRej8 = :camRej8"),
    @NamedQuery(name = "CamstarData.findByCamRej9", query = "SELECT c FROM CamstarData c WHERE c.camRej9 = :camRej9"),
    @NamedQuery(name = "CamstarData.findByCamRej10", query = "SELECT c FROM CamstarData c WHERE c.camRej10 = :camRej10"),
    @NamedQuery(name = "CamstarData.findByCamRej11", query = "SELECT c FROM CamstarData c WHERE c.camRej11 = :camRej11"),
    @NamedQuery(name = "CamstarData.findByCamRej12", query = "SELECT c FROM CamstarData c WHERE c.camRej12 = :camRej12"),
    @NamedQuery(name = "CamstarData.findByCamRej13", query = "SELECT c FROM CamstarData c WHERE c.camRej13 = :camRej13"),
    @NamedQuery(name = "CamstarData.findByCamRej14", query = "SELECT c FROM CamstarData c WHERE c.camRej14 = :camRej14"),
    @NamedQuery(name = "CamstarData.findByCamRej15", query = "SELECT c FROM CamstarData c WHERE c.camRej15 = :camRej15"),
    @NamedQuery(name = "CamstarData.findByCamRej16", query = "SELECT c FROM CamstarData c WHERE c.camRej16 = :camRej16"),
    @NamedQuery(name = "CamstarData.findByCamRejoth", query = "SELECT c FROM CamstarData c WHERE c.camRejoth = :camRejoth"),
    @NamedQuery(name = "CamstarData.findByCamHandler", query = "SELECT c FROM CamstarData c WHERE c.camHandler = :camHandler"),
    @NamedQuery(name = "CamstarData.findByCamPartname", query = "SELECT c FROM CamstarData c WHERE c.camPartname = :camPartname"),
    @NamedQuery(name = "CamstarData.findByCamOpn", query = "SELECT c FROM CamstarData c WHERE c.camOpn = :camOpn"),
    @NamedQuery(name = "CamstarData.findByCamFablotnumber", query = "SELECT c FROM CamstarData c WHERE c.camFablotnumber = :camFablotnumber"),
    @NamedQuery(name = "CamstarData.findByCamAssemblyPart", query = "SELECT c FROM CamstarData c WHERE c.camAssemblyPart = :camAssemblyPart"),
    @NamedQuery(name = "CamstarData.findByCamAspen", query = "SELECT c FROM CamstarData c WHERE c.camAspen = :camAspen"),
    @NamedQuery(name = "CamstarData.findByCamTestPhase", query = "SELECT c FROM CamstarData c WHERE c.camTestPhase = :camTestPhase"),
    @NamedQuery(name = "CamstarData.findByCamReclaimCount", query = "SELECT c FROM CamstarData c WHERE c.camReclaimCount = :camReclaimCount"),
    @NamedQuery(name = "CamstarData.findByCamNr1", query = "SELECT c FROM CamstarData c WHERE c.camNr1 = :camNr1"),
    @NamedQuery(name = "CamstarData.findByCamNr2", query = "SELECT c FROM CamstarData c WHERE c.camNr2 = :camNr2"),
    @NamedQuery(name = "CamstarData.findByCamNr3", query = "SELECT c FROM CamstarData c WHERE c.camNr3 = :camNr3"),
    @NamedQuery(name = "CamstarData.findByCamNr4", query = "SELECT c FROM CamstarData c WHERE c.camNr4 = :camNr4"),
    @NamedQuery(name = "CamstarData.findByCamNr5", query = "SELECT c FROM CamstarData c WHERE c.camNr5 = :camNr5"),
    @NamedQuery(name = "CamstarData.findByCamNr6", query = "SELECT c FROM CamstarData c WHERE c.camNr6 = :camNr6"),
    @NamedQuery(name = "CamstarData.findByCamNr7", query = "SELECT c FROM CamstarData c WHERE c.camNr7 = :camNr7"),
    @NamedQuery(name = "CamstarData.findByCamNr8", query = "SELECT c FROM CamstarData c WHERE c.camNr8 = :camNr8"),
    @NamedQuery(name = "CamstarData.findByCamNr9", query = "SELECT c FROM CamstarData c WHERE c.camNr9 = :camNr9"),
    @NamedQuery(name = "CamstarData.findByCamNr10", query = "SELECT c FROM CamstarData c WHERE c.camNr10 = :camNr10"),
    @NamedQuery(name = "CamstarData.findByCamNr11", query = "SELECT c FROM CamstarData c WHERE c.camNr11 = :camNr11"),
    @NamedQuery(name = "CamstarData.findByCamNr12", query = "SELECT c FROM CamstarData c WHERE c.camNr12 = :camNr12"),
    @NamedQuery(name = "CamstarData.findByCamNr13", query = "SELECT c FROM CamstarData c WHERE c.camNr13 = :camNr13"),
    @NamedQuery(name = "CamstarData.findByCamNr14", query = "SELECT c FROM CamstarData c WHERE c.camNr14 = :camNr14"),
    @NamedQuery(name = "CamstarData.findByCamNr15", query = "SELECT c FROM CamstarData c WHERE c.camNr15 = :camNr15"),
    @NamedQuery(name = "CamstarData.findByCamNr16", query = "SELECT c FROM CamstarData c WHERE c.camNr16 = :camNr16"),
    @NamedQuery(name = "CamstarData.findByCamVm1", query = "SELECT c FROM CamstarData c WHERE c.camVm1 = :camVm1"),
    @NamedQuery(name = "CamstarData.findByCamVm2", query = "SELECT c FROM CamstarData c WHERE c.camVm2 = :camVm2"),
    @NamedQuery(name = "CamstarData.findByCamVm3", query = "SELECT c FROM CamstarData c WHERE c.camVm3 = :camVm3"),
    @NamedQuery(name = "CamstarData.findByCamVm4", query = "SELECT c FROM CamstarData c WHERE c.camVm4 = :camVm4"),
    @NamedQuery(name = "CamstarData.findByCamVm5", query = "SELECT c FROM CamstarData c WHERE c.camVm5 = :camVm5"),
    @NamedQuery(name = "CamstarData.findByCamVm6", query = "SELECT c FROM CamstarData c WHERE c.camVm6 = :camVm6"),
    @NamedQuery(name = "CamstarData.findByCamVm7", query = "SELECT c FROM CamstarData c WHERE c.camVm7 = :camVm7"),
    @NamedQuery(name = "CamstarData.findByCamVm8", query = "SELECT c FROM CamstarData c WHERE c.camVm8 = :camVm8"),
    @NamedQuery(name = "CamstarData.findByCamVm9", query = "SELECT c FROM CamstarData c WHERE c.camVm9 = :camVm9"),
    @NamedQuery(name = "CamstarData.findByCamVm10", query = "SELECT c FROM CamstarData c WHERE c.camVm10 = :camVm10"),
    @NamedQuery(name = "CamstarData.findByCamVm11", query = "SELECT c FROM CamstarData c WHERE c.camVm11 = :camVm11"),
    @NamedQuery(name = "CamstarData.findByCamVm12", query = "SELECT c FROM CamstarData c WHERE c.camVm12 = :camVm12"),
    @NamedQuery(name = "CamstarData.findByCamVm13", query = "SELECT c FROM CamstarData c WHERE c.camVm13 = :camVm13"),
    @NamedQuery(name = "CamstarData.findByCamVm14", query = "SELECT c FROM CamstarData c WHERE c.camVm14 = :camVm14"),
    @NamedQuery(name = "CamstarData.findByCamVm15", query = "SELECT c FROM CamstarData c WHERE c.camVm15 = :camVm15"),
    @NamedQuery(name = "CamstarData.findByCamVm16", query = "SELECT c FROM CamstarData c WHERE c.camVm16 = :camVm16")})
public class CamstarData implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "cam_pline")
    private String camPline;
    @Basic(optional = false)
    @Column(name = "cam_type")
    private String camType;
    @Basic(optional = false)
    @Column(name = "cam_insert")
    private String camInsert;
    @Basic(optional = false)
    @Column(name = "cam_device")
    private String camDevice;
    @Basic(optional = false)
    @Column(name = "cam_package")
    private String camPackage;
    @Basic(optional = false)
    @Column(name = "cam_lot")
    private String camLot;
    @Basic(optional = false)
    @Column(name = "cam_oper")
    private String camOper;
    @Basic(optional = false)
    @Column(name = "cam_mother")
    private String camMother;
    @Basic(optional = false)
    @Column(name = "cam_tester")
    private String camTester;
    @Basic(optional = false)
    @Column(name = "cam_tcode")
    private String camTcode;
    @Basic(optional = false)
    @Column(name = "cam_tprog")
    private String camTprog;
    @Basic(optional = false)
    @Column(name = "cam_trev")
    private String camTrev;
    @Basic(optional = false)
    @Column(name = "cam_qtyin")
    private String camQtyin;
    @Basic(optional = false)
    @Column(name = "cam_qtyout")
    private String camQtyout;
    @Basic(optional = false)
    @Column(name = "cam_yield")
    private String camYield;
    @Basic(optional = false)
    @Column(name = "cam_rej1")
    private String camRej1;
    @Basic(optional = false)
    @Column(name = "cam_rej2")
    private String camRej2;
    @Basic(optional = false)
    @Column(name = "cam_rej3")
    private String camRej3;
    @Basic(optional = false)
    @Column(name = "cam_rej4")
    private String camRej4;
    @Basic(optional = false)
    @Column(name = "cam_rej5")
    private String camRej5;
    @Basic(optional = false)
    @Column(name = "cam_rej6")
    private String camRej6;
    @Basic(optional = false)
    @Column(name = "cam_rej7")
    private String camRej7;
    @Basic(optional = false)
    @Column(name = "cam_rej8")
    private String camRej8;
    @Basic(optional = false)
    @Column(name = "cam_rej9")
    private String camRej9;
    @Basic(optional = false)
    @Column(name = "cam_rej10")
    private String camRej10;
    @Basic(optional = false)
    @Column(name = "cam_rej11")
    private String camRej11;
    @Basic(optional = false)
    @Column(name = "cam_rej12")
    private String camRej12;
    @Basic(optional = false)
    @Column(name = "cam_rej13")
    private String camRej13;
    @Basic(optional = false)
    @Column(name = "cam_rej14")
    private String camRej14;
    @Basic(optional = false)
    @Column(name = "cam_rej15")
    private String camRej15;
    @Basic(optional = false)
    @Column(name = "cam_rej16")
    private String camRej16;
    @Basic(optional = false)
    @Column(name = "cam_rejoth")
    private String camRejoth;
    @Basic(optional = false)
    @Column(name = "cam_handler")
    private String camHandler;
    @Basic(optional = false)
    @Column(name = "cam_partname")
    private String camPartname;
    @Basic(optional = false)
    @Column(name = "cam_opn")
    private String camOpn;
    @Basic(optional = false)
    @Column(name = "cam_fablotnumber")
    private String camFablotnumber;
    @Basic(optional = false)
    @Column(name = "cam_assembly_part")
    private String camAssemblyPart;
    @Basic(optional = false)
    @Column(name = "cam_aspen")
    private String camAspen;
    @Basic(optional = false)
    @Column(name = "cam_test_phase")
    private String camTestPhase;
    @Basic(optional = false)
    @Column(name = "cam_reclaim_count")
    private String camReclaimCount;
    @Basic(optional = false)
    @Column(name = "cam_nr1")
    private String camNr1;
    @Basic(optional = false)
    @Column(name = "cam_nr2")
    private String camNr2;
    @Basic(optional = false)
    @Column(name = "cam_nr3")
    private String camNr3;
    @Basic(optional = false)
    @Column(name = "cam_nr4")
    private String camNr4;
    @Basic(optional = false)
    @Column(name = "cam_nr5")
    private String camNr5;
    @Basic(optional = false)
    @Column(name = "cam_nr6")
    private String camNr6;
    @Basic(optional = false)
    @Column(name = "cam_nr7")
    private String camNr7;
    @Basic(optional = false)
    @Column(name = "cam_nr8")
    private String camNr8;
    @Basic(optional = false)
    @Column(name = "cam_nr9")
    private String camNr9;
    @Basic(optional = false)
    @Column(name = "cam_nr10")
    private String camNr10;
    @Basic(optional = false)
    @Column(name = "cam_nr11")
    private String camNr11;
    @Basic(optional = false)
    @Column(name = "cam_nr12")
    private String camNr12;
    @Basic(optional = false)
    @Column(name = "cam_nr13")
    private String camNr13;
    @Basic(optional = false)
    @Column(name = "cam_nr14")
    private String camNr14;
    @Basic(optional = false)
    @Column(name = "cam_nr15")
    private String camNr15;
    @Basic(optional = false)
    @Column(name = "cam_nr16")
    private String camNr16;
    @Basic(optional = false)
    @Column(name = "cam_vm1")
    private String camVm1;
    @Basic(optional = false)
    @Column(name = "cam_vm2")
    private String camVm2;
    @Basic(optional = false)
    @Column(name = "cam_vm3")
    private String camVm3;
    @Basic(optional = false)
    @Column(name = "cam_vm4")
    private String camVm4;
    @Basic(optional = false)
    @Column(name = "cam_vm5")
    private String camVm5;
    @Basic(optional = false)
    @Column(name = "cam_vm6")
    private String camVm6;
    @Basic(optional = false)
    @Column(name = "cam_vm7")
    private String camVm7;
    @Basic(optional = false)
    @Column(name = "cam_vm8")
    private String camVm8;
    @Basic(optional = false)
    @Column(name = "cam_vm9")
    private String camVm9;
    @Basic(optional = false)
    @Column(name = "cam_vm10")
    private String camVm10;
    @Basic(optional = false)
    @Column(name = "cam_vm11")
    private String camVm11;
    @Basic(optional = false)
    @Column(name = "cam_vm12")
    private String camVm12;
    @Basic(optional = false)
    @Column(name = "cam_vm13")
    private String camVm13;
    @Basic(optional = false)
    @Column(name = "cam_vm14")
    private String camVm14;
    @Basic(optional = false)
    @Column(name = "cam_vm15")
    private String camVm15;
    @Basic(optional = false)
    @Column(name = "cam_vm16")
    private String camVm16;

    public CamstarData() {
    }

    public CamstarData(Integer id) {
        this.id = id;
    }
    public CamstarData(String lotID, String program, String programVersion, String devicePackage,String device, String testCode, String operation,
    String qtyIn, String qtyOut){
        this.camLot=lotID;
        this.camTprog= program;
        this.camTrev=programVersion;
        this.camPackage=devicePackage;
        this.camDevice=device;
        this.camTcode=testCode;
        this.camOper=operation;
        this.camQtyin=qtyIn;
        this.camQtyout=qtyOut;
    }

    public void CamstarData(Integer id, String camPline, String camType, String camInsert, String camDevice, String camPackage, String camLot, String camOper, String camMother, String camTester, String camTcode, String camTprog, String camTrev, String camQtyin, String camQtyout, String camYield, String camRej1, String camRej2, String camRej3, String camRej4, String camRej5, String camRej6, String camRej7, String camRej8, String camRej9, String camRej10, String camRej11, String camRej12, String camRej13, String camRej14, String camRej15, String camRej16, String camRejoth, String camHandler, String camPartname, String camOpn, String camFablotnumber, String camAssemblyPart, String camAspen, String camTestPhase, String camReclaimCount, String camNr1, String camNr2, String camNr3, String camNr4, String camNr5, String camNr6, String camNr7, String camNr8, String camNr9, String camNr10, String camNr11, String camNr12, String camNr13, String camNr14, String camNr15, String camNr16, String camVm1, String camVm2, String camVm3, String camVm4, String camVm5, String camVm6, String camVm7, String camVm8, String camVm9, String camVm10, String camVm11, String camVm12, String camVm13, String camVm14, String camVm15, String camVm16) {
        this.id = id;
        this.camPline = camPline;
        this.camType = camType;
        this.camInsert = camInsert;
        this.camDevice = camDevice;
        this.camPackage = camPackage;
        this.camLot = camLot;
        this.camOper = camOper;
        this.camMother = camMother;
        this.camTester = camTester;
        this.camTcode = camTcode;
        this.camTprog = camTprog;
        this.camTrev = camTrev;
        this.camQtyin = camQtyin;
        this.camQtyout = camQtyout;
        this.camYield = camYield;
        this.camRej1 = camRej1;
        this.camRej2 = camRej2;
        this.camRej3 = camRej3;
        this.camRej4 = camRej4;
        this.camRej5 = camRej5;
        this.camRej6 = camRej6;
        this.camRej7 = camRej7;
        this.camRej8 = camRej8;
        this.camRej9 = camRej9;
        this.camRej10 = camRej10;
        this.camRej11 = camRej11;
        this.camRej12 = camRej12;
        this.camRej13 = camRej13;
        this.camRej14 = camRej14;
        this.camRej15 = camRej15;
        this.camRej16 = camRej16;
        this.camRejoth = camRejoth;
        this.camHandler = camHandler;
        this.camPartname = camPartname;
        this.camOpn = camOpn;
        this.camFablotnumber = camFablotnumber;
        this.camAssemblyPart = camAssemblyPart;
        this.camAspen = camAspen;
        this.camTestPhase = camTestPhase;
        this.camReclaimCount = camReclaimCount;
        this.camNr1 = camNr1;
        this.camNr2 = camNr2;
        this.camNr3 = camNr3;
        this.camNr4 = camNr4;
        this.camNr5 = camNr5;
        this.camNr6 = camNr6;
        this.camNr7 = camNr7;
        this.camNr8 = camNr8;
        this.camNr9 = camNr9;
        this.camNr10 = camNr10;
        this.camNr11 = camNr11;
        this.camNr12 = camNr12;
        this.camNr13 = camNr13;
        this.camNr14 = camNr14;
        this.camNr15 = camNr15;
        this.camNr16 = camNr16;
        this.camVm1 = camVm1;
        this.camVm2 = camVm2;
        this.camVm3 = camVm3;
        this.camVm4 = camVm4;
        this.camVm5 = camVm5;
        this.camVm6 = camVm6;
        this.camVm7 = camVm7;
        this.camVm8 = camVm8;
        this.camVm9 = camVm9;
        this.camVm10 = camVm10;
        this.camVm11 = camVm11;
        this.camVm12 = camVm12;
        this.camVm13 = camVm13;
        this.camVm14 = camVm14;
        this.camVm15 = camVm15;
        this.camVm16 = camVm16;
    }
    private String insertDataString(){
        String dataString =null;
        dataString= "INSERT INTO datahouse.camstar_data (cam_pline, cam_type, cam_insert, cam_device, cam_package, cam_lot, cam_oper, cam_mother, cam_tester, cam_tcode, cam_tprog, cam_trev, cam_qtyin, cam_qtyout, cam_yield, cam_rej1, cam_rej2, cam_rej3, cam_rej4, cam_rej5, cam_rej6, cam_rej7, cam_rej8, cam_rej9, cam_rej10, cam_rej11, cam_rej12, cam_rej13, cam_rej14, cam_rej15, cam_rej16, cam_rejoth, cam_handler, cam_partname, cam_opn, cam_fablotnumber, cam_assembly_part, cam_aspen, cam_test_phase, cam_reclaim_count, cam_nr1, cam_nr2, cam_nr3, cam_nr4, cam_nr5, cam_nr6, cam_nr7, cam_nr8, cam_nr9, cam_nr10, cam_nr11, cam_nr12, cam_nr13, cam_nr14, cam_nr15, cam_nr16, cam_vm1, cam_vm2, cam_vm3, cam_vm4, cam_vm5, cam_vm6, cam_vm7, cam_vm8, cam_vm9, cam_vm10, cam_vm11, cam_vm12, cam_vm13, cam_vm14, cam_vm15, cam_vm16) ";
        System.out.println(dataString);
        return dataString;
    }
    private String insertDataValue(){
        String dataValue=null;
        dataValue ="VALUES ('MPU', 'ENGR', '1', '" + getCamDevice() +  "', '" + getCamPackage()+ "', '" + getCamLot() + "', '" +getCamOper() +"', 'SM0032496B', '93KC05', '"+ getCamTcode()+ "', '"+getCamTprog() +"', '"+ getCamTrev() +"', '" + this.camQtyin +"', '" + this.camQtyout+"', '95', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '10', '0', '0', '93KC05', ' ', '', 'U57B5.00', '5900SB3EBOL968I2', 'SMR0032743_FT', 'FT', '0', '152', '29', '7', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0')";
        System.out.println(dataValue);
        return dataValue;
    }
    
    //INSERT INTO datahouse.camstar_data (cam_pline, cam_type, cam_insert, cam_device, cam_package, cam_lot, cam_oper, cam_mother, cam_tester, cam_tcode, cam_tprog, cam_trev, cam_qtyin, cam_qtyout, cam_yield, cam_rej1, cam_rej2, cam_rej3, cam_rej4, cam_rej5, cam_rej6, cam_rej7, cam_rej8, cam_rej9, cam_rej10, cam_rej11, cam_rej12, cam_rej13, cam_rej14, cam_rej15, cam_rej16, cam_rejoth, cam_handler, cam_partname, cam_opn, cam_fablotnumber, cam_assembly_part, cam_aspen, cam_test_phase, cam_reclaim_count, cam_nr1, cam_nr2, cam_nr3, cam_nr4, cam_nr5, cam_nr6, cam_nr7, cam_nr8, cam_nr9, cam_nr10, cam_nr11, cam_nr12, cam_nr13, cam_nr14, cam_nr15, cam_nr16, cam_vm1, cam_vm2, cam_vm3, cam_vm4, cam_vm5, cam_vm6, cam_vm7, cam_vm8, cam_vm9, cam_vm10, cam_vm11, cam_vm12, cam_vm13, cam_vm14, cam_vm15, cam_vm16) 
	//"VALUES ('MPU', 'ENGR', '1', '" + getCamDevice() +  "', '" + getCamPackage()+ "', '" + getCamLot + "', '" +getCamOper() +"', 'SM0032496B', '93KC05', '"+ getCamTcode()+ "', 'STXFP4XX0A0AFP0', '5.2', '200', '190', '95', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '10', '0', '0', '93KC05', ' ', '', 'U57B5.00', '5900SB3EBOL968I2', 'SMR0032743_FT', 'FT', '0', '152', '29', '7', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0')";

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCamPline() {
        return camPline;
    }

    public void setCamPline(String camPline) {
        this.camPline = camPline;
    }

    public String getCamType() {
        return camType;
    }

    public void setCamType(String camType) {
        this.camType = camType;
    }

    public String getCamInsert() {
        return camInsert;
    }

    public void setCamInsert(String camInsert) {
        this.camInsert = camInsert;
    }

    public String getCamDevice() {
        return camDevice;
    }

    public void setCamDevice(String camDevice) {
        this.camDevice = camDevice;
    }

    public String getCamPackage() {
        return camPackage;
    }

    public void setCamPackage(String camPackage) {
        this.camPackage = camPackage;
    }

    public String getCamLot() {
        return camLot;
    }

    public void setCamLot(String camLot) {
        this.camLot = camLot;
    }

    public String getCamOper() {
        return camOper;
    }

    public void setCamOper(String camOper) {
        this.camOper = camOper;
    }

    public String getCamMother() {
        return camMother;
    }

    public void setCamMother(String camMother) {
        this.camMother = camMother;
    }

    public String getCamTester() {
        return camTester;
    }

    public void setCamTester(String camTester) {
        this.camTester = camTester;
    }

    public String getCamTcode() {
        return camTcode;
    }

    public void setCamTcode(String camTcode) {
        this.camTcode = camTcode;
    }

    public String getCamTprog() {
        return camTprog;
    }

    public void setCamTprog(String camTprog) {
        this.camTprog = camTprog;
    }

    public String getCamTrev() {
        return camTrev;
    }

    public void setCamTrev(String camTrev) {
        this.camTrev = camTrev;
    }

    public String getCamQtyin() {
        return camQtyin;
    }

    public void setCamQtyin(String camQtyin) {
        this.camQtyin = camQtyin;
    }

    public String getCamQtyout() {
        return camQtyout;
    }

    public void setCamQtyout(String camQtyout) {
        this.camQtyout = camQtyout;
    }

    public String getCamYield() {
        return camYield;
    }

    public void setCamYield(String camYield) {
        this.camYield = camYield;
    }

    public String getCamRej1() {
        return camRej1;
    }

    public void setCamRej1(String camRej1) {
        this.camRej1 = camRej1;
    }

    public String getCamRej2() {
        return camRej2;
    }

    public void setCamRej2(String camRej2) {
        this.camRej2 = camRej2;
    }

    public String getCamRej3() {
        return camRej3;
    }

    public void setCamRej3(String camRej3) {
        this.camRej3 = camRej3;
    }

    public String getCamRej4() {
        return camRej4;
    }

    public void setCamRej4(String camRej4) {
        this.camRej4 = camRej4;
    }

    public String getCamRej5() {
        return camRej5;
    }

    public void setCamRej5(String camRej5) {
        this.camRej5 = camRej5;
    }

    public String getCamRej6() {
        return camRej6;
    }

    public void setCamRej6(String camRej6) {
        this.camRej6 = camRej6;
    }

    public String getCamRej7() {
        return camRej7;
    }

    public void setCamRej7(String camRej7) {
        this.camRej7 = camRej7;
    }

    public String getCamRej8() {
        return camRej8;
    }

    public void setCamRej8(String camRej8) {
        this.camRej8 = camRej8;
    }

    public String getCamRej9() {
        return camRej9;
    }

    public void setCamRej9(String camRej9) {
        this.camRej9 = camRej9;
    }

    public String getCamRej10() {
        return camRej10;
    }

    public void setCamRej10(String camRej10) {
        this.camRej10 = camRej10;
    }

    public String getCamRej11() {
        return camRej11;
    }

    public void setCamRej11(String camRej11) {
        this.camRej11 = camRej11;
    }

    public String getCamRej12() {
        return camRej12;
    }

    public void setCamRej12(String camRej12) {
        this.camRej12 = camRej12;
    }

    public String getCamRej13() {
        return camRej13;
    }

    public void setCamRej13(String camRej13) {
        this.camRej13 = camRej13;
    }

    public String getCamRej14() {
        return camRej14;
    }

    public void setCamRej14(String camRej14) {
        this.camRej14 = camRej14;
    }

    public String getCamRej15() {
        return camRej15;
    }

    public void setCamRej15(String camRej15) {
        this.camRej15 = camRej15;
    }

    public String getCamRej16() {
        return camRej16;
    }

    public void setCamRej16(String camRej16) {
        this.camRej16 = camRej16;
    }

    public String getCamRejoth() {
        return camRejoth;
    }

    public void setCamRejoth(String camRejoth) {
        this.camRejoth = camRejoth;
    }

    public String getCamHandler() {
        return camHandler;
    }

    public void setCamHandler(String camHandler) {
        this.camHandler = camHandler;
    }

    public String getCamPartname() {
        return camPartname;
    }

    public void setCamPartname(String camPartname) {
        this.camPartname = camPartname;
    }

    public String getCamOpn() {
        return camOpn;
    }

    public void setCamOpn(String camOpn) {
        this.camOpn = camOpn;
    }

    public String getCamFablotnumber() {
        return camFablotnumber;
    }

    public void setCamFablotnumber(String camFablotnumber) {
        this.camFablotnumber = camFablotnumber;
    }

    public String getCamAssemblyPart() {
        return camAssemblyPart;
    }

    public void setCamAssemblyPart(String camAssemblyPart) {
        this.camAssemblyPart = camAssemblyPart;
    }

    public String getCamAspen() {
        return camAspen;
    }

    public void setCamAspen(String camAspen) {
        this.camAspen = camAspen;
    }

    public String getCamTestPhase() {
        return camTestPhase;
    }

    public void setCamTestPhase(String camTestPhase) {
        this.camTestPhase = camTestPhase;
    }

    public String getCamReclaimCount() {
        return camReclaimCount;
    }

    public void setCamReclaimCount(String camReclaimCount) {
        this.camReclaimCount = camReclaimCount;
    }

    public String getCamNr1() {
        return camNr1;
    }

    public void setCamNr1(String camNr1) {
        this.camNr1 = camNr1;
    }

    public String getCamNr2() {
        return camNr2;
    }

    public void setCamNr2(String camNr2) {
        this.camNr2 = camNr2;
    }

    public String getCamNr3() {
        return camNr3;
    }

    public void setCamNr3(String camNr3) {
        this.camNr3 = camNr3;
    }

    public String getCamNr4() {
        return camNr4;
    }

    public void setCamNr4(String camNr4) {
        this.camNr4 = camNr4;
    }

    public String getCamNr5() {
        return camNr5;
    }

    public void setCamNr5(String camNr5) {
        this.camNr5 = camNr5;
    }

    public String getCamNr6() {
        return camNr6;
    }

    public void setCamNr6(String camNr6) {
        this.camNr6 = camNr6;
    }

    public String getCamNr7() {
        return camNr7;
    }

    public void setCamNr7(String camNr7) {
        this.camNr7 = camNr7;
    }

    public String getCamNr8() {
        return camNr8;
    }

    public void setCamNr8(String camNr8) {
        this.camNr8 = camNr8;
    }

    public String getCamNr9() {
        return camNr9;
    }

    public void setCamNr9(String camNr9) {
        this.camNr9 = camNr9;
    }

    public String getCamNr10() {
        return camNr10;
    }

    public void setCamNr10(String camNr10) {
        this.camNr10 = camNr10;
    }

    public String getCamNr11() {
        return camNr11;
    }

    public void setCamNr11(String camNr11) {
        this.camNr11 = camNr11;
    }

    public String getCamNr12() {
        return camNr12;
    }

    public void setCamNr12(String camNr12) {
        this.camNr12 = camNr12;
    }

    public String getCamNr13() {
        return camNr13;
    }

    public void setCamNr13(String camNr13) {
        this.camNr13 = camNr13;
    }

    public String getCamNr14() {
        return camNr14;
    }

    public void setCamNr14(String camNr14) {
        this.camNr14 = camNr14;
    }

    public String getCamNr15() {
        return camNr15;
    }

    public void setCamNr15(String camNr15) {
        this.camNr15 = camNr15;
    }

    public String getCamNr16() {
        return camNr16;
    }

    public void setCamNr16(String camNr16) {
        this.camNr16 = camNr16;
    }

    public String getCamVm1() {
        return camVm1;
    }

    public void setCamVm1(String camVm1) {
        this.camVm1 = camVm1;
    }

    public String getCamVm2() {
        return camVm2;
    }

    public void setCamVm2(String camVm2) {
        this.camVm2 = camVm2;
    }

    public String getCamVm3() {
        return camVm3;
    }

    public void setCamVm3(String camVm3) {
        this.camVm3 = camVm3;
    }

    public String getCamVm4() {
        return camVm4;
    }

    public void setCamVm4(String camVm4) {
        this.camVm4 = camVm4;
    }

    public String getCamVm5() {
        return camVm5;
    }

    public void setCamVm5(String camVm5) {
        this.camVm5 = camVm5;
    }

    public String getCamVm6() {
        return camVm6;
    }

    public void setCamVm6(String camVm6) {
        this.camVm6 = camVm6;
    }

    public String getCamVm7() {
        return camVm7;
    }

    public void setCamVm7(String camVm7) {
        this.camVm7 = camVm7;
    }

    public String getCamVm8() {
        return camVm8;
    }

    public void setCamVm8(String camVm8) {
        this.camVm8 = camVm8;
    }

    public String getCamVm9() {
        return camVm9;
    }

    public void setCamVm9(String camVm9) {
        this.camVm9 = camVm9;
    }

    public String getCamVm10() {
        return camVm10;
    }

    public void setCamVm10(String camVm10) {
        this.camVm10 = camVm10;
    }

    public String getCamVm11() {
        return camVm11;
    }

    public void setCamVm11(String camVm11) {
        this.camVm11 = camVm11;
    }

    public String getCamVm12() {
        return camVm12;
    }

    public void setCamVm12(String camVm12) {
        this.camVm12 = camVm12;
    }

    public String getCamVm13() {
        return camVm13;
    }

    public void setCamVm13(String camVm13) {
        this.camVm13 = camVm13;
    }

    public String getCamVm14() {
        return camVm14;
    }

    public void setCamVm14(String camVm14) {
        this.camVm14 = camVm14;
    }

    public String getCamVm15() {
        return camVm15;
    }

    public void setCamVm15(String camVm15) {
        this.camVm15 = camVm15;
    }

    public String getCamVm16() {
        return camVm16;
    }

    public void setCamVm16(String camVm16) {
        this.camVm16 = camVm16;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CamstarData)) {
            return false;
        }
        CamstarData other = (CamstarData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "programdatagenerator.simulationdata.CamstarData[ id=" + id + " ]";
    }
    public void insertCamStarData(){
        String url ="jdbc:mysql://vsuzatedev04:3306/datahouse?zeroDateTimeBehavior=convertToNull";
        Connection connection = null;
        String sql;
        try{

        
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, "datasystem", "amd@123");
            Statement statement = connection.createStatement();
            
            sql= "SELECT * FROM unit where unit.sub_lot_id_pk=2";
            boolean success =statement.execute(this.insertDataString() + this.insertDataValue());
//            ResultSet result =statement.executeQuery(sql);
    
           
      
        
        }
        catch (SQLException ex)
        {
            System.err.println ("Cannot connect to database server (SQLException)");
            System.out.println(ex.getMessage());
        }
        catch (ClassNotFoundException ex) {
            System.err.println ("Cannot connect to database server (ClassNotFoundException)");
            System.out.println(ex.getMessage());
        }
        catch (InstantiationException ex) {
            System.err.println ("Cannot connect to database server (InstantiationException)");
            System.out.println(ex.getMessage());
        }
        catch (IllegalAccessException ex) {
            System.err.println ("Cannot connect to database server (IllegalAccesException)");
            System.out.println(ex.getMessage());
        }
        finally
        {
            if (connection != null)
            {
                try
                {
                    connection.close ();
                    System.out.println ("Database connection terminated");
                }
                catch (Exception e) { /* ignore close errors */ }
            }
        }
    }
    
}
