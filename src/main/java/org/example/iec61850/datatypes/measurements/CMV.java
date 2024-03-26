package org.example.iec61850.datatypes.measurements;

import lombok.Getter;
import lombok.Setter;
import org.example.iec61850.datatypes.common.Data;
import org.example.iec61850.datatypes.common.Quality;
import org.example.iec61850.datatypes.common.Timestamp;

/**
 * Класс для описания комплексных измеренных значений
 */

@Getter @Setter
public class CMV extends Data {
    private Vector cVal = new Vector();
    private Quality q = new Quality();
    private Timestamp t = new Timestamp();
}
