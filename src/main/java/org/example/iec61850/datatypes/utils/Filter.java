package org.example.iec61850.datatypes.utils;

import org.example.iec61850.datatypes.measurements.CMV;
import org.example.iec61850.datatypes.measurements.SAV;
import org.example.iec61850.datatypes.measurements.Vector;

public abstract class Filter {

    //public abstract void process(SAV instMag , Vector vector);
    public abstract void process(SAV measuredValue, CMV result);
}
