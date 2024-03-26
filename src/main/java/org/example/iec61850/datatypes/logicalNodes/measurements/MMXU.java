package org.example.iec61850.datatypes.logicalNodes.measurements;

import org.example.iec61850.datatypes.logicalNodes.common.LN;
import org.example.iec61850.datatypes.measurements.SAV;
import org.example.iec61850.datatypes.measurements.WYE;
import org.example.iec61850.datatypes.utils.Filter;
import org.example.iec61850.datatypes.utils.MsdFilter;

public class MMXU extends LN {

    public static int busSize = 50;

    /* Входы */

    public SAV UaInst = new SAV();
    public SAV UbInst = new SAV();
    public SAV UcInst = new SAV();

    public SAV IaInst = new SAV();
    public SAV IbInst = new SAV();
    public SAV IcInst = new SAV();

    /* Выходы */

    public WYE A = new WYE(); // Фазные токи (IL1, IL2, IL3)


    /* Переменные */


    private final Filter ia = new MsdFilter(busSize);
    private final Filter ib = new MsdFilter(busSize);
    private final Filter ic = new MsdFilter(busSize);


    @Override
    public void process() {
        this.ia.process(this.IaInst, A.getPhsA().getCval);
    }
}
