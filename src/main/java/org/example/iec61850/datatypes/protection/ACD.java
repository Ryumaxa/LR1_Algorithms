package org.example.iec61850.datatypes.protection;

import org.example.iec61850.datatypes.common.Attribute;

/**
 * Класс для представления сведений об активации направленной защиты
 */

public class ACD extends ACT{

    private Attribute<Direction> dirGeneral = new Attribute<>(false);
    private Attribute<Direction> dirPhsA = new Attribute<>(false);
    private Attribute<Direction> dirPhsB = new Attribute<>(false);
    private Attribute<Direction> dirPhsC = new Attribute<>(false);
    private Attribute<Direction> dirNeut = new Attribute<>(false);


}
