package org.example;

import org.example.iec61850.datatypes.logicalNodes.common.LN;
import org.example.iec61850.datatypes.logicalNodes.protocol.LSVS;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final List<LN> logicalNodes = new ArrayList<>();
    private static String path = "C:\\Users\\Roman\\Desktop\\АЛГОСЫ\\LR1\\Опыты\\Начало линии\\PhA80.cfg\\";
    private static String name = "PhA80";

    public static void main(String[] args) {

        LSVS lsvs = new LSVS();
        lsvs.setPath(path);
        lsvs.setFileName(name);
        logicalNodes.add(lsvs);

        MMXU mmxu = new MMXU();
        mmxu.IaInst = lsvs.getOut().get(0);
        mmxu.IbInst = lsvs.getOut().get(1);
        mmxu.IcInst = lsvs.getOut().get(2);



    }
}