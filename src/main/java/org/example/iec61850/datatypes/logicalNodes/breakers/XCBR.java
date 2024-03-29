package org.example.iec61850.datatypes.logicalNodes.breakers;

import org.example.iec61850.datatypes.controls.DPC;
import org.example.iec61850.datatypes.controls.SPC;
import org.example.iec61850.datatypes.description.DPL;
import org.example.iec61850.datatypes.logicalNodes.common.LN;
import org.example.iec61850.datatypes.protection.BCR;
import org.example.iec61850.datatypes.protection.ENS;
import org.example.iec61850.datatypes.protection.INS;
import org.example.iec61850.datatypes.protection.SPS;
import org.example.iec61850.datatypes.settings.ING;

/**
 * Класс для реализации состояний силового выключателя
 */

public class XCBR extends LN {
    private DPL EEName = new DPL();
    private ENS EEHealth = new ENS();
    private SPS LocKey = new SPS();
    private SPS Loc = new SPS();
    private INS OpCnt = new INS();
    private ENS CBOpCap = new ENS();
    private ENS POWCap = new ENS();
    private INS MaxOpCap = new INS();
    private SPS Dsc = new SPS();
    private BCR SumSwARs = new BCR();
    private SPC LocSta = new SPC();
    public DPC Pos = new DPC();
    public SPC BlkOpn = new SPC();
    public SPC BlkCls = new SPC();
    private SPC ChaMotEna = new SPC();
    private ING CBTmms = new ING();

    @Override
    public void process() {

    }
}
