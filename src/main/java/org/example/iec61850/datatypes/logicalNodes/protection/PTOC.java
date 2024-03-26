package org.example.iec61850.datatypes.logicalNodes.protection;

import org.example.iec61850.datatypes.logicalNodes.common.LN;
import org.example.iec61850.datatypes.measurements.WYE;
import org.example.iec61850.datatypes.protection.ACD;
import org.example.iec61850.datatypes.protection.ACT;
import org.example.iec61850.datatypes.settings.ASG;
import org.example.iec61850.datatypes.settings.ING;

/**
 * Класс, описывающий токовую защиту
 */

public class PTOC extends LN {

    public static double dt = 0.0000250; // милли сек

    /* Входы  */

    public WYE A = new WYE();


    /* Выходы  */

    public ACD str = new ACD(); // Пуск
    public ACT Op = new ACT(); // Срабатывание



    /* Уставки  */

    public ASG StrVal = new ASG(); // Начальное значение

    public ING OpDITmms = new ING(); // Время задержки срабатывания



    /* Переменные  */

    private int cntTimeA = 0;
    private int cntTimeB = 0;
    private int cntTimeC = 0;



    @Override
    public void process() {


        boolean strA = A.getPhsA().getMag().getF().getValue > StrVal.getSetMag().getF().getValue();
        boolean strB = A.getPhsB().getMag().getF().getValue > StrVal.getSetMag().getF().getValue();
        boolean strC = A.getPhsC().getMag().getF().getValue > StrVal.getSetMag().getF().getValue();



        Str.getGeneral().setValue(strA || strB || strC);

        Str.getPhsA.setValue(strA);
        Str.getPhsB.setValue(strB);
        Str.getPhsC.setValue(strC);


        cntTimeA = strA ? cntTimeA + 1 : 0;
        cntTimeB = strB ? cntTimeB + 1 : 0;
        cntTimeC = strC ? cntTimeC + 1 : 0;


        Op.getPhsA().setValue(cntTimeA * dt > OpDITmms.getSetVal.getValue());
        Op.getPhsA().setValue(cntTimeA * dt > OpDITmms.getSetVal.getValue());
        Op.getPhsA().setValue(cntTimeA * dt > OpDITmms.getSetVal.getValue());
        Op.getGeneral().setValue(getPhsA.);

    }
}