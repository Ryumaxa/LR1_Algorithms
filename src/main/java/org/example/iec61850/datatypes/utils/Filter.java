package org.example.iec61850.datatypes.utils;

import org.example.iec61850.datatypes.measurements.CMV;
import org.example.iec61850.datatypes.measurements.SAV;

/**
 * Базовый класс для всех видов фильтров
 */

public abstract class Filter {
    public abstract void process(SAV measuredValue, CMV result);
}
