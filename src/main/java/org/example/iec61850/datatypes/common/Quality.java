package org.example.iec61850.datatypes.common;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Quality extends Data {
    private Attribute<VALIDITY> validity = new Attribute<>();
    private Attribute<Boolean> overflow = new Attribute<>(false);
    private Attribute<Boolean> outOfRange = new Attribute<>(false);
    private Attribute<Boolean> badReference = new Attribute<>(false);
    private Attribute<Boolean> oscillatory = new Attribute<>(false);
    private Attribute<Boolean> failure = new Attribute<>(false);
    private Attribute<Boolean> oldData = new Attribute<>(false);
    private Attribute<Boolean> inconsistent = new Attribute<>(false);
    private Attribute<Boolean> inaccurate = new Attribute<>(false);
    private SOURCE source = SOURCE.PROCESS;
    private Attribute<Boolean> test = new Attribute<>(false);
    private Attribute<Boolean> operatorBlocked = new Attribute<>(false);

    public enum VALIDITY{
        GOOD, INVALID, RESERVED, QUESTIONABLE
    }
    public enum SOURCE{
        PROCESS, SUBSTITUTED
    }

}

