package org.example.iec61850.datatypes.logicalNodes.measurements;

import org.example.iec61850.datatypes.logicalNodes.common.LN;
import org.example.iec61850.datatypes.measurements.DEL;
import org.example.iec61850.datatypes.measurements.SAV;
import org.example.iec61850.datatypes.measurements.WYE;
import org.example.iec61850.datatypes.utils.Filter;
import org.example.iec61850.datatypes.utils.Fourier;

/**
 * Класс для описания узла измерений и передачи данных в фильтр
 */
public class MMXU extends LN {

    public static int busSize = 20;

    private SAV TotW = new SAV();
    private SAV TotVAr = new SAV();
    private SAV TotVA = new SAV();
    private SAV TotPF = new SAV();
    private SAV Hz = new SAV();
    private DEL PPV = new DEL();

    private WYE PNV = new WYE();
    private WYE PhV = new WYE();
    private WYE W = new WYE();
    private WYE VAr = new WYE();
    private WYE VA = new WYE();
    private WYE PF = new WYE();
    private WYE Z = new WYE();



    /* Входы */

    public SAV IaInst = new SAV();
    public SAV IbInst = new SAV();
    public SAV IcInst = new SAV();

    /* Выходы */

    public WYE A = new WYE(); // Фазные токи (IL1, IL2, IL3)


    /* Переменные */


    private final Filter ia = new Fourier(busSize);
    private final Filter ib = new Fourier(busSize);
    private final Filter ic = new Fourier(busSize);


    @Override
    public void process() {
//        this.ia.process(this.IaInst, A.getPhsA().getCVal());
//        this.ib.process(this.IbInst, A.getPhsB().getCVal());
//        this.ic.process(this.IcInst, A.getPhsC().getCVal());
        this.ia.process(this.IaInst, A.getPhsA());
        this.ib.process(this.IbInst, A.getPhsB());
        this.ic.process(this.IcInst, A.getPhsC());

    }
}
