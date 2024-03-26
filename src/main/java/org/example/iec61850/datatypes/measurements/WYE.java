package org.example.iec61850.datatypes.measurements;


import lombok.Getter;
import lombok.Setter;
import org.example.iec61850.datatypes.common.Data;

/**
 * Класс для описания трехфазного сигнала в комплексном виде
 */

@Getter @Setter
public class WYE extends Data {
    private CMV phsA = new CMV();
    private CMV phsB = new CMV();
    private CMV phsC = new CMV();
    private CMV neut = new CMV();
}
