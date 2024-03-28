package org.example.iec61850.datatypes.measurements;

import lombok.Getter;
import lombok.Setter;
import org.example.iec61850.datatypes.common.Attribute;
import org.example.iec61850.datatypes.common.Data;
import org.example.iec61850.datatypes.common.Quality;
import org.example.iec61850.datatypes.common.Timestamp;

/**
 * Класс для хранения значений аналоговых сигналов
 */

@Getter @Setter
public class AnalogueValue extends Data {
    private Attribute<Double> f = new Attribute<>();
    private Attribute<Integer> i = new Attribute<>();

//    private Quality q;
//    private Timestamp t;
}
