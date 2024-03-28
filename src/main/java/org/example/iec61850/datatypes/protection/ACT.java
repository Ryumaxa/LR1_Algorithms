package org.example.iec61850.datatypes.protection;

import lombok.Getter;
import lombok.Setter;
import org.example.iec61850.datatypes.common.Attribute;
import org.example.iec61850.datatypes.common.Data;
import org.example.iec61850.datatypes.common.Quality;
import org.example.iec61850.datatypes.common.Timestamp;

/**
 * Класс для представления сведений об активации защиты
 */

@Getter @Setter
public class ACT extends Data {

    private Attribute<Boolean> general = new Attribute<>(false);
    private Attribute<Boolean> phsA = new Attribute<>(false);
    private Attribute<Boolean> phsB = new Attribute<>(false);
    private Attribute<Boolean> phsC = new Attribute<>(false);
    private Attribute<Boolean> neut = new Attribute<>(false);

    private Quality q = new Quality();
    private Timestamp t = new Timestamp();

    private Timestamp operTmPhsA = new Timestamp();

    private Timestamp operTmPhsB = new Timestamp();

    private Timestamp operTmPhsC = new Timestamp();

}
