package org.example.iec61850.datatypes.common;


/**
 * Должен содержать сведения об инициаторе последнего изменения атрибута данных
 */
public class Originator extends Data{
    private Attribute<OrCat> orCat = new Attribute<>();
    private Attribute<String> orIdent = new Attribute<>();

    public enum OrCat{
        NOT_SUPPORTED, BAY_CONTROL, STATION_CONTROL,
        REMOTE_CONTROL, AUTOMATIC_BAY, AUTOMATIC_STATION,
        AUTOMATIC_REMOTE, MAINTENANCE, PROCESS
    }

}
