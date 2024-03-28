package org.example.iec61850.datatypes.logicalNodes.breakers;

import org.example.iec61850.datatypes.controls.DPC;
import org.example.iec61850.datatypes.controls.INC;
import org.example.iec61850.datatypes.controls.SPC;
import org.example.iec61850.datatypes.logicalNodes.common.LN;
import org.example.iec61850.datatypes.protection.ACT;
import org.example.iec61850.datatypes.protection.SPS;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для управления всеми состояниями переключений
 */

public class CSWI extends LN {
    private SPS LocKey = new SPS();
    private SPS Loc = new SPS();
    public ACT OpOpn = new ACT();
    private SPS SelOpn = new SPS();
    public ACT OpCls =  new ACT();
    private SPS SelCls = new SPS();
    private INC OpCntRs = new INC();
    private SPC LocSta = new SPC();
    public DPC Pos = new DPC();
    public DPC PosA= new DPC();
    public DPC PosB= new DPC();
    public DPC PosC= new DPC();


    public List<ACT> SignalsList = new ArrayList();

    @Override
    public void process() {
        SelOpn.getStVal().setValue(false);
        for (ACT act : SignalsList) {
            if (act.getGeneral().getValue()) {
                SelOpn.getStVal().setValue(true);
                break;
            }
        }
        SelCls.getStVal().setValue(!SelOpn.getStVal().getValue());

        if (SelOpn.getStVal().getValue()) {
            Pos.getStVal().setValue(DPC.Values.OFF);
            PosA.getStVal().setValue(DPC.Values.OFF);
            PosB.getStVal().setValue(DPC.Values.OFF);
            PosC.getStVal().setValue(DPC.Values.OFF);
        } else {
            Pos.getStVal().setValue(DPC.Values.ON);
            PosA.getStVal().setValue(DPC.Values.ON);
            PosB.getStVal().setValue(DPC.Values.ON);
            PosC.getStVal().setValue(DPC.Values.ON);
        }
    }


}
