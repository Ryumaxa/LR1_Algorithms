package org.example.iec61850.datatypes.utils;

import org.example.iec61850.datatypes.measurements.SAV;
import org.example.iec61850.datatypes.measurements.Vector;

public class MsdFilter extends Filter{

    private double[] buffer;
    private int cnt = 0;

    private double sum = 0.0;



    private double k = 1.0;


    public MsdFilter(int bufSize){
        this.buffer = new double[bufSize];
        this.k = 1.0/bufSize;

    }

    @Override
    public void process(SAV instMag, Vector vector) {

        double instValueMod = Math.abs(instMag.getInstMag().getF().getValue());
        this.sum = this.sum + instValueMod - this.buffer[cnt];
        this.buffer[cnt] = instValueMod;

        vector.getMag().getF().setValue(this.sum * k);

        if(cnt++ >= buffer.length) cnt = 0;

    }
}
