package org.example;

import org.example.iec61850.datatypes.logicalNodes.breakers.CSWI;
import org.example.iec61850.datatypes.logicalNodes.breakers.XCBR;
import org.example.iec61850.datatypes.logicalNodes.common.LN;
import org.example.iec61850.datatypes.logicalNodes.hmi.NHMI;
import org.example.iec61850.datatypes.logicalNodes.hmi.other.NHMISignal;
import org.example.iec61850.datatypes.logicalNodes.measurements.MMXU;
import org.example.iec61850.datatypes.logicalNodes.protection.PTOC;
import org.example.iec61850.datatypes.logicalNodes.protocol.LSVS;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final List<LN> logicalNodes = new ArrayList<>();
//    private static String path = "C:\\Users\\Roman\\Desktop\\АЛГОСЫ\\LR1\\Опыты\\Начало линии";
    private static String path = "C:\\Users\\Roman\\Desktop\\АЛГОСЫ\\LR1\\Опыты\\Конец линии";
//    private static String name = "PhABC20"; // В конце линии
    private static String name = "PhC20"; // В конце линии
//    private static String name = "PhB20"; // В начале линии
//    private static String name = "PhBC20"; // В начале линии

    public static void main(String[] args) throws IOException {

        LSVS lsvs = new LSVS();
        logicalNodes.add(lsvs);
        lsvs.readCsv(path, name);

        MMXU mmxu = new MMXU();
        logicalNodes.add(mmxu);
        mmxu.IaInst = lsvs.getOut().get(0);
        mmxu.IbInst = lsvs.getOut().get(1);
        mmxu.IcInst = lsvs.getOut().get(2);

        PTOC ptoc1 = new PTOC();
        logicalNodes.add(ptoc1);
        ptoc1.A = mmxu.A;
        ptoc1.StrVal.getSetMag().getF().setValue(3000.0);
        ptoc1.OpDITmms.getSetVal().setValue(0);
        ptoc1.TmMult.getStepSize().getF().setValue(20.0 / 20);

        PTOC ptoc2 = new PTOC();
        logicalNodes.add(ptoc2);
        ptoc2.A = mmxu.A;
        ptoc2.StrVal.getSetMag().getF().setValue(583.0);
        ptoc2.OpDITmms.getSetVal().setValue(300);
        ptoc2.TmMult.getStepSize().getF().setValue(20.0 / 20);

        PTOC ptoc3 = new PTOC();
        logicalNodes.add(ptoc3);
        ptoc3.A = mmxu.A;
        ptoc3.StrVal.getSetMag().getF().setValue(356.72);
        ptoc3.OpDITmms.getSetVal().setValue(600);
        ptoc3.TmMult.getStepSize().getF().setValue(20.0 / 20);

        CSWI cswi = new CSWI();
        logicalNodes.add(cswi);
        cswi.SignalsList.add(ptoc1.Op);
        cswi.SignalsList.add(ptoc2.Op);
        cswi.SignalsList.add(ptoc3.Op);

        XCBR xcbr = new XCBR();
        logicalNodes.add(xcbr);
        xcbr.Pos = cswi.Pos;

        NHMI nhmiCurrents = new NHMI();
        logicalNodes.add(nhmiCurrents);
        nhmiCurrents.addSignals(
                new NHMISignal("ia", lsvs.getOut().get(0).getInstMag().getF())
        );
        nhmiCurrents.addSignals(
                new NHMISignal("ib", lsvs.getOut().get(1).getInstMag().getF())
        );
        nhmiCurrents.addSignals(
                new NHMISignal("ic", lsvs.getOut().get(2).getInstMag().getF())
        );

        NHMI nhmiAnalog = new NHMI();
        logicalNodes.add(nhmiAnalog);

        nhmiAnalog.addSignals(
                new NHMISignal("rmsA", mmxu.A.getPhsA().getInstCVal().getMag().getF()),
                new NHMISignal("StrValPtoc1", ptoc1.StrVal.getSetMag().getF()),
                new NHMISignal("StrValPtoc2", ptoc2.StrVal.getSetMag().getF()),
                new NHMISignal("StrValPtoc3", ptoc3.StrVal.getSetMag().getF())
        );
        nhmiAnalog.addSignals(
                new NHMISignal("rmsB", mmxu.A.getPhsB().getInstCVal().getMag().getF()),
                new NHMISignal("StrValPtoc1", ptoc1.StrVal.getSetMag().getF()),
                new NHMISignal("StrValPtoc2", ptoc2.StrVal.getSetMag().getF()),
                new NHMISignal("StrValPtoc3", ptoc3.StrVal.getSetMag().getF())
        );
        nhmiAnalog.addSignals(
                new NHMISignal("rmsC", mmxu.A.getPhsC().getInstCVal().getMag().getF()),
                new NHMISignal("StrValPtoc1", ptoc1.StrVal.getSetMag().getF()),
                new NHMISignal("StrValPtoc2", ptoc2.StrVal.getSetMag().getF()),
                new NHMISignal("StrValPtoc3", ptoc3.StrVal.getSetMag().getF())
        );

        NHMI nhmiProtectionWorking = new NHMI();
        logicalNodes.add(nhmiProtectionWorking);
        nhmiProtectionWorking.addSignals(
                new NHMISignal("StrPtoc1", ptoc1.Str.getGeneral())
        );
        nhmiProtectionWorking.addSignals(
                new NHMISignal("OpPtoc1", ptoc1.Op.getGeneral())
        );
        nhmiProtectionWorking.addSignals(
                new NHMISignal("StrPtoc2", ptoc2.Str.getGeneral())
        );
        nhmiProtectionWorking.addSignals(
                new NHMISignal("OpPtoc2", ptoc2.Op.getGeneral())
        );
        nhmiProtectionWorking.addSignals(
                new NHMISignal("StrPtoc3", ptoc3.Str.getGeneral())
        );
        nhmiProtectionWorking.addSignals(
                new NHMISignal("OpPtoc3", ptoc3.Op.getGeneral())
        );

        while (lsvs.hasData()) {
            logicalNodes.forEach(LN::process);
        }
    }
}