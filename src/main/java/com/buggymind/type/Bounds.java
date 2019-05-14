package com.buggymind.type;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Bounds {
    private int lower; // inclusive
    private int upper; // inclusive
}
