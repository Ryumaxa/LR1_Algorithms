package org.example.iec61850.datatypes.logicalNodes.hmi.other;


import org.example.iec61850.datatypes.common.Attribute;

/**
 * @author Александр Холодов
 * @created 01.2021
 * @project RPA-MPEI
 * @description Сигнал для построения графиков
 */
public class NHMISignal {

    private final String name;
    private final Attribute<?> dataX, dataY;

    public NHMISignal(String name, Attribute<?> data) { this.name = name; this.dataX = null; this.dataY = data; }
    public NHMISignal(String name, Attribute<?> dataX, Attribute<?> dataY) { this.name = name; this.dataX = dataX; this.dataY = dataY; }

    public String getName() { return name; }
    public Attribute<?> getDataX() { return dataX; }
    public Attribute<?> getDataY() { return dataY; }
}
