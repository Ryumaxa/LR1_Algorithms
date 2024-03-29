package org.example.iec61850.datatypes.logicalNodes.protection;

import org.example.iec61850.datatypes.controls.INC;
import org.example.iec61850.datatypes.description.CSD;
import org.example.iec61850.datatypes.logicalNodes.common.LN;
import org.example.iec61850.datatypes.measurements.WYE;
import org.example.iec61850.datatypes.protection.ACD;
import org.example.iec61850.datatypes.protection.ACT;
import org.example.iec61850.datatypes.settings.*;

/**
 * Класс, описывающий токовую защиту
 */

public class PTOC extends LN {

    public static double dt = 1; // милли сек

    private INC OpCntRs = new INC();
    private CURVE TmACrv = new CURVE();
    private CSG TmAChr33 = new CSG();
    private CSD TmASt = new CSD();

    public ASG TmMult = new ASG();
    private ING MinOpTmms = new ING();
    private ING MaxOpTmms = new ING();
    private ENG TypRsCrv = new ENG();
    private ING RsDiTmms = new ING();
    private ENG DirMod = new ENG();


    /* Входы  */

    public WYE A = new WYE();


    /* Выходы  */

    public ACD Str = new ACD(); // Пуск
    public ACT Op = new ACT(); // Срабатывание



    /* Уставки  */

    public ASG StrVal = new ASG(); // Начальное значение
    public ING OpDITmms = new ING(); // Время задержки срабатывания



    /* Переменные  */

    private int cntTimeA = 0;
    private int cntTimeB = 0;
    private int cntTimeC = 0;

    public PTOC() {
        OpCntRs.getStVal().setValue(0);
        Op.getGeneral().setValue(false);
        Op.getPhsA().setValue(false);
        Op.getPhsB().setValue(false);
        Op.getPhsC().setValue(false);
    }


    @Override
    public void process() {
        boolean strA = A.getPhsA().getInstCVal().getMag().getF().getValue() > StrVal.getSetMag().getF().getValue();
        boolean strB = A.getPhsB().getInstCVal().getMag().getF().getValue() > StrVal.getSetMag().getF().getValue();
        boolean strC = A.getPhsC().getInstCVal().getMag().getF().getValue() > StrVal.getSetMag().getF().getValue();

        Str.getGeneral().setValue(strA || strB || strC);

        Str.getPhsA().setValue(strA);
        Str.getPhsB().setValue(strB);
        Str.getPhsC().setValue(strC);

        cntTimeA = strA ? cntTimeA + 1 : 0;
        cntTimeB = strB ? cntTimeB + 1 : 0;
        cntTimeC = strC ? cntTimeC + 1 : 0;

        Op.getPhsA().setValue(cntTimeA * dt > OpDITmms.getSetVal().getValue());
        Op.getPhsB().setValue(cntTimeB * dt > OpDITmms.getSetVal().getValue());
        Op.getPhsC().setValue(cntTimeC * dt > OpDITmms.getSetVal().getValue());
        Op.getGeneral().setValue(Op.getPhsA().getValue() || Op.getPhsB().getValue() || Op.getPhsC().getValue());
    }
}