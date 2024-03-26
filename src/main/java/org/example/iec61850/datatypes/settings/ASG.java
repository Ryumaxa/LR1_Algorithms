package org.example.iec61850.datatypes.settings;


import org.example.iec61850.datatypes.common.Data;
import org.example.iec61850.datatypes.measurements.AnalogueValue;

@lombok.Data
public class ASG extends Data {

    private AnalogueValue setMag = new AnalogueValue();
}
