package org.example.iec61850.datatypes.common;

public class Unit extends Data{
    private Attribute<Units> SIUnit = new Attribute<>();
    private Attribute<Multiplier> multiplier = new Attribute<>();

    public enum Units{
        AMPERE, VOLT, SECOND, DEGREES, RADIAN, OHM, HERTZ,
        VOLT_AMPERE, WATTS, VOLT_AMPERE_REACTIVE
    }

    public enum Multiplier{
        YOCTO, ZEPTO, ATTO, FEMTO, PICO, NANO, MICRO, MILLI, CENTI, DECI,
        DECA, HECTO, KILO, MEGA, GIGA, TERA, PETA, EXA, ZETTA, YOTTA
    }

}
